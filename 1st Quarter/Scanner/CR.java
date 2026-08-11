public class CR {
    byte stallCount;
    short toiletCount;
    int doorCount;
    long brokenUtilCount;
    float litersWaterUsedTotal;
    double litersWaterAvailable;
    char whichBuilding;
    boolean isOpen;

    CR(byte stallCount, short toiletCount, int doorCount, long brokenUtilCount, float litersWaterUsedTotal, double litersWaterAvailable, char whichBuilding, boolean isOpen) {
        this.stallCount = stallCount;
        this.toiletCount = toiletCount;
        this.doorCount = doorCount;
        this.brokenUtilCount = brokenUtilCount;
        this.litersWaterUsedTotal = litersWaterUsedTotal;
        this.litersWaterAvailable = litersWaterAvailable;
        this.whichBuilding = whichBuilding;
        this.isOpen = isOpen;
    }
    public void printCR() {
        System.out.println("Stall Count: " + stallCount);
        System.out.println("Toilet Count: " + toiletCount);
        System.out.println("Door Count: " + doorCount);
        System.out.println("Broken Util Count: " + brokenUtilCount);
        System.out.println("Liters Water Used Total: " + litersWaterUsedTotal);
        System.out.println("Liters Water Available: " + (litersWaterAvailable - litersWaterUsedTotal));
        System.out.println("Which Building: " + whichBuilding);
        System.out.println("Is Open: " + isOpen);
    }
}
