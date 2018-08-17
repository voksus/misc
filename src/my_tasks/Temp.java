package my_tasks;

import java.util.Scanner;

/**
 * @author Volodymyr Burtsev at 13.04.2018 0:23
 */
public class Temp {
    public static void main(String[] args) {
        int an;
        Scanner sc = new Scanner(System.in);

        System.out.println("vvedite c");
        int c = sc.nextInt();

        System.out.println("vvedite b");
        int b = sc.nextInt();

        an = 12 * Math.max(c, b) + Math.min(2 * c, b - 1);
    }
}