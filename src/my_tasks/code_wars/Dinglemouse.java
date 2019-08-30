package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 22.08.2019 2:15
 *
 * .: 5kyu :.
 * https://www.codewars.com/kata/histogram-v1/train/java
 *
 * A 6-sided die is rolled a number of times and the results are plotted as a character-based histogram.
 *
 * Example:
 *
 *     10
 *     #
 *     #
 * 7   #
 * #   #
 * #   #     5
 * #   #     #
 * # 3 #     #
 * # # #     #
 * # # # 1   #
 * # # # #   #
 * -----------
 * 1 2 3 4 5 6
 *
 * Task
 * You will be passed all the dice roll results, and your task is to write
 * the code to return a string representing a histogram, so that when
 * it is printed it has the same format as the example.
 *
 * Notes
 * There are no trailing spaces on the lines
 * All lines (including the last) end with a newline \n
 * A count is displayed above each bar (unless the count is 0)
 * The number of rolls may vary but is always less than 100
 */
public class Dinglemouse {

    public static void main(String[] args) {
//        System.out.println(histogram(new int[]{7, 3, 10, 1, 0, 5}));
        System.out.println(histogram(new int[]{0, 0, 0, 0, 0, 0}));
//        System.out.println(histogram(new int[]{2, 1, 0, 3, 5, 7}));
    }

    public static String histogram(final int[] results) {
        int max = 0;
        for (int i = 0; i < 6; i++)
            max = Math.max(max, results[i]);

        if (max == 0) return "-----------\n1 2 3 4 5 6\n";

        StringBuilder sb = new StringBuilder();
        String s;
        for (int i = 0; i < max + 1; i++) {
            for (int k = 0; k < 6; k++) {
                s = (max == i) ? "  " : (max - i < 10) ? max - i + " " : Integer.toString(max - i);
                sb.append(max - results[k] > i ? "  " : max - results[k] == i ? s : "# ");
            }

            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.setLength(sb.length() - 1);
            }
            sb.append("\n");
        }
        sb.append("-----------\n1 2 3 4 5 6\n");
        return sb.toString();
    }

}