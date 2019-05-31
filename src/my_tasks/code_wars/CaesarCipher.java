package my_tasks.code_wars;

import java.util.Arrays;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 17.05.2019 0:04
 */
public class CaesarCipher {

    public static void main(String[] args) {

        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");

        String[] l = movingShift(u, 1).toArray(new String[]{});
        System.out.println(Arrays.deepToString(l));
        for (String s : l) {
            System.out.print(s.length() + " ");
        }
        // 'A' == 65    'Z' == 90   'a' == 97   'z' == 122
        String s = demovingShift(v, 1);
        System.out.println("\n" + s);
        System.out.println(s.length());
    }

    public static List<String> movingShift(String s, int shift) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {

            ch = s.toCharArray()[i];

            if (Character.isLetter(ch)) {
                if (ch > 90) {
                    ch += shift + i % 26;
                    if (ch > 122) ch -= 26;
                } else {
                    ch += shift + i % 26;
                    if (ch > 90) ch -= 26;
                }
            }

            sb.append(ch);
        }

        String[] str = new String[5];
        int start, end,
                ln = sb.toString().length(),
                size = ln % 5 == 0
                        ? ln / 5
                        : ln / 5 + 1;
        for (int i = 0; i < 5; i++) {
            start = i * size > ln ? ln : i * size;
            end = (i + 1) * size > ln ? ln : (i + 1) * size;
            str[i] = sb.toString().substring(start, end);
        }

        return Arrays.asList(str);
    }

    public static String demovingShift(List<String> strings, int shift) {

        StringBuilder s = new StringBuilder();
        for (String subString : strings) {
            s.append(subString);
        }

        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {

            ch = s.toString().toCharArray()[i];

            if (Character.isLetter(ch)) {
                if (ch > 90) {
                    ch -= shift + i % 26;
                    if (ch < 97) ch += 26;
                } else {
                    ch -= shift + i % 26;
                    if (ch < 65) ch += 26;
                }
            }

            sb.append(ch);
        }
        return sb.toString();
    }

}