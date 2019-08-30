package my_tasks.code_wars;

import java.util.Arrays;

/**
 * @author Volodymyr Burtsev at 03.06.2019 23:41
 */
public class ArraySquareUpB {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[] {0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1}));

        System.out.println(Arrays.toString(squareUp(4)));
    }

    private static int[] squareUp(int n) {

        int[] result = new int[n*n];

        for (int i = 0; i < n * n; i++) {
            if (n - i % n <= i / n + 1) {
                result[i] = n - i % n;
            }
        }

        return result;
    }
}