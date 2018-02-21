package my_tasks.code_wars;

import java.util.Arrays;

/**
 * http://www.codewars.com/kata/fibonacci-tribonacci-and-friends/train/java
 *      ----------
 *      NOT PASSED
 *      ----------
 *
 * @author Volodymyr Burtsev at 22.01.2018 13:49
 * <p>
 * If you have completed the Tribonacci sequence kata,
 * you would know by now that mister Fibonacci has at least a bigger brother.
 * If not, give it a quick look to get how things work.
 * <p>
 * Well, time to expand the family a little more:
 * think of a Quadribonacci starting with a signature of 4 elements
 * and each following element is the sum of the 4 previous, a Pentabonacci
 * (well Cinquebonacci would probably sound a bit more italian,
 * but it would also sound really awful) with a signature of 5 elements
 * and each following element is the sum of the 5 previous, and so on.
 * <p>
 * Well, guess what? You have to build a Xbonacci function that takes
 * a signature of X elements - and remember each next element is the sum
 * of the last X elements - and returns the first n elements
 * of the so seeded sequence.
 * <p>
 * xbonacci {1,1,1,1} 10 = {1,1,1,1,4,7,13,25,49,94}
 * xbonacci {0,0,0,0,1} 10 = {0,0,0,0,1,1,2,4,8,16}
 * xbonacci {1,0,0,0,0,0,1} 10 = {1,0,0,0,0,0,1,2,3,6}
 * xbonacci {1,1} produces the Fibonacci sequence
 */
public class Xbonacci {

    public static void main(String[] args) {
        double[] arr1 = new double[]{0, 1};
        double[] arr2 = new double[]{1, 1};
        double[] arr3 = new double[]{0, 0, 0, 0, 1};
        double[] arr4 = new double[]{1, 0, 0, 0, 0, 0, 1};
        double[] arr5 = new double[]{1, 1, 1, 1};

        double[] res;
        res = xbonacci(arr1, 10);
        System.out.println("1) " + Arrays.toString(res) + "\n");

        res = xbonacci(arr2, 10);
        System.out.println("2) " + Arrays.toString(res) + "\n");

        res = xbonacci(arr3, 10);
        System.out.println("3) " + Arrays.toString(res) + "\n");

        res = xbonacci(arr4, 10);
        System.out.println("4) " + Arrays.toString(res) + "\n");

        res = xbonacci(arr5, 10);
        System.out.println("5) " + Arrays.toString(res) + "\n");
    }

    public static double[] xbonacci(double[] signature, int n) {
        double[] result = new double[n];
        System.arraycopy(signature, 0, result, 0, signature.length);
//        for (int i = 0; i < signature.length; i++) result[i] = signature[i];
        for (int i = signature.length; i < n; i++) {
            result[i] = result[i - 1];
            for (int j = 1; j < signature.length; j++) result[i] += result[i - j - 1];
        }
        return result;
    }
}