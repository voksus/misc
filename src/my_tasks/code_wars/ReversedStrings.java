package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 01.03.2018 20:22
 *
 * Complete the solution so that it reverses the string value passed into it.
 *
 * Kata.solution("world") //return "dlrow"
 */
public class ReversedStrings {

    public static void main(String[] args) {

        String s = "World";
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}