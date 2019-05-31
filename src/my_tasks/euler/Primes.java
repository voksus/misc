package my_tasks.euler;

import java.util.BitSet;

/**
 * @author Volodymyr Burtsev at 14.03.2019 22:54
 *
 * The set of Primes by Sieve of Atkin (fastest algorythm IMHO and smallest memory usage)
 */
public class Primes {

    public static BitSet getPrimes(int max) {

        BitSet allPrimes = new BitSet(max);

        // Предварительное просеивание
        for (long x2 = 1L, dx2 = 3L; x2 < max; x2 += dx2, dx2 += 2L)
            for (long y2 = 1L, dy2 = 3L, n; y2 < max; y2 += dy2, dy2 += 2L) {
                // n = 4x² + y²
                n = (x2 << 2L) + y2;
                if (n <= max && (n % 12L == 1L || n % 12L == 5L))
                    allPrimes.flip((int) n);
                // n = 3x² + y²
                n -= x2;
                if (n <= max && n % 12L == 7L)
                    allPrimes.flip((int) n);
                // n = 3x² - y² (при x > y)
                if (x2 > y2) {
                    n -= y2 << 1L;
                    if (n <= max && n % 12L == 11L)
                        allPrimes.flip((int) n);
                }
            }

        // Все числа, кратные квадратам, помечаются как составные
        int r = 5;
        for (long r2 = r * r, dr2 = (r << 1L) + 1L; r2 < max; ++r, r2 += dr2, dr2 += 2L)
            if (allPrimes.get(r))
                for (long mr2 = r2; mr2 < max; mr2 += r2)
                    allPrimes.set((int) mr2, false);

        // Числа 2 и 3 — заведомо простые
        if (max > 2)
            allPrimes.set(2, true);
        if (max > 3)
            allPrimes.set(3, true);
        return allPrimes;
    }
}