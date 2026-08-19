package schoolutils;

public class FinanceUtils {

    public static double simpleInterest(double principal, double rate, double years) {
        return principal * rate * years / 100.0;
    }

    public static double compoundInterest(double principal, double rate, int timesPerYear, double years) {
        double r = rate / 100.0;
        return principal * Math.pow(1 + r / timesPerYear, timesPerYear * years);
    }

    public static double futureValue(double principal, double rate, double years) {
        return principal * Math.pow(1 + rate / 100.0, years);
    }

    public static double presentValue(double future, double rate, double years) {
        return future / Math.pow(1 + rate / 100.0, years);
    }

    public static double monthlyLoanPayment(double principal, double annualRate, int months) {
        double r = annualRate / 100.0 / 12.0;
        if (r == 0) return principal / months;
        return principal * r * Math.pow(1 + r, months) / (Math.pow(1 + r, months) - 1);
    }

    public static double totalInterestPaid(double principal, double payment, int months) {
        return payment * months - principal;
    }

    public static double profit(double revenue, double cost) {
        return revenue - cost;
    }

    public static double profitMargin(double profit, double revenue) {
        if (revenue == 0) return 0;
        return profit / revenue * 100.0;
    }

    public static double markup(double cost, double sellingPrice) {
        if (cost == 0) return 0;
        return (sellingPrice - cost) / cost * 100.0;
    }

    public static double discountPrice(double price, double percentOff) {
        return price * (1 - percentOff / 100.0);
    }

    public static double taxAmount(double amount, double taxRate) {
        return amount * taxRate / 100.0;
    }

    public static double breakEvenUnits(double fixedCost, double pricePerUnit, double costPerUnit) {
        if (pricePerUnit - costPerUnit == 0) return 0;
        return fixedCost / (pricePerUnit - costPerUnit);
    }

    public static double percentageChange(double oldValue, double newValue) {
        if (oldValue == 0) return 0;
        return (newValue - oldValue) / oldValue * 100.0;
    }

    public static double savingsAfterYears(double monthly, double annualRate, int years) {
        double r = annualRate / 100.0 / 12.0;
        int n = years * 12;
        if (r == 0) return monthly * n;
        return monthly * (Math.pow(1 + r, n) - 1) / r;
    }
}
