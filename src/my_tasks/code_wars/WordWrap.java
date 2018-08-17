package my_tasks.code_wars;

/**
 * @author Volodymyr Burtsev at 21.05.2018 1:07
 *
 * Your job is to write a function that takes a string and a maximum
 * number of characters per line and then inserts line breaks as necessary
 * so that no line in the resulting string is longer than the specified limit.
 *
 * If possible, line breaks should not split words. However, if a single word
 * is longer than the limit, it obviously has to be split. In this case,
 * the line break should be placed after the first part of the word
 * (see examples below).
 *
 * Really long words may need to be split multiple times.
 *
 * #Input
 *
 * A word consists of one or more letters.
 *
 * Input text will be the empty string or a string consisting of one or more
 * words separated by single spaces. It will not contain any punctiation
 * or other special characters.
 *
 * The limit will always be an integer greater or equal to one.
 *
 * #Examples
 *
 * Note: Line breaks in the results have been replaced with two dashes
 * to improve readability.
 *
 * ("test", 7) -> "test"
 * ("hello world", 7) -> "hello--world"
 * ("a lot of words for a single line", 10) -> "a lot of--words for--a single--line"
 * ("this is a test", 4) -> "this--is a--test"
 * ("a longword", 6) -> "a long--word"
 * ("areallylongword", 6) -> "areall--ylongw--ord"
 * Note: Sometimes spaces are hard to see in the test results window.
 *
 */
public class WordWrap {

    public static void main(String[] args) {
        // test
        System.out.println("> " + wrap("test", 7));
        // hello\nworld
        System.out.println("> " + wrap("hello world", 7));
        // a lot of\nwords for\na single\nline
        System.out.println("> " + wrap("a lot of words for a single line", 10));
    }

    public static String wrap(String text, int limit) {
        StringBuilder result = new StringBuilder();
        String textCutted = text;
        int cur = -1, cut = 0, i = 0;
        while (cut < text.length()) {
            for (i = 0; i < limit; i++) {
                cur = i + cut < text.length() && text.charAt(i + cut) == ' ' ? i : cur;
                if (textCutted.length() < limit) break;
            }
            result.append(text.substring(cut + i));
            if (cut + i < text.length()) {
                result.append("\n");
                cut += i;
            }
            System.out.println(result);
        }
        return result.toString();
    }
}