package my_tasks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Volodymyr Burtsev at 06.01.2018 4:42
 */
public class HighestScoringWord {

    public static void main(String[] args) {
        String s1 = "man i need a taxi up to ubud";
        String s2 = "what time are we climbing up to the volcano";
        String s3 = "take me to semynak";
        System.out.println(high_v1(s1));
        System.out.println(high_v1(s2));
        System.out.println(high_v1(s3));
    }

    // solution #1
    private static String high_v1(String s) {
        String[] words = s.split(" ");
        String result = words[0];
        for (String word : words) {
            if (score(word) > score(result)) {
                result = word;
            }
        }
        return result;
    }

    private static int score(String word) {
        return word.chars().map(c -> c - (int)'a' + 1).sum();
        /*int score = 0;
        for (char chr : word.toCharArray()) {
            score += chr - 96;
        }
        return score;*/
    }

    // solution #2
    public static String high_v2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

}