package my_tasks.code_wars;

import java.util.stream.LongStream;

/**
 * @author Volodymyr Burtsev at 07.05.2019 19:53
 */
public class SumSquaredDivisors {

    public static void main(String[] args) {
        System.out.println("in range 1..250  > " + listSquared(1, 250));
        System.out.println("in range 42..500 > " + listSquared(42, 500));
    }

    private static String listSquared(long m, long n) {

        StringBuilder result = new StringBuilder();
        for (long num = m; num <= n; num++) {

            int i = 0;

            long mlt = sumOfSquareDivisors(num);
            double sq = Math.sqrt(mlt);
            if (Math.round(sq) == sq) {
//                System.out.println(num + " & " + mlt + " \t\t- YES!!! :)");
                result.append("[").append(num).append(", ").append(mlt).append("], ");
            }
        }

        if (result.length() == 0) return "[]";
        result = new StringBuilder("[" + result.substring(0, result.length() - 2) + "]");

        return result.toString();
    }

    private static long sumOfSquareDivisors(long n) {
        return LongStream.range(1, n + 1)
                .filter(i -> n % i == 0)
                .map(i -> i * i)
                .sum();
    }

}
