package my_tasks.code_wars;

import my_tasks.euler.Primes;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author Volodymyr Burtsev at 16.05.2019 22:39
 */
public class Emirps {

    public static BitSet primes = Primes.getPrimes(1_000_000);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEmirp(10)));
        System.out.println(Arrays.toString(findEmirp(50)));
        System.out.println(Arrays.toString(findEmirp(100)));
    }

    public static long[] findEmirp(long n){

        long count = 0;
        long biggest = 0;
        long sum = 0;

        for (int i = 11; i <= n; i += 2) {
            int reverseOfPrime = reverseOfPrime(i);
            if (primes.get(i) &&
                    primes.get(reverseOfPrime) &&
                    i != reverseOfPrime) {
                count++;
                biggest = i;
                sum += i;
            }
        }

        return new long[] {count, biggest, sum};
    }

    private static int reverseOfPrime(int num) {

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.reverse();

        return Integer.valueOf(sb.toString());
    }

}