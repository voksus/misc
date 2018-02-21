package my_tasks.code_wars;

import java.util.Arrays;

/**
 * Created by voksus on 14.02.2017.
 */
public class DoubleArrayFillerBySpiral {

    public static void main(String[] args) {

        DoubleArrayFillerBySpiral doubleArray = new DoubleArrayFillerBySpiral();
        int[][] testArray = doubleArray.getFilledArray(3, 3);

        for (int i = 0; i < testArray.length; i++) {
            System.out.println(Arrays.toString(testArray[i]));
        }
    }

    public int[][] getFilledArray(int x, int y) {
        int[][] resultArray = new int[x][y];

        //TO DO
        int max = 1;
        int xx = 0, yy = 0;

        while (true) {

            // 1 way
            while(yy < y) {
                if(resultArray[xx][yy] == 0) {
                    resultArray[xx][yy++] = max++;
                } else {
                    break;
                }
            }
            yy--;
            if(max > y * x) break;
            xx++;

            // 2 way
            while(xx < x) {
                if(resultArray[xx][yy] == 0) {
                    resultArray[xx++][yy] = max++;
                } else {
                    break;
                }
            }
            xx--;
            if(max > y * x) break;
            yy--;

            // 3 way
            while (yy >= 0) {
                if(resultArray[xx][yy] == 0) {
                    resultArray[xx][yy--] = max++;
                } else {
                    break;
                }
            }
            yy++;
            if(max > y * x) break;
            xx--;

            // 4 way
            while (xx >= 0) {
                if(resultArray[xx][yy] == 0) {
                    resultArray[xx--][yy] = max++;
                } else {
                    break;
                }
            }
            xx++;
            if(max > y * x) break;
            yy++;
        }
        return resultArray;
    }
}