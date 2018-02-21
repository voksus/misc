package my_tasks.prime_numbers_atkin_sieve;

import java.util.BitSet;
import java.util.Locale;

/**
 * @author Volodymyr Burtsev at 02.01.2018 1:04
 */
public class AtkinSieveTest {

    private static long timer;
    private static int upperLimit = 10_000;

    public static void main(String[] args) {

        Locale l = Locale.ENGLISH;
        System.out.printf(l, "%n%,d ", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("bytes of memory used when program started.\n");

        timerStart();
        BitSet allPrimes = PrimeNumbersSieve.useAtkinSieve(upperLimit);
        int primeNumbersCount = 0;
        String no = "·", yes = "#";
        System.out.print(no);
        for (int number = 2; number <= upperLimit; ++number) {
            if (allPrimes.get(number)) {
                primeNumbersCount++;
                System.out.print(yes);
                /*System.out.printf("%8d ", number);
                if (primeNumbersCount % 10 == 0) {
                    System.out.println();
                }*/
            } else {
                System.out.print(no);
            }
            if (number % 100 == 0) System.out.println();
        }
        System.out.printf(l, "%nTotal prime numbers count : %,d%n", primeNumbersCount);
        System.out.printf(l, "Time to prepare prime numbers in range [2..%,d] is: ", upperLimit);
        timerStop();

        Runtime.getRuntime().gc();

        System.out.printf(l, "%n%,d bytes of memory was used and prime numbers was saved.%n%n", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }

    private static void timerStart() {
        timer = System.currentTimeMillis();
    }

    private static void timerStop() {
        System.out.println((System.currentTimeMillis() - timer) + "ms");
    }

}