package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 17.05.2018 15:57
 */
public class GetTheMiddleCharacter {

    public static void main(String[] args) {
        String str = "1234567890";
        System.out.println(getMiddle(str));
    }

    private static String getMiddle(String word) {
        return word.substring(word.length() / 2 - (word.length() + 1) % 2, word.length() / 2 + 1);
    }

    private static String getMiddle_2(String word) {
        return word.length() > 2 ? getMiddle_2(word.substring(1,word.length()-1)) : word;
    }

}