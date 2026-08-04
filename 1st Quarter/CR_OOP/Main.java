public class Main {
    public static void main(String[] args) {
        CR cr = new CR((byte) 5, (short) 6, 7, 2L, 100.3F, 500.6D, 'A', true);

        System.out.println("========================================");
        System.out.println("       COMFORT ROOM REPORT");
        System.out.println("========================================");
        System.out.printf("  %-18s: %s%n", "Building", cr.getBuildingName());
        System.out.printf("  %-18s: %d%n", "Stalls", cr.stallCount);
        System.out.printf("  %-18s: %d%n", "Toilets", cr.toiletCount);
        System.out.printf("  %-18s: %d%n", "Doors", cr.doorCount);
        System.out.printf("  %-18s: %d%n", "Broken Utilities", cr.brokenUtilCount);
        System.out.printf("  %-18s: %.1f L%n", "Water Available", cr.getWaterAvailable());
        System.out.printf("  %-18s: %.1f L%n", "Water Used", cr.litersWaterUsedTotal);
        System.out.printf("  %-18s: %s%n", "Status", cr.isOperational() ? "OPERATIONAL" : "NOT OPERATIONAL");

        System.out.println();
        System.out.println("----------------- ACTIONS -----------------");
        cr.repairUtility();
        cr.repairUtility();
        System.out.printf("  %-18s: %s%n", "Repair x2", "Fixed all utilities!");
        cr.addStall();
        System.out.printf("  %-18s: %s%n", "Add Stall", "1 stall added (now " + cr.stallCount + ")");
        cr.refillWater(300);
        System.out.printf("  %-18s: %s%n", "Refill Water", "+300 L added");

        System.out.println();
        System.out.println("----------------- USAGE -------------------");
        System.out.printf("  %-18s: %s%n", "Use 20 L", cr.useToilet(20) ? "Success" : "Failed");
        System.out.printf("  %-18s: %s%n", "Use 150 L", cr.useToilet(150) ? "Success" : "Failed");
        System.out.printf("  %-18s: %s%n", "Use 10000 L", cr.useToilet(10000) ? "Success" : "Failed");

        System.out.println();
        System.out.println("----------------- SUMMARY -----------------");
        System.out.printf("  %-18s: %.1f L%n", "Total Water Used", cr.litersWaterUsedTotal);
        System.out.printf("  %-18s: %.1f L%n", "Water Remaining", cr.getWaterAvailable());

        cr.setOpen(false);
        System.out.printf("  %-18s: %s%n", "After Closing", cr.useToilet(5) ? "Success" : "Failed (CR is closed)");

        System.out.println("========================================");
    }
}
