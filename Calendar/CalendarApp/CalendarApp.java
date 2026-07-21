import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class CalendarApp extends JFrame {
    private static final Color PRIMARY = new Color(52, 73, 94);
    private static final Color PRIMARY_LIGHT = new Color(44, 62, 80);
    private static final Color ACCENT = new Color(231, 76, 60);
    private static final Color TODAY_BG = new Color(41, 128, 185);
    private static final Color TODAY_FG = Color.WHITE;
    private static final Color SELECTED_BG = new Color(189, 195, 199);
    private static final Color EVENTS_PANEL_BG = new Color(248, 249, 250);
    private static final Color GRID_COLOR = new Color(220, 220, 220);
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font CELL_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 12);

    private JLabel monthLabel;
    private JLabel selectedDateLabel;
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

        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 600);
        setLocationRelativeTo(null);
        setIconImage(createAppIcon());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));
        root.setBackground(Color.WHITE);
        root.add(createHeader(), BorderLayout.NORTH);
        root.add(createCalendarView(), BorderLayout.CENTER);
        root.add(createSidePanel(), BorderLayout.EAST);
        selectedDateLabel = new JLabel();
        selectedDateLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        selectedDateLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
        root.add(selectedDateLabel, BorderLayout.SOUTH);

        add(root);
        refreshCalendar();
    }

    private JPanel createHeader() {
        JPanel bar = new JPanel(new BorderLayout(8, 0));
        bar.setBackground(PRIMARY);
        bar.setBorder(new EmptyBorder(10, 14, 10, 14));

        JButton prevBtn = navButton("\u25C0");
        prevBtn.addActionListener(e -> {
            currentYearMonth = currentYearMonth.minusMonths(1);
            refreshCalendar();
        });

        JButton todayBtn = new JButton("Today");
        todayBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        todayBtn.setForeground(Color.WHITE);
        todayBtn.setBackground(PRIMARY_LIGHT);
        todayBtn.setBorderPainted(false);
        todayBtn.setFocusPainted(false);
        todayBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        todayBtn.addActionListener(e -> {
            currentYearMonth = YearMonth.now();
            selectedDate = LocalDate.now();
            refreshCalendar();
        });

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        left.setBackground(PRIMARY);
        left.add(prevBtn);
        left.add(todayBtn);

        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(TITLE_FONT);
        monthLabel.setForeground(Color.WHITE);

        JButton nextBtn = navButton("\u25B6");
        nextBtn.addActionListener(e -> {
            currentYearMonth = currentYearMonth.plusMonths(1);
            refreshCalendar();
        });

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 0));
        right.setBackground(PRIMARY);
        right.add(nextBtn);

        bar.add(left, BorderLayout.WEST);
        bar.add(monthLabel, BorderLayout.CENTER);
        bar.add(right, BorderLayout.EAST);

        return bar;
    }

    private JButton navButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b.setForeground(Color.WHITE);
        b.setBackground(PRIMARY_LIGHT);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setPreferredSize(new Dimension(38, 32));
        return b;
    }

    private JPanel createCalendarView() {
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        tableModel = new DefaultTableModel(null, headers) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };

        calendarTable = new JTable(tableModel);
        calendarTable.setFont(CELL_FONT);
        calendarTable.setRowHeight(54);
        calendarTable.setShowHorizontalLines(true);
        calendarTable.setShowVerticalLines(true);
        calendarTable.setGridColor(GRID_COLOR);
        calendarTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        calendarTable.setSelectionBackground(SELECTED_BG);

        JTableHeader h = calendarTable.getTableHeader();
        h.setFont(HEADER_FONT);
        h.setBackground(PRIMARY_LIGHT);
        h.setForeground(Color.WHITE);
        h.setReorderingAllowed(false);
        h.setResizingAllowed(false);
        h.setPreferredSize(new Dimension(h.getWidth(), 32));

        calendarTable.setDefaultRenderer(Object.class, new CalendarCellRenderer());

        calendarTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = calendarTable.rowAtPoint(e.getPoint());
                int col = calendarTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    Object val = calendarTable.getValueAt(row, col);
                    if (val != null) {
                        selectedDate = currentYearMonth.atDay((int) val);
                        refreshSidePanel();
                        updateStatusLabel();
                        calendarTable.repaint();
                    }
                }
                if (e.getClickCount() == 2) {
                    promptAddEvent();
                }
            }
        });

        JScrollPane sp = new JScrollPane(calendarTable);
        sp.setBorder(null);
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createLineBorder(GRID_COLOR));
        p.add(sp, BorderLayout.CENTER);
        return p;
    }

    private JPanel createSidePanel() {
        JPanel p = new JPanel(new BorderLayout(6, 6));
        p.setBackground(EVENTS_PANEL_BG);
        p.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(GRID_COLOR), new EmptyBorder(10, 10, 10, 10)));
        p.setPreferredSize(new Dimension(220, 0));

        JLabel title = new JLabel("Events", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 14));
        title.setForeground(PRIMARY);
        p.add(title, BorderLayout.NORTH);

        eventListModel = new DefaultListModel<>();
        eventList = new JList<>(eventListModel);
        eventList.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        eventList.setBackground(Color.WHITE);
        eventList.setBorder(new EmptyBorder(4, 4, 4, 4));
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPopupMenu popup = new JPopupMenu();
        JMenuItem del = new JMenuItem("Delete");
        del.addActionListener(e -> deleteSelectedEvent());
        popup.add(del);
        eventList.setComponentPopupMenu(popup);

        p.add(new JScrollPane(eventList), BorderLayout.CENTER);

        JButton addBtn = new JButton("+ Add Event");
        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        addBtn.setBackground(PRIMARY);
        addBtn.setForeground(Color.WHITE);
        addBtn.setBorderPainted(false);
        addBtn.setFocusPainted(false);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.addActionListener(e -> promptAddEvent());
        p.add(addBtn, BorderLayout.SOUTH);

        return p;
    }

    private void refreshCalendar() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        monthLabel.setText(months[currentYearMonth.getMonthValue() - 1] + " " + currentYearMonth.getYear());

        tableModel.setRowCount(0);
        tableModel.setRowCount(6);

        LocalDate first = currentYearMonth.atDay(1);
        int daysInMonth = currentYearMonth.lengthOfMonth();
        int startCol = first.getDayOfWeek().getValue() % 7;

        int row = 0;
        int col = startCol;
        for (int day = 1; day <= daysInMonth; day++) {
            tableModel.setValueAt(day, row, col);
            col++;
            if (col > 6) { col = 0; row++; }
        }

        refreshSidePanel();
        updateStatusLabel();
    }

    private void refreshSidePanel() {
        eventListModel.clear();
        List<String> dayEvents = events.get(selectedDate);
        if (dayEvents != null && !dayEvents.isEmpty()) {
            for (String ev : dayEvents) {
                eventListModel.addElement(ev);
            }
        } else {
            eventListModel.addElement("(No events for this day)");
        }
    }

    private void updateStatusLabel() {
        selectedDateLabel.setText("Selected: " + selectedDate.format(
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy")));
    }

    private void promptAddEvent() {
        String text = JOptionPane.showInputDialog(this,
            "Event for " + selectedDate.format(DateTimeFormatter.ofPattern("MMM d, yyyy")) + ":",
            "Add Event", JOptionPane.PLAIN_MESSAGE);
        if (text != null && !text.trim().isEmpty()) {
            events.computeIfAbsent(selectedDate, k -> new ArrayList<>()).add(text.trim());
            saveEvents();
            refreshSidePanel();
            calendarTable.repaint();
        }
    }

    private void deleteSelectedEvent() {
        int idx = eventList.getSelectedIndex();
        if (idx < 0) return;
        String selected = eventListModel.get(idx);
        if ("(No events for this day)".equals(selected)) return;
        List<String> dayEvents = events.get(selectedDate);
        if (dayEvents != null && idx < dayEvents.size()) {
            dayEvents.remove(idx);
            if (dayEvents.isEmpty()) events.remove(selectedDate);
            saveEvents();
            refreshSidePanel();
            calendarTable.repaint();
        }
    }

    private void loadEvents() {
        try {
            if (Files.exists(eventsFile)) {
                for (String line : Files.readAllLines(eventsFile)) {
                    int pipe = line.indexOf('|');
                    if (pipe > 0) {
                        LocalDate date = LocalDate.parse(line.substring(0, pipe));
                        events.computeIfAbsent(date, k -> new ArrayList<>())
                              .add(line.substring(pipe + 1));
                    }
                }
            }
        } catch (Exception ignored) {}
    }

    private void saveEvents() {
        try {
            List<String> lines = new ArrayList<>();
            for (Map.Entry<LocalDate, List<String>> e : events.entrySet()) {
                for (String ev : e.getValue()) {
                    lines.add(e.getKey().toString() + "|" + ev);
                }
            }
            Files.write(eventsFile, lines);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to save events: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Image createAppIcon() {
        int s = 64;
        BufferedImage img = new BufferedImage(s, s, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRoundRect(4, 10, s - 8, s - 14, 6, 6);

        g.setColor(ACCENT);
        g.fillRoundRect(4, 10, s - 8, 14, 6, 6);
        g.fillRect(4, 16, s - 8, 8);

        g.setColor(PRIMARY);
        g.fillOval(14, 4, 7, 7);
        g.fillOval(43, 4, 7, 7);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        String d = "" + LocalDate.now().getDayOfMonth();
        g.drawString(d, (s - fm.stringWidth(d)) / 2, 46);

        g.dispose();
        return img;
    }

    private class CalendarCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            JLabel lb = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            lb.setHorizontalAlignment(SwingConstants.CENTER);
            lb.setFont(CELL_FONT);

            if (value == null) {
                lb.setBackground(Color.WHITE);
                lb.setForeground(Color.LIGHT_GRAY);
                lb.setBorder(null);
                return lb;
            }

            int day = (int) value;
            LocalDate cellDate = currentYearMonth.atDay(day);
            boolean today = cellDate.equals(LocalDate.now());
            boolean sel = cellDate.equals(selectedDate);
            boolean hasEv = events.containsKey(cellDate) && !events.get(cellDate).isEmpty();
            boolean weekend = column == 0 || column == 6;

            if (today) {
                lb.setBackground(TODAY_BG);
                lb.setForeground(TODAY_FG);
                lb.setBorder(null);
            } else if (sel) {
                lb.setBackground(SELECTED_BG);
                lb.setForeground(Color.BLACK);
                lb.setBorder(null);
            } else {
                lb.setBackground(Color.WHITE);
                lb.setForeground(weekend ? new Color(150, 150, 150) : Color.BLACK);
                lb.setBorder(hasEv ? BorderFactory.createMatteBorder(0, 0, 3, 0, ACCENT) : null);
            }

            return lb;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalendarApp().setVisible(true));
    }
}
