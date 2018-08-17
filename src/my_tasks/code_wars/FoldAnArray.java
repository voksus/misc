package my_tasks.code_wars;

import java.util.Arrays;

/**
 * @author Volodymyr Burtsev at 18.01.2018 21:14
 *
 * In this kata you have to write a method that folds a given array of integers by the middle x-times.
 *
 * An example says more than thousand words:
 *
 * Fold 1-times:
 * [1,2,3,4,5] -> [6,6,3]
 *
 * A little visualization (NOT for the algorithm but for the idea of folding):
 *
 * Step 1         Step 2         Step 3       Step 4       Step5
 *                      5/           5|         5\
 *                     4/            4|          4\
 * 1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
 * ----*----      ----*          ----*        ----*        ----*
 *
 *
 * Fold 2-times:
 *
 * [1,2,3,4,5] -> [9,6]
 *
 * As you see, if the count of numbers is odd, the middle number will stay. Otherwise the fold-point is between the middle-numbers, so all numbers would be added in a way.
 *
 * The array will always contain numbers and will never be null. The parameter runs will always be a positive integer greater than 0 and says how many runs of folding your method has to do.
 *
 * If an array with one element is folded, it stays as the same array.
 *
 * The input array should not be modified!
 *
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 *
 * I have created other katas. Have a look if you like coding and challenges.
 */
public class FoldAnArray {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3, 4, 5},
                arr2 = new int[]{-9, 9, -8, 8, 66, 23},
                t;

        // { 6, 6, 3 };
        t = foldArray(arr1, 1);
        System.out.println(Arrays.toString(t) + "\n");

        // { 9, 6 };
        t = foldArray(arr1, 2);
        System.out.println(Arrays.toString(t) + "\n");

        // { 15 };
        t = foldArray(arr1, 3);
        System.out.println(Arrays.toString(t) + "\n");

        // { 14, 75, 0 };
        t = foldArray(arr2, 1);
        System.out.println(Arrays.toString(t) + "\n");
    }

    // my solution
    private static int[] foldArray_MY(int[] array, int runs) {
        int[] result = null, tmp = array;
        for (int i = 0; i < runs; i++) {
            result = new int[tmp.length / 2 + tmp.length % 2];
            for (int n = 0; n < tmp.length / 2; n++) {
                result[n] = tmp[n] + tmp[tmp.length - n - 1];
            }
            if (tmp.length % 2 == 1) result[result.length - 1] = tmp[result.length - 1];
            tmp = result;
        }
        return result;
    }

    // BEST PRACTICE
    public static int[] foldArray(int[] array, int runs) {
        int[] f = java.util.Arrays.copyOfRange(array, 0, (array.length + 1) / 2);
        for (int i = 0; i < array.length / 2; i++) {
            f[i] += array[array.length - 1 - i];
        }
        return f.length == 1 | runs == 1 ? f : foldArray(f, --runs);
    }
}