package my_tasks;

import java.util.Arrays;

/**
 * @author Volodymyr Burtsev at 06.01.2018 3:43
 */
public class DataReverse {

    public static void main(String[] args) {
        Integer[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        Integer[] data2= {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        // each 'byte' need to be reversed
        // so the "data2" should be the same as result
        System.out.println(Arrays.deepToString(DataReverse(data1)));
        System.out.println(Arrays.deepToString(data2));
    }

    public static Integer[] DataReverse(Integer[] data) {
        int length = data.length;
        Integer[] result = new Integer[length];
        for (int i = 0; i < length; i++) {
            result[7 - (i % 8) + i / 8 * 8] = data[length - i - 1];
        }
        return result;
    }
}