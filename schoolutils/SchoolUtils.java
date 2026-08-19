package schoolutils;

import java.lang.reflect.Method;

public class SchoolUtils {

    private static final Class<?>[] ALL_CLASSES = {
        MathUtils.class,
        StringUtils.class,
        ArrayUtils.class,
        GradeUtils.class,
        ConversionUtils.class,
        StatsUtils.class,
        GeometryUtils.class,
        FinanceUtils.class,
        PhysicsUtils.class,
        TextAnalysisUtils.class,
        NumberTheoryUtils.class,
        ProbabilityUtils.class,
        MatrixUtils.class,
        RandomUtils.class,
        AlgorithmUtils.class,
        CryptoUtils.class,
        CombinatoricsUtils.class,
        CalculusUtils.class,
        StatisticsAdvancedUtils.class,
        DataStructuresUtils.class,
        LinearAlgebraUtils.class
    };

    public static void listAllFunctions() {
        int total = 0;
        for (Class<?> c : ALL_CLASSES) {
            Method[] methods = c.getDeclaredMethods();
            System.out.println("=== " + c.getSimpleName() + " (" + methods.length + ") ===");
            for (Method m : methods) {
                System.out.println("  " + m.getReturnType().getSimpleName()
                        + " " + m.getName() + "()");
                total++;
            }
            System.out.println();
        }
        System.out.println("TOTAL FUNCTIONS: " + total);
    }

    public static String[] allFunctionNames() {
        java.util.List<String> names = new java.util.ArrayList<>();
        for (Class<?> c : ALL_CLASSES) {
            for (Method m : c.getDeclaredMethods()) {
                names.add(c.getSimpleName() + "." + m.getName());
            }
        }
        return names.toArray(new String[0]);
    }

    public static int functionCount() {
        int total = 0;
        for (Class<?> c : ALL_CLASSES) total += c.getDeclaredMethods().length;
        return total;
    }
}
