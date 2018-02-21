package my_tasks.code_wars;

import my_tasks.Timer;

/**
 * @author Volodymyr Burtsev at 22.01.2018 12:05
 * <p>
 * Write a function convertBits to determine the number of bits required to convert positive integer A to positive integer B.
 * <p>
 * For example, you can change 31 to 14 by flipping the 4th and 0th bit:
 * <p>
 * 31  0 0 0 1 1 1 1 1
 * 14  0 0 0 0 1 1 1 0
 * ---  ---------------
 * bit  7 6 5 4 3 2 1 0
 * Thus 31 and 14 should return 2.
 */
public class DeltaBits {

    private static Timer t = new Timer();
    private static int num1 = 31, num2 = 14;
    private static long benchMarkIterations = 10_000_000_000L;

    public static void main(String[] args) {

        int dBits = convertBits(num1, num2);

        System.out.println(num1 + " > " + Integer.bitCount(num1));
        System.out.println(num2 + " > " + Integer.bitCount(num2));
        System.out.println("Delta bits: " + dBits);

        benchmark();
    }

    // my solution
    private static int convertBits_MY(int a, int b) {
        int deltaBitsCount = 0, bitPosition = 0;
        do {
            if (((a >> bitPosition) & 1) != ((b >> bitPosition) & 1)) deltaBitsCount++;
            bitPosition++;
        } while (bitPosition < 32);
        return deltaBitsCount;
    }

    // BEST PRACTICE
    private static int convertBits(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    private static void benchmark() {

        // testing BEST method
        System.out.printf("Benchmark for BEST method with %,d iterations:%n   ", benchMarkIterations);
        t.timerStart();
        for (long j = 0; j < benchMarkIterations; j++) {
            convertBits(num1, num2);
        }
        t.timerStop();

        // testing MY method
        System.out.printf("Benchmark for MY method with %,d iterations:%n   ", benchMarkIterations);
        t.timerStart();
        for (long j = 0; j < benchMarkIterations; j++) {
            convertBits_MY(num1, num2);
        }
        t.timerStop();
    }

}