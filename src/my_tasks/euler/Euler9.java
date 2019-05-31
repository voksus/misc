package my_tasks.euler;

/**
 * RUS:
 * Тройка Пифагора - три натуральных числа a < b < c, для которых выполняется равенство a² + b² = c²
 * Например: 3² + 4² = 9 + 16 = 25 = 52.
 * Существует только одна тройка Пифагора, для которой a + b + c = 1000.
 * Найдите произведение a·b·c.
 * ------------------------------------------------------------------
 *
 * ENG:
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a² + b² = c²
 * For example, 3² + 4² = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @author Volodymyr Burtsev at 14.03.2019 22:07
 */
public class Euler9 {

    public static void main(String[] args) {

        int a = 0, b = 0, c;
        boolean magicFound = false;

        for (c = 3; !magicFound && c < 1000; c++) {
            for (b = 2; !magicFound && b < c; b++) {
                for (a = 1; !magicFound && a < b; a++) {
                    if ((a * a + b * b == c * c) && a + b + c == 1000) magicFound = true;
                }
            }
        }
        a--; b--; c--;
        System.out.println("a = " + a + "  b = " + b + "  c = " + c);
        System.out.println("a² = " + a * a);
        System.out.println("b² = " + b * b);
        System.out.println("a² + b² = " + (a * a + b * b));
        System.out.println("c² = " + (c * c));
    }

}