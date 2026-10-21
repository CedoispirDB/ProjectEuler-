package utils;

import java.util.LinkedList;

public class LinkedBenchmark {

    private static final int N = Const.ONE_MILLION;
    private static final int STEP = N / 1000;
    private static final int RUNS = 5;

    private static volatile long sink;

    public static void main(String[] args) {
        Linked<Integer> optimized = new Linked<>();
        LinkedList<Integer> normal = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            optimized.link_last(i);
            normal.addLast(i);
        }

        // Warmup: allow the JVM to optimize the code.
        for (int i = 0; i < 5; i++) {
            sink += runNormal(normal);
            optimized.reset_current();
            sink += runOptimized(optimized);
        }

        long normalTotal = 0;
        long optimizedTotal = 0;

        for (int i = 0; i < RUNS; i++) {
            long start = System.nanoTime();
        
            optimized.reset_current();
            long optimizedResult = runOptimized(optimized);
            long optimizedTime = System.nanoTime() - start;

            start = System.nanoTime();
    

                long normalResult = runNormal(normal);
            long normalTime = System.nanoTime() - start;

            if (normalResult != optimizedResult) {
                throw new AssertionError("Results differ!");
            }

            sink += normalResult + optimizedResult;

            normalTotal += normalTime;
            optimizedTotal += optimizedTime;
        }

        double normalMs = normalTotal / (RUNS * 1_000_000.0);
        double optimizedMs = optimizedTotal / (RUNS * 1_000_000.0);

        System.out.printf("Normal average:    %.3f ms%n", normalMs);
        System.out.printf("Optimized average: %.3f ms%n", optimizedMs);
        System.out.printf("Speedup:           %.2fx%n",
                normalMs / optimizedMs);
    }

    private static long runNormal(LinkedList<Integer> list) {
        long found = 0;

        for (int target = 0; target < N; target += STEP) {
            if (list.contains(target)) {
                found++;
            }
        }

        return found;
    }

    private static long runOptimized(Linked<Integer> list) {
        long found = 0;

        for (int target = 0; target < N; target += STEP) {
            if (list.search_from_current(target)) {
                found++;
            }
        }

        return found;
    }
}
