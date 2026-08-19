package schoolutils;

public class PhysicsUtils {

    public static double speed(double distance, double time) {
        return time == 0 ? 0 : distance / time;
    }

    public static double acceleration(double v0, double v1, double time) {
        return time == 0 ? 0 : (v1 - v0) / time;
    }

    public static double force(double mass, double acceleration) {
        return mass * acceleration;
    }

    public static double kineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    public static double potentialEnergy(double mass, double height) {
        return mass * 9.81 * height;
    }

    public static double work(double force, double distance) {
        return force * distance;
    }

    public static double power(double work, double time) {
        return time == 0 ? 0 : work / time;
    }

    public static double density(double mass, double volume) {
        return volume == 0 ? 0 : mass / volume;
    }

    public static double ohmsLawVoltage(double current, double resistance) {
        return current * resistance;
    }

    public static double momentum(double mass, double velocity) {
        return mass * velocity;
    }

    public static double gravitationalForce(double m1, double m2, double distance) {
        double G = 6.674e-11;
        return distance == 0 ? 0 : G * m1 * m2 / (distance * distance);
    }

    public static double waveSpeed(double frequency, double wavelength) {
        return frequency * wavelength;
    }

    public static double pressure(double force, double area) {
        return area == 0 ? 0 : force / area;
    }

    public static double springForce(double k, double displacement) {
        return -k * displacement;
    }
}
