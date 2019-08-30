package my_tasks.code_wars;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 21.08.2019 1:52
 *
 * Create a simple calculator that given a string of operators (+ - * and /)
 * and numbers separated by spaces returns the value of that expression
 *
 * Example:
 *
 * Calculator.evaluate("2 / 2 + 3 * 4 - 6") // => 7
 * Remember about the order of operations! Multiplications and divisions
 * have a higher priority and should be performed left-to-right.
 * Additions and subtractions have a lower priority and should also
 * be performed left-to-right.
 *
 * https://www.codewars.com/kata/calculator/train/java
 *
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(evaluate("127") + "(127)");
        System.out.println(evaluate("2 + 3") + "(5)");
        System.out.println(evaluate("2 - 3 - 4") + "(-5)");
        System.out.println(evaluate("10 * 5 / 5") + "(10)");
        System.out.println(evaluate("2 / 2 + 3 * 4") + "(13)");
        System.out.println(evaluate("7.7 - 3.3 - 4.4") + "(0)");
    }

    public static Double evaluate(String expression) {
        List<String> l = new LinkedList<>(Arrays.asList(expression.split(" ")));
        int i;
        double a, b;

        // 1st step : multiplications and divisions
        i = 1;
        while(l.size() > i) {
            a = Double.parseDouble(l.get(i - 1));
            b = Double.parseDouble(l.get(i + 1));
            switch (l.get(i)) {
                case "*":
                    l.set(i - 1, String.valueOf(a * b));
                    break;
                case "/":
                    l.set(i - 1, String.valueOf(a / b));
                    break;
                default:
                    i += 2;
                    continue;
            }
            l.remove(i);
            l.remove(i);
        }

        // 2nd step : addition and subtraction
        i = 1;
        while(l.size() > i) {
            a = Double.parseDouble(l.get(i - 1));
            b = Double.parseDouble(l.get(i + 1));
            switch (l.get(i)) {
                case "+":
                    l.set(i - 1, String.valueOf(a + b));
                    break;
                case "-":
                    l.set(i - 1, String.valueOf(a - b));
            }
            l.remove(i);
            l.remove(i);
        }

        return Double.parseDouble(l.get(0));
    }
}