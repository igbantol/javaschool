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

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public boolean useToilet(double litersUsed) {
        if (!isOpen || brokenUtilCount > 0) {
            return false;
        }
        if (litersWaterAvailable - litersUsed < 0) {
            return false;
        }
        litersWaterUsedTotal += litersUsed;
        litersWaterAvailable -= litersUsed;
        return true;
    }

    public void repairUtility() {
        if (brokenUtilCount > 0) {
            brokenUtilCount--;
        }
    }

    public void addStall() {
        stallCount++;
        doorCount++;
    }

    public double getWaterAvailable() {
        return litersWaterAvailable;
    }

    public boolean isOperational() {
        return isOpen && stallCount > 0 && toiletCount > 0 && litersWaterAvailable > 0;
    }

    public void refillWater(double liters) {
        litersWaterAvailable += liters;
    }

    public String getBuildingName() {
        return "Building " + whichBuilding;
    }

    public String toString() {
        return "CR{" +
                "stallCount=" + stallCount +
                ", toiletCount=" + toiletCount +
                ", doorCount=" + doorCount +
                ", brokenUtilCount=" + brokenUtilCount +
                ", litersWaterUsedTotal=" + litersWaterUsedTotal +
                ", litersWaterAvailable=" + litersWaterAvailable +
                ", whichBuilding=" + whichBuilding +
                ", isOpen=" + isOpen +
                '}';
    }
}
