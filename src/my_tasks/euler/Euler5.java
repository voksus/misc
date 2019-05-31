package my_tasks.euler;

import my_tasks.Timer;

/**
 * RUS:
 * 2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
 * Какое самое маленькое число делится нацело на все числа от 1 до 20?
 * ------------------------------------------------------------------
 *
 * ENG:
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author Volodymyr Burtsev at 09.03.2019 22:47
 */
public class Euler5 {

    public static void main(String[] args) {

        long result;
        // решено так что перемножено весь набор простых чисел, при котором некоторые должны
        // быть заменены на произведение простых чисел, набираемых для этого в набор.
        //result = 2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19;
        //System.out.println(result);
        //System.exit(0);


        final int TIMES = 10;
        final int LIMIT = 20;

        Timer.timerStart();
        long avg = 0;
        for (int t = 0; t < TIMES; t++) {
            result = 2520;
            boolean numberFound;
            do {
                numberFound = true;
                result++;
                for (int i = 11; i <= LIMIT; i++) {
                    numberFound = result % i == 0 && numberFound;
                    if (!numberFound) break;
                }
            } while (!numberFound);

            System.out.println(result);
            avg += Timer.timerStop(true);
        }
        if (TIMES > 1) System.out.println("\nAverage time is " + avg / 10);

    }
}