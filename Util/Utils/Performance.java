package Utils;

import java.util.function.Supplier;

public class Performance {
    private Performance() {
    }

    public static void measureTimeNanos(Supplier<?> function) {
        long start = System.nanoTime();
        System.out.println("Output of the function call : " + function.get());
        long end = System.nanoTime();
        System.out.println("Time Taken (nano sec) : " + (end - start));
    }

    public static void measureTimeMillis(Supplier<?> function) {
        long start = System.currentTimeMillis();
        System.out.println("Output of the function call : " + function.get());
        long end = System.currentTimeMillis();
        System.out.println("Time Taken (milli sec) : " + (end - start));
    }
}
