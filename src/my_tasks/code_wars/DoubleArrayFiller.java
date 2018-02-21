package my_tasks.code_wars;

import java.util.Arrays;

/**
 * Created by voksus on 14.02.2017.
 */
public class DoubleArrayFiller {

    public static void main(String[] args) {

        DoubleArrayFiller doubleArray = new DoubleArrayFiller();
        int[][] testArray = doubleArray.getFilledArray(3, 3);

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(Arrays.toString(testArray[i]));
        }
    }

    public int[][] getFilledArray(int x, int y) {
        int[][] resultArray = new int[x][y];
        //TO DO
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                resultArray[j][i] = i + j * y + 1;
            }
        }
        return resultArray;
    }
}
