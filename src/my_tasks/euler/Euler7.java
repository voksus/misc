package my_tasks.euler;

import java.util.BitSet;

/**
 * RUS:
 * Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13.
 * Очевидно, что 6-ое простое число - 13.
 * Какое число является 10001-ым простым числом?
 * ------------------------------------------------------------------
 *
 * ENG:
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * @author Volodymyr Burtsev at 14.03.2019 20:54
 */
public class Euler7 {

    private static int max = 800_000;

    public static void main(String[] args) {

        BitSet allPrimes = Primes.getPrimes(max);

        int counter = 1;
        int currentPrime = 1;

        do {
            if (currentPrime > max) {
                System.out.println("Too small Upper limit.");
                break;
            }
            currentPrime++;
            if (!allPrimes.get(currentPrime)) {
                continue;
            } else {
                //System.out.println(counter +" > " + currentPrime);
            }
            counter++;
        } while (counter <= 10001);

        --counter;

        System.out.println("\nThe position in primes list is: " + counter + "\nThe PRIME is: " +currentPrime);
    }

}