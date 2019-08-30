package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 24.07.2019 10:52
 *
 * https://www.codewars.com/kata/find-all-pairs-1/train/java
 * You are given array of integers, your task will be to count all pairs in that array and return their count.
 *
 * Notes:
 * Array can be empty or contain only one value; in this case return 0
 * If there are more pairs of a certain number, count each pair only once.
 * E.g.: for [0, 0, 0, 0] the return value is 2 (= 2 pairs of 0s)
 * Random tests: maximum array length is 1000, range of values in array is between 0 and 1000
 * Examples
 * [1, 2, 5, 6, 5, 2]  -->  2
 * ...because there are 2 pairs: 2 and 5
 *
 * [1, 2, 2, 20, 6, 20, 2, 6, 2]  -->  4
 * ...because there are 4 pairs: 2, 20, 6 and 2 (again)
 */
public class FindAllPairs {

    public static void main(String[] args) {

        int[] array;

        array = new int[]{1, 2, 5, 6, 5, 2}; // 2
        System.out.println(duplicates(array));

        array = new int[]{0, 0, 0, 0, 0, 0, 0};
        System.out.println(duplicates(array)); // 3

        array = new int[] {54};
        System.out.println(duplicates(array)); // 0

        array = new int[]{1000, 1000};
        System.out.println(duplicates(array)); // 1

        array = new int[] {};
        System.out.println(duplicates(array)); // 0

        array = null;
        System.out.println(duplicates(array)); // 0

    }

    public static int duplicates(int[] array) {

        if (array == null || array.length < 2) return 0;

        int duplicatesCount = 0;
        int[] idx = new int[array.length / 2];
        int idxI = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < i; j++) {
                if (array[i] == array[j]) {

                }
            }
        }
        return array.length; //duplicatesCount;

    }

}