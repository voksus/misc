package my_tasks.euler;

import java.util.BitSet;

/**
 * RUS:
 * Простые делители числа 13195 - это 5, 7, 13 и 29.
 *
 * Каков самый большой делитель числа 600851475143, являющийся
 * простым числом?
 * Для проверки >> 71  839  1471  6857
 * ------------------------------------------------------------------
 *
 * ENG:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number  600'851'475'143 ?
 * To control the divisors is >> 71  839  1471  6857
 *
 *
 * @author Volodymyr Burtsev at 06.03.2019 23:31
 */
public class Euler3 {

    private static long theNumber = 600_851_475_143L;
    private static int max = 800_000;
    private static long timer;

    public static void main(String[] args) {

        timerStart();

        BitSet allPrimes = Primes.getPrimes(max);

        System.out.println(timerGetDelay() + "ms");

        int cur = 1;
        while (cur < max){

            cur += 2;

            if (allPrimes.get(cur) && theNumber % cur == 0) {
                System.out.println(">> " + cur + " <<\t in " + timerGetDelay() + "ms");
            }

        }

        System.out.println(timerReset() + "ms");

    }

    private static void timerStart() {
        timer = System.currentTimeMillis();
    }

    private static long timerGetDelay() {
        return System.currentTimeMillis() - timer;
    }

    private static long timerReset() {
        return timer = System.currentTimeMillis() - timer;
    }

}