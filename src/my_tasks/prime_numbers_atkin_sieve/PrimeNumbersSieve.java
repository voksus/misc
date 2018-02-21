package my_tasks.prime_numbers_atkin_sieve;

import java.util.BitSet;

/**
 * @author Volodymyr Burtsev at 02.01.2018 1:03
 */
public class PrimeNumbersSieve {

    public static BitSet useAtkinSieve(int max) {
        BitSet set = new BitSet(max);

        System.out.printf("BitSet size is %,d bits : BEFORE%n", set.size());
        System.out.println("Calculation...");

        // Предварительное просеивание
        for (long x2 = 1L, dx2 = 3L; x2 < max; x2 += dx2, dx2 += 2L)
            for (long y2 = 1L, dy2 = 3L, n; y2 < max; y2 += dy2, dy2 += 2L) {
                // n = 4x² + y²
                n = (x2 << 2L) + y2;
                if (n <= max && (n % 12L == 1L || n % 12L == 5L))
                    set.flip((int) n);
                // n = 3x² + y²
                n -= x2;
                if (n <= max && n % 12L == 7L)
                    set.flip((int) n);
                // n = 3x² - y² (при x > y)
                if (x2 > y2) {
                    n -= y2 << 1L;
                    if (n <= max && n % 12L == 11L)
                        set.flip((int) n);
                }
            }
        // Все числа, кратные квадратам, помечаются как составные
        int r = 5;
        for (long r2 = r * r, dr2 = (r << 1L) + 1L; r2 < max; ++r, r2 += dr2, dr2 += 2L)
            if (set.get(r))
                for (long mr2 = r2; mr2 < max; mr2 += r2)
                    set.set((int) mr2, false);
        // Числа 2 и 3 — заведомо простые
        if (max > 2)
            set.set(2, true);
        if (max > 3)
            set.set(3, true);

        System.out.printf("BitSet size is %,d bits : AFTER%n", set.size());
        return set;
    }

    public static BitSet useEratosfenSieve(int max) {

        BitSet set = new BitSet(max);
        set.set(0);
        set.set(1);
        int i = 2;

        System.out.printf("BitSet size is %,d bits : BEFORE%n", set.size());
        System.out.println("Calculation...");
        while (i <= max / 2){
            for (int j = i + i; j < max; j = j + i) {
                set.set(j);
            }
            i = set.nextClearBit(i + 1);
        }
        System.out.printf("BitSet size is %,d bits : AFTER%n", set.size());

        return set;
    }
}