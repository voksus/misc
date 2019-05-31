package my_tasks.euler;

/**
 * RUS:
 * Если выписать все натуральные числа меньше 10, кратные 3 или 5,
 * то получим 3, 5, 6 и 9. Сумма этих чисел равна 23.
 *
 * Найдите сумму всех чисел меньше 1000, кратных 3 или 5.
 * ------------------------------------------------------------------
 *
 * ENG:
 * If we list all the natural numbers below 10 that are multiples
 * of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 *
 * @author Volodymyr Burtsev at 06.03.2019 22:49
 */
public class Euler1 {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - t);
    }
}