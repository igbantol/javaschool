import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarApp extends JFrame {
    private static final Color APP_BACKGROUND = new Color(245, 247, 251);
    private static final Color CARD_BACKGROUND = Color.WHITE;
    private static final Color NAVY = new Color(30, 41, 59);

    private static final Color PRIMARY = new Color(37, 99, 235);
    private static final Color PRIMARY_DARK = new Color(29, 78, 216);
    private static final Color PRIMARY_PALE = new Color(239, 246, 255);
    private static final Color ACCENT = new Color(245, 158, 11);
    private static final Color MUTED = new Color(100, 116, 139);
    private static final Color GRID_COLOR = new Color(226, 232, 240);
    private static final Color WEEKEND_COLOR = new Color(148, 163, 184);
    private static final Color TODAY_BG = new Color(37, 99, 235);
    private static final DateTimeFormatter LONG_DATE_FORMAT =
        DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
    private static final DateTimeFormatter SHORT_DATE_FORMAT =
        DateTimeFormatter.ofPattern("MMM d, yyyy");
    private static final Font BODY_FONT = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font CELL_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    private JLabel monthLabel;
    private JLabel selectedDateLabel;
    private JLabel eventCountLabel;
    private JTable calendarTable;
    private DefaultTableModel tableModel;
    private DefaultListModel<String> eventListModel;
    private JList<String> eventList;
    private YearMonth currentYearMonth;
    private LocalDate selectedDate;
    private final Map<LocalDate, List<String>> events;
    private final Path eventsFile;

    public CalendarApp() {
        events = new HashMap<>();
        eventsFile = Paths.get(System.getProperty("user.home"), ".calendar-events.txt");
        currentYearMonth = YearMonth.now();
        selectedDate = LocalDate.now();

        loadEvents();
        configureLookAndFeel();

        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1060, 700);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setIconImage(createAppIcon());

        JPanel root = new JPanel(new BorderLayout(18, 18));
        root.setBorder(new EmptyBorder(22, 24, 18, 24));
        root.setBackground(APP_BACKGROUND);
        root.add(createHeader(root), BorderLayout.NORTH);
        root.add(createContent(), BorderLayout.CENTER);

        add(root);
        refreshCalendar();
    }

    private void configureLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // The application still works with Swing's default look and feel.
        }
    }

    private JPanel createHeader(JPanel root) {
        JPanel header = new JPanel(new BorderLayout(16, 0));
        header.setOpaque(false);

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Calendar");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(NAVY);
        titlePanel.add(title);

        JLabel subtitle = new JLabel("Keep your days organized");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(MUTED);
        titlePanel.add(Box.createVerticalStrut(2));
        titlePanel.add(subtitle);

        JButton todayButton = createButton("Today", PRIMARY, Color.WHITE);
        todayButton.setToolTipText("Jump to today (Home)");
        todayButton.addActionListener(e -> goToToday());

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 8));
        actions.setOpaque(false);
        actions.add(todayButton);

        InputMap inputMap = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = root.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("HOME"), "goToToday");
        inputMap.put(KeyStroke.getKeyStroke("ctrl N"), "addEvent");
        actionMap.put("goToToday", new AbstractAction() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) {
                goToToday();
            }
        });
        actionMap.put("addEvent", new AbstractAction() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) {
                promptAddEvent();
            }
        });

        header.add(titlePanel, BorderLayout.WEST);
        header.add(actions, BorderLayout.EAST);
        return header;
    }

    private JComponent createContent() {
        JPanel calendarCard = createCalendarView();
        JPanel sidePanel = createSidePanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, calendarCard, sidePanel);
        splitPane.setResizeWeight(0.74);
        splitPane.setDividerSize(8);
        splitPane.setBorder(null);
        splitPane.setOpaque(false);
        splitPane.setBackground(APP_BACKGROUND);
        return splitPane;
    }

    private JPanel createCalendarView() {
        String[] headers = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        tableModel = new DefaultTableModel(null, headers) {
            @Override public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        calendarTable = new JTable(tableModel);
        calendarTable.setFont(CELL_FONT);
        calendarTable.setRowHeight(72);
        calendarTable.setShowHorizontalLines(true);
        calendarTable.setShowVerticalLines(true);
        calendarTable.setGridColor(GRID_COLOR);
        calendarTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        calendarTable.setCellSelectionEnabled(false);
        calendarTable.setRowSelectionAllowed(false);
        calendarTable.setDefaultRenderer(Object.class, new CalendarCellRenderer());
        calendarTable.setToolTipText("");

        JTableHeader tableHeader = calendarTable.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.BOLD, 11));
        tableHeader.setBackground(NAVY);
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 36));

        calendarTable.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                int row = calendarTable.rowAtPoint(e.getPoint());
                int column = calendarTable.columnAtPoint(e.getPoint());
                selectDateAt(row, column);
                if (e.getClickCount() == 2 && row >= 0 && column >= 0
                    && calendarTable.getValueAt(row, column) != null) {
                    promptAddEvent();
                }
            }
        });

        JPanel toolbar = new JPanel(new BorderLayout(8, 0));
        toolbar.setBackground(CARD_BACKGROUND);
        toolbar.setBorder(new EmptyBorder(14, 16, 12, 16));

        JButton previousButton = navigationButton("‹", "Previous month");
        previousButton.addActionListener(e -> changeMonth(-1));
        JButton nextButton = navigationButton("›", "Next month");
        nextButton.addActionListener(e -> changeMonth(1));

        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        monthLabel.setForeground(NAVY);

        JPanel monthNavigation = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 0));
        monthNavigation.setOpaque(false);
        monthNavigation.add(previousButton);
        monthNavigation.add(monthLabel);
        monthNavigation.add(nextButton);
        toolbar.add(monthNavigation, BorderLayout.CENTER);

        JButton addButton = createButton("+  Add event", PRIMARY, Color.WHITE);
        addButton.setToolTipText("Add an event to the selected date (Ctrl+N)");
        addButton.addActionListener(e -> promptAddEvent());
        toolbar.add(addButton, BorderLayout.EAST);

        JPanel legend = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 0));
        legend.setBackground(CARD_BACKGROUND);
        legend.setBorder(new EmptyBorder(10, 16, 14, 16));
        legend.add(legendItem(TODAY_BG, "Today"));
        legend.add(legendItem(ACCENT, "Has events"));
        JLabel hint = new JLabel("Double-click a date to add an event");
        hint.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        hint.setForeground(MUTED);
        legend.add(hint);

        JScrollPane scrollPane = new JScrollPane(calendarTable);
        scrollPane.setBorder(new EmptyBorder(0, 1, 0, 1));
        scrollPane.getViewport().setBackground(CARD_BACKGROUND);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(CARD_BACKGROUND);
        card.setBorder(new LineBorder(GRID_COLOR, 1, true));
        card.add(toolbar, BorderLayout.NORTH);
        card.add(scrollPane, BorderLayout.CENTER);
        card.add(legend, BorderLayout.SOUTH);
        return card;
    }

    private JLabel legendItem(Color color, String text) {
        JLabel item = new JLabel("●  " + text);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        item.setForeground(color);
        return item;
    }

    private JPanel createSidePanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 12));
        panel.setBackground(CARD_BACKGROUND);
        panel.setBorder(new EmptyBorder(18, 18, 18, 18));
        panel.setPreferredSize(new Dimension(270, 0));

        JPanel heading = new JPanel();
        heading.setOpaque(false);
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));

        JLabel overline = new JLabel("SCHEDULE");
        overline.setFont(new Font("Segoe UI", Font.BOLD, 11));
        overline.setForeground(PRIMARY);
        heading.add(overline);

        selectedDateLabel = new JLabel();
        selectedDateLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        selectedDateLabel.setForeground(NAVY);
        selectedDateLabel.setBorder(new EmptyBorder(5, 0, 0, 0));
        heading.add(selectedDateLabel);

        eventCountLabel = new JLabel();
        eventCountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        eventCountLabel.setForeground(MUTED);
        eventCountLabel.setBorder(new EmptyBorder(4, 0, 0, 0));
        heading.add(eventCountLabel);
        panel.add(heading, BorderLayout.NORTH);

        eventListModel = new DefaultListModel<>();
        eventList = new JList<>(eventListModel);
        eventList.setFont(BODY_FONT);
        eventList.setBackground(new Color(248, 250, 252));
        eventList.setForeground(NAVY);
        eventList.setBorder(new EmptyBorder(5, 8, 5, 8));
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventList.setFixedCellHeight(34);
        eventList.setCellRenderer(new EventCellRenderer());

        JPopupMenu popup = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Delete event");
        deleteMenuItem.addActionListener(e -> deleteSelectedEvent());
        popup.add(deleteMenuItem);
        eventList.setComponentPopupMenu(popup);
        eventList.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                selectEventForPopup(e);
            }
            @Override public void mouseReleased(MouseEvent e) {
                selectEventForPopup(e);
            }
        });

        JScrollPane eventScrollPane = new JScrollPane(eventList);
        eventScrollPane.setBorder(new LineBorder(GRID_COLOR, 1, true));
        eventScrollPane.getVerticalScrollBar().setUnitIncrement(14);
        panel.add(eventScrollPane, BorderLayout.CENTER);

        JButton addButton = createButton("+  Add event", PRIMARY, Color.WHITE);
        addButton.addActionListener(e -> promptAddEvent());
        JButton deleteButton = createButton("Delete selected", new Color(254, 242, 242),
                                            new Color(185, 28, 28));
        deleteButton.addActionListener(e -> deleteSelectedEvent());

        JPanel actions = new JPanel(new GridLayout(2, 1, 0, 8));
        actions.setOpaque(false);
        actions.add(addButton);
        actions.add(deleteButton);
        panel.add(actions, BorderLayout.SOUTH);
        return panel;
    }

    private JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(foreground);
        button.setBackground(background);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(9, 14, 9, 14));
        return button;
    }

    private JButton navigationButton(String text, String tooltip) {
        JButton button = createButton(text, new Color(241, 245, 249), NAVY);
        button.setFont(new Font("Segoe UI", Font.BOLD, 24));
        button.setPreferredSize(new Dimension(38, 34));
        button.setBorder(new EmptyBorder(0, 4, 3, 4));
        button.setToolTipText(tooltip);
        return button;
    }

    private void changeMonth(int amount) {
        currentYearMonth = currentYearMonth.plusMonths(amount);
        int day = Math.min(selectedDate.getDayOfMonth(), currentYearMonth.lengthOfMonth());
        selectedDate = currentYearMonth.atDay(day);
        refreshCalendar();
    }

    private void goToToday() {
        currentYearMonth = YearMonth.now();
        selectedDate = LocalDate.now();
        refreshCalendar();
    }

    private void selectDateAt(int row, int column) {
        if (row < 0 || column < 0) return;
        Object value = calendarTable.getValueAt(row, column);
        if (value instanceof Integer) {
            selectedDate = currentYearMonth.atDay((Integer) value);
            refreshSidePanel();
            calendarTable.repaint();
        }
    }

    private void refreshCalendar() {
        monthLabel.setText(currentYearMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        tableModel.setRowCount(0);
        tableModel.setRowCount(6);

        LocalDate first = currentYearMonth.atDay(1);
        int daysInMonth = currentYearMonth.lengthOfMonth();
        int startColumn = first.getDayOfWeek().getValue() % 7;

        int row = 0;
        int column = startColumn;
        for (int day = 1; day <= daysInMonth; day++) {
            tableModel.setValueAt(day, row, column);
            column++;
            if (column > 6) {
                column = 0;
                row++;
            }
        }

        refreshSidePanel();
        calendarTable.revalidate();
        calendarTable.repaint();
    }

    private void refreshSidePanel() {
        if (selectedDateLabel == null || eventListModel == null) return;

        selectedDateLabel.setText(selectedDate.format(LONG_DATE_FORMAT));
        List<String> dayEvents = events.get(selectedDate);
        int eventCount = dayEvents == null ? 0 : dayEvents.size();
        eventCountLabel.setText(eventCount + (eventCount == 1 ? " event" : " events"));

        eventListModel.clear();
        if (eventCount == 0) {
            eventListModel.addElement("No events for this day");
        } else {
            for (String event : dayEvents) {
                eventListModel.addElement(event);
            }
        }
    }

    private void promptAddEvent() {
        JTextField input = new JTextField(24);
        input.setFont(BODY_FONT);
        JPanel content = new JPanel(new BorderLayout(0, 8));
        content.add(new JLabel("Add an event for " + selectedDate.format(SHORT_DATE_FORMAT) + ":"),
                   BorderLayout.NORTH);
        content.add(input, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, content, "Add event",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION && !input.getText().trim().isEmpty()) {
            events.computeIfAbsent(selectedDate, key -> new ArrayList<>()).add(input.getText().trim());
            saveEvents();
            refreshSidePanel();
            calendarTable.repaint();
        }
    }

    private void selectEventForPopup(MouseEvent event) {
        if (!event.isPopupTrigger()) return;
        int index = eventList.locationToIndex(event.getPoint());
        if (index >= 0 && eventList.getCellBounds(index, index).contains(event.getPoint())) {
            eventList.setSelectedIndex(index);
        }
    }

    private void deleteSelectedEvent() {
        int index = eventList.getSelectedIndex();
        List<String> dayEvents = events.get(selectedDate);
        if (index < 0 || dayEvents == null || index >= dayEvents.size()) return;

        dayEvents.remove(index);
        if (dayEvents.isEmpty()) events.remove(selectedDate);
        saveEvents();
        refreshSidePanel();
        calendarTable.repaint();
    }

    private void loadEvents() {
        if (!Files.exists(eventsFile)) return;
        try {
            for (String line : Files.readAllLines(eventsFile, StandardCharsets.UTF_8)) {
                int pipe = line.indexOf('|');
                if (pipe <= 0) continue;
                try {
                    LocalDate date = LocalDate.parse(line.substring(0, pipe));
                    String event = line.substring(pipe + 1);
                    if (!event.isEmpty()) {
                        events.computeIfAbsent(date, key -> new ArrayList<>()).add(event);
                    }
                } catch (RuntimeException ignored) {
                    // Ignore malformed rows and continue loading valid events.
                }
            }
        } catch (IOException ignored) {
            // The calendar remains usable when the saved-events file is unavailable.
        }
    }

    private void saveEvents() {
        try {
            List<String> lines = new ArrayList<>();
            List<LocalDate> dates = new ArrayList<>(events.keySet());
            Collections.sort(dates);
            for (LocalDate date : dates) {
                for (String event : events.get(date)) {
                    lines.add(date + "|" + event);
                }
            }
            Files.write(eventsFile, lines, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this,
                "Could not save your events:\n" + exception.getMessage(),
                "Save error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Image createAppIcon() {
        int size = 64;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.WHITE);
        graphics.fillRoundRect(5, 10, size - 10, size - 15, 8, 8);
        graphics.setColor(PRIMARY);
        graphics.fillRoundRect(5, 10, size - 10, 15, 8, 8);
        graphics.fillRect(5, 17, size - 10, 8);
        graphics.setColor(NAVY);
        graphics.fillOval(15, 4, 8, 8);
        graphics.fillOval(41, 4, 8, 8);
        graphics.setColor(PRIMARY_DARK);
        graphics.setFont(new Font("Arial", Font.BOLD, 21));
        String day = Integer.toString(LocalDate.now().getDayOfMonth());
        FontMetrics metrics = graphics.getFontMetrics();
        graphics.drawString(day, (size - metrics.stringWidth(day)) / 2, 47);
        graphics.dispose();
        return image;
    }

    private class CalendarCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                         boolean isSelected, boolean hasFocus,
                                                         int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, false, false, row, column);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(CELL_FONT);
            label.setOpaque(true);
            label.setBorder(new EmptyBorder(2, 2, 2, 2));
            label.setToolTipText(null);

            if (!(value instanceof Integer)) {
                label.setBackground(CARD_BACKGROUND);
                label.setForeground(GRID_COLOR);
                label.setText("");
                return label;
            }

            int day = (Integer) value;
            LocalDate cellDate = currentYearMonth.atDay(day);
            boolean today = cellDate.equals(LocalDate.now());
            boolean selected = cellDate.equals(selectedDate);
            List<String> dayEvents = events.get(cellDate);
            boolean hasEvents = dayEvents != null && !dayEvents.isEmpty();
            boolean weekend = column == 0 || column == 6;

            label.setText(hasEvents ? day + "  •" : Integer.toString(day));
            label.setFont(hasEvents ? new Font("Segoe UI", Font.BOLD, 14) : CELL_FONT);
            label.setBackground(today ? TODAY_BG : (selected ? PRIMARY_PALE : CARD_BACKGROUND));
            label.setForeground(today ? Color.WHITE : (weekend ? WEEKEND_COLOR : NAVY));
            if (hasEvents && !today) label.setForeground(ACCENT.darker());

            if (selected) {
                label.setBorder(new LineBorder(today ? Color.WHITE : PRIMARY, 2, true));
            } else if (hasEvents) {
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 3, 0, ACCENT),
                    new EmptyBorder(2, 2, 2, 2)));
            }
            label.setToolTipText(dayEvents == null || dayEvents.isEmpty()
                ? cellDate.format(LONG_DATE_FORMAT)
                : cellDate.format(LONG_DATE_FORMAT) + " — " + dayEvents.size() + " event"
                    + (dayEvents.size() == 1 ? "" : "s"));
            return label;
        }
    }

    private class EventCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
            label.setBorder(new EmptyBorder(7, 8, 7, 8));
            label.setFont(BODY_FONT);
            if ("No events for this day".equals(value)) {
                label.setForeground(MUTED);
                label.setFont(new Font("Segoe UI", Font.ITALIC, 13));
                label.setBackground(new Color(248, 250, 252));
            }
            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalendarApp().setVisible(true));
    }
}
