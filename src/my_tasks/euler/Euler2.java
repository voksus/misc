package my_tasks.euler;

/**
 * RUS:
 * Каждый следующий элемент ряда Фибоначчи получается при сложении
 * двух предыдущих. Начиная с 1 и 2, первые 10 элементов будут:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * Найдите сумму всех четных элементов ряда Фибоначчи, которые
 * не превышают 4'000'000.
 * ------------------------------------------------------------------
 *
 * ENG:
 * Each new term in the Fibonacci sequence is generated by adding the
 * previous two terms. By starting with 1 and 2, the first 10 terms
 * will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values
 * do not exceed four million, find the sum of the even-valued terms.
 *
 *
 * @author Volodymyr Burtsev at 06.03.2019 22:57
 */
public class Euler2 {

    public static void main(String[] args) {
        int sum = 0;
        int cur;
        int prev1 = 1;
        int prev2 = 1;
        while (true) {
            cur = prev1 + prev2;
            if (cur >= 4_000_000) break;
            if (cur % 2 == 0) {
                sum += cur;
            }
            prev2 = prev1;
            prev1 = cur;
        }
        System.out.println(sum);
    }
}