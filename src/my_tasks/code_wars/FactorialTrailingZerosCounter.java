package my_tasks.code_wars;

import my_tasks.Timer;

import java.math.BigInteger;

/**
 * https://www.codewars.com/kata/52f787eb172a8b4ae1000a34/train/java
 * @author Volodymyr Burtsev at 01.02.2018 10:33
 *
 * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
 *
 * N! = 1 * 2 * 3 * ... * N
 *
 * Be careful 1000! has 2568 digits...
 *
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 *
 * Examples:
 * zerosWithLoggin(6) = 1
 * # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
 *
 * zerosWithLoggin(12) = 2
 * # 12! = 479001600 --> 2 trailing zerosWithLoggin
 *
 * Hint: You're not meant to calculate the factorial. Find another way to find the number of zerosWithLoggin.
 */
public class FactorialTrailingZerosCounter {

    private static Timer t = new Timer();

    private static BigInteger f;
    private static int digits;
    private static boolean showLog = false;
    private static BigInteger[] factorials;

    public static void main(String[] args) {
        int zerosCount, limit;

        zerosCount = zerosWithLoggin(0);
        System.out.println(zerosCount + " trailing zeros");
        zerosCount = zerosWithLoggin(6);
        System.out.println(zerosCount + " trailing zeros");
        zerosCount = zerosWithLoggin(14);
        System.out.println(zerosCount + " trailing zeros");
        zerosCount = zerosWithLoggin(30);
        System.out.println(zerosCount + " trailing zeros");
        zerosCount = zerosWithLoggin(50);
        System.out.println(zerosCount + " trailing zeros");
        zerosCount = zerosWithLoggin(100);
        System.out.println(zerosCount + " trailing zeros");

        limit = 200;
        System.out.printf("%nIn %5d! > ", limit);
        t.timerStart();
        zerosCount = zeros_MY(limit);
        System.out.printf("%d digits%n", digits);
        System.out.printf("%d trailing zeros%n", zerosCount);
        t.timerStop(true);

        limit = 500;
        System.out.printf("%nIn %5d! > ", limit);
        t.timerStart();
        zerosCount = zeros_MY(limit);
        System.out.printf("%d digits%n", digits);
        System.out.printf("%d trailing zeros%n", zerosCount);
        t.timerStop(true);

        limit = 1000;
        System.out.printf("%nIn %5d! > ", limit);
        t.timerStart();
        zerosCount = zeros_MY(limit);
        System.out.printf("%d digits%n", digits);
        System.out.printf("%d trailing zeros%n", zerosCount);
        t.timerStop(true);

    }

    public static void setDigits(int digits) {
        FactorialTrailingZerosCounter.digits = digits;
    }

    private static int zerosWithLoggin(int n) {
        System.out.println();
        if (n < 1) return 0;
        BigInteger factorial = BigInteger.ONE;
        int zerosCount = 0;
        for (int i = 1; i <= n; i++) {
            zerosCount = 0;
            factorial = factorial.multiply(BigInteger.valueOf(i));
            System.out.printf("%4d)  ", i);
            if (factorial.toString().length() < 100) {
                System.out.print(factorial + "  > ");
            } else {
                System.out.print("..." + factorial.toString().substring(factorial.toString().length() - 97) + "  > ");
            }
            char[] number = factorial.toString().toCharArray();
            int length = number.length;
            for (int p = 0; p < length; p++) {
                if (number[length - p - 1] == '0') {
                    zerosCount++;
                } else break;
            }
            System.out.println(zerosCount + " (" + length + " digits)");
        }
        System.out.println("-------");
        return zerosCount;
    }

    private static int zeros_MY(int n) {
        if (n < 1) return 0;
        BigInteger factorial = BigInteger.ONE;
        int zerosCount = 0;
        for (int i = 1; i <= n; i++) {
            zerosCount = 0;
            factorial = factorial.multiply(BigInteger.valueOf(i));
            char[] number = factorial.toString().toCharArray();
            int length = number.length;
            for (int p = 0; p < length; p++) {
                if (number[length - p - 1] == '0') {
                    zerosCount++;
                } else break;
            }
            int digits = factorial.toString().length();
            int cut = zerosCount + 5;
            if (cut < digits) {
                factorial = new BigInteger(factorial.toString().substring(digits - cut));
            }
            setDigits(digits);
        }
        return zerosCount;
    }

}