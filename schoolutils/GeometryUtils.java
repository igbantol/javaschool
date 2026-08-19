package schoolutils;

public class GeometryUtils {

    public static double circleArea(double r) {
        return Math.PI * r * r;
    }

    public static double circleCircumference(double r) {
        return 2 * Math.PI * r;
    }

    public static double rectangleArea(double w, double h) {
        return w * h;
    }

    public static double rectanglePerimeter(double w, double h) {
        return 2 * (w + h);
    }

    public static double triangleArea(double b, double h) {
        return 0.5 * b * h;
    }

    public static double squareArea(double s) {
        return s * s;
    }

    public static double squarePerimeter(double s) {
        return 4 * s;
    }

    public static double trapezoidArea(double a, double b, double h) {
        return 0.5 * (a + b) * h;
    }

    public static double parallelogramArea(double b, double h) {
        return b * h;
    }

    public static double rhombusArea(double d1, double d2) {
        return 0.5 * d1 * d2;
    }

    public static double ellipseArea(double a, double b) {
        return Math.PI * a * b;
    }

    public static double sphereVolume(double r) {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    public static double sphereSurfaceArea(double r) {
        return 4 * Math.PI * r * r;
    }

    public static double cylinderVolume(double r, double h) {
        return Math.PI * r * r * h;
    }

    public static double cylinderSurfaceArea(double r, double h) {
        return 2 * Math.PI * r * (r + h);
    }

    public static double coneVolume(double r, double h) {
        return (1.0 / 3.0) * Math.PI * r * r * h;
    }

    public static double cubeVolume(double s) {
        return s * s * s;
    }

    public static double cubeSurfaceArea(double s) {
        return 6 * s * s;
    }
}
