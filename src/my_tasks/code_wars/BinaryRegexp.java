package my_tasks.code_wars;

import my_tasks.Timer;

import java.util.Random;

/**
 * @author Volodymyr Burtsev at 28.01.2018 1:49
 */
public class BinaryRegexp {

    private static Timer t = new Timer();
    private static Random r = new Random();

    public static void main(String[] args) {
//        int     a = 3,
//                b = 4,
//                c = 5;
//                p = (a + b + c) / 2.0,
//                s = (p - a) * (p - b) * (p - c),
//                q = (b + c - a) * (a + c - b) * (a + b - c);
//                q = ((b + c - a) / 2.0) * ((a + c - b) / 2.0) * ((a + b - c) / 2.0);
//                q = ((a + b + c - 2 * a) / 2.0) * ((a + b + c - 2 * b) / 2.0) * ((a + b + c - 2 * c) / 2.0);

        long count;
        t.timerStart();
        count = 0;
        for (long i = 0; i < 200_000_000L; i++) {
            if (check1(r.nextDouble() * 8, r.nextDouble() * 8, r.nextDouble() * 8)) count++;
        }
        System.out.printf("Found: %,d%n", count);
        t.timerStop();
        count = 0;
        for (long i = 0; i < 200_000_000L; i++) {
            if (check2(r.nextDouble() * 8, r.nextDouble() * 8, r.nextDouble() * 8)) count++;
        }
        System.out.printf("Found: %,d%n", count);
        t.timerStop();

        System.exit(0);


//        System.out.println("Полупериметр: " + p);
//        System.out.printf("Подсчёт 1:    %.20f%n", s);
//        System.out.printf("Подсчёт 2:    %.20f", q);
    }

    private static boolean check1(double a, double b, double c) {
        return (b + c - a) * (a + c - b) * (a + b - c) > 0;
    }

    private static boolean check2(double a, double b, double c) {
        return a + b > c && a + c > b && c + b > a;
    }
}