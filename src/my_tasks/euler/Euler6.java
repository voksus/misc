package my_tasks.euler;

import static java.lang.Math.*;
/**
 * RUS:
 * Сумма квадратов первых десяти натуральных чисел равна
 * 1² + 2² + ... + 10² = 385
 * Квадрат суммы первых десяти натуральных чисел равен
 * (1 + 2 + ... + 10)² = 55² = 3025
 * Следовательно, разность между суммой квадратов и квадратом суммы первых десяти
 * натуральных чисел составляет 3025 − 385 = 2640.
 * Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.
 * ------------------------------------------------------------------
 *
 * ENG:
 * The sum of the squares of the first ten natural numbers is,
 * 1² + 2² + ... + 10² = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)² = 55² = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural
 * numbers and the square of the sum.
 *
 * @author Volodymyr Burtsev at 12.03.2019 22:07
 */
public class Euler6 {

    public static void main(String[] args) {

        final int LIMIT = 100;

        long sumOfPow = 0;
        long sum = 0;
        long powOfSum;
        int num = 0;

        do {
            sum += ++num;
            powOfSum = round(pow(sum, 2));
            sumOfPow += pow(num, 2);
        } while (num < LIMIT);

        // 100	> 25502500 - 338350 = 25164150
        System.out.print(num + "\t> " + powOfSum);
        System.out.print(" - " + sumOfPow);
        System.out.println(" = " + (powOfSum - sumOfPow));

    }

}