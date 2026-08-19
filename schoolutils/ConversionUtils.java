package schoolutils;

public class ConversionUtils {

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double kilometersToMiles(double km) {
        return km * 0.621371;
    }

    public static double milesToKilometers(double mi) {
        return mi / 0.621371;
    }

    public static double metersToFeet(double m) {
        return m * 3.28084;
    }

    public static double feetToMeters(double ft) {
        return ft / 3.28084;
    }

    public static double kilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double poundsToKilograms(double lb) {
        return lb / 2.20462;
    }

    public static double gramsToOunces(double g) {
        return g / 28.3495;
    }

    public static double ouncesToGrams(double oz) {
        return oz * 28.3495;
    }

    public static double litersToGallons(double l) {
        return l / 3.78541;
    }

    public static double gallonsToLiters(double gal) {
        return gal * 3.78541;
    }

    public static double minutesToSeconds(double min) {
        return min * 60;
    }

    public static double secondsToMinutes(double sec) {
        return sec / 60;
    }

    public static double hoursToMinutes(double h) {
        return h * 60;
    }

    public static double minutesToHours(double min) {
        return min / 60;
    }

    public static double daysToHours(double d) {
        return d * 24;
    }

    public static double bytesToKilobytes(double b) {
        return b / 1024;
    }

    public static double kilobytesToMegabytes(double kb) {
        return kb / 1024;
    }
}
