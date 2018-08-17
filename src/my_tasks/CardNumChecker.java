package my_tasks;

import java.util.Scanner;

/**
 * @author Volodymyr Burtsev at 17.08.2018 0:01
 */
public class CardNumChecker {

    public static void main(String[] args) {

        System.out.println("Приветствую, друг мой.");
        System.out.println("Давай проверим номера карт на валидность с помощью алгоритма Луна.");
        System.out.println("Для начала несколько примеров:");

        for (String num : getNumbers()) {
            System.out.print("\t" + num);
            check(num);
        }

        System.out.println("\nА теперь попробуйте вы ввести свой номер." +
                "\nЛюбые символы кроме цифр будут игнорироваться." +
                "\n(для выхода введите один любой символ)");
        while (true) {
            String num = new Scanner(System.in).nextLine();
            if (num.length() == 1) {
                break;
            }
            check(num);
        }
    }

    private static boolean validator(String num) {
        int ControlSum = 0;
        String s = num.replaceAll("\\D", "");
        for (int i = s.length() - 1; i >= 0; i--) {
            ControlSum += (Integer.valueOf(s.substring(i, i + 1))) * ((s.length() - i + 1) % 2 + 1) % 9;
        }
//        System.out.print("  >  [" + ControlSum + "]");
        return ControlSum % 10 == 0;
    }

    private static String[] getNumbers() {
        return new String[]{
                "5371 4501 4400 1713",
                "5861 7422 3110 0524",
                "5375 0267 8642 0000",
                "5178 6456 7103 7577",
                "0123 4567 8901 2345",
                "0123 4567 8901 2346",
                "1122 3344 1122 3344"
        };
    }

    private static void check(String num) {
        if (validator(num)) {
            System.out.println(" Этот номер ВЕРНЫЙ .");
        } else {
            System.out.println(" Такой номер не годится !");
        }
    }
}