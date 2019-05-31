package my_tasks.euler;

import java.util.BitSet;

/**
 * RUS:
 * Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
 * Найдите сумму всех простых чисел меньше двух миллионов.
 * ------------------------------------------------------------------
 *
 * ENG:
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * @author Volodymyr Burtsev at 14.03.2019 22:53
 */
public class Euler10 {

    public static void main(String[] args) {

        int limit = 2_000_000;
        BitSet allPrimes = Primes.getPrimes(limit);

        long sum = 2;

        for (int i = 3; i < limit; i++) {
            if (allPrimes.get(i)) sum += i;
        }

        System.out.printf("%,d", sum);
    }
}