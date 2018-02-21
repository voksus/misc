import java.math.BigInteger;
import java.util.Locale;

/**
 * @author Volodymyr Burtsev at 21.02.2018 14:36
 */
public class Factorial {

    private static BigInteger f;
    private static int bytesUsed;
    private static BigInteger[] factorials;

    public static void main(String[] args) {

        class Timer {

            Timer() {}
            Timer(String s) {
                this.s =  s;
            }

            long timer;
            String s = "Time used:";

            public long stop() {
                long delta = System.currentTimeMillis() - timer;
                start();
                return delta;
            }

            public long stop(boolean showUsedTime) {
                long delta = stop();
                if (showUsedTime) System.out.printf("%s %,d millis%n", s, delta);
                start();
                return delta;
            }

            public void start() {
                timer = System.currentTimeMillis();
            }
        }
        Timer timer = new Timer("Time used to count:");

        int upperLimit = 10000;
//        showMem("BEFORE: ");
        System.out.printf("Counting factorial with storing in array BigInteger[%d] :%n", upperLimit);

        timer.start();
        factorial(upperLimit);
        timer.stop(true);
        System.out.printf("The factorial %d! has %d digits%n%n", upperLimit, f.toString().length());
        System.out.printf(new Locale("US"), "Storing each number in array BigInteger[%1$d] used at least %2$,d bytes of pure data and some overheads.%n",
                upperLimit, bytesUsed);
//        showMem("AFTER:  ");

    }

    private static void factorial(int n) {

        if (n < 1) {
            f = BigInteger.ZERO;
            return;
        }

        factorials = new BigInteger[n + 1];
        factorials[1] = f = BigInteger.ONE;
        bytesUsed = 1;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
            factorials[i] = f;
            bytesUsed += f.toByteArray().length;
        }
    }

    private static void showMem(String s) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.printf("%n%s %,d bytes currently free%n%n", s, Runtime.getRuntime().freeMemory());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}