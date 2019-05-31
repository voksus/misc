package my_tasks.euler;

/**
 * RUS:
 * Число-палиндром с обеих сторон (справа налево и слева направо)
 * читается одинаково. Самое большое число-палиндром, полученное
 * умножением двух двузначных чисел – 9009 = 91 × 99.
 *
 * Найдите самый большой палиндром, полученный умножением двух
 * трехзначных чисел.
 * ------------------------------------------------------------------
 *
 * ENG:
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit
 * numbers.
 *
 * @author Volodymyr Burtsev at 08.03.2019 1:50
 */
public class Euler4 {

    public static void main(String[] args) {

        Euler4 e = new Euler4();

        /* int q1 = 1230, q2 = 2340432, q3 = 20212, q4 = 990099;
        System.out.println(q1 + "\t " + e.isPalindrome(q1));
        System.out.println(q2 + "\t " + e.isPalindrome(q2));
        System.out.println(q3 + "\t " + e.isPalindrome(q3));
        System.out.println(q4 + "\t " + e.isPalindrome(q4));
        System.exit(0); */

        int currentNumber;
        int palindrome = 0, mltplMax1 = 0, mltplMax2 = 0;

        for (int mlt1 = 100; mlt1 < 1000; mlt1++) {
            for (int mlt2 = 100; mlt2 < 1000; mlt2++) {

                currentNumber = mlt1 * mlt2;

                if (e.isPalindrome(currentNumber)) {

                    //System.out.println(mlt1 + " * " + mlt2 + " = " + currentNumber);

                    if (palindrome < currentNumber) {

                        mltplMax1 = mlt1;
                        mltplMax2 = mlt2;
                        palindrome = currentNumber;

                    }
                }
            }
        }

        System.out.println("The biggest palindrome found is : " + palindrome);
        System.out.println("with multipliers " + mltplMax1 + " and " + mltplMax2);
    }

    public boolean isPalindrome(int numberToCheck) {
        String number = String.valueOf(numberToCheck);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) return false;
        }
        return true;
    }

}