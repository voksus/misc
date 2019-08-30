package my_tasks.solutions;

/**
 * Created by voksus on 24.03.2017.
 */
public class LogRecolor {

    public static void main(String[] args) {

        for (int i = 0; i <= 107; i++) {
            System.out.print("\u001B[" + i + "m");
                if ((i >= 40 && i <= 47) || (i >= 100 && i <= 106)) {
                    System.out.print("\u001B[97m\u001B[1m");
                }
            System.out.printf("%3s", i);
            System.out.println(" · Hello world");
        }

        System.out.print("\u001B[1m");      // Bold font
        System.out.print("\u001B[4m");      // Underline font
        System.out.print("\u001B[7m");      // invert font and highlight
        System.out.print("\u001B[30m");     // White
        System.out.print("\u001B[31m");     // Red
        System.out.print("\u001B[32m");     // Grass green
        System.out.print("\u001B[33m");     // Yellow
        System.out.print("\u001B[34m");     // Blue
        System.out.print("\u001B[35m");     // Grayed magenta
        System.out.print("\u001B[36m");     // Teal
        System.out.print("\u001B[37m");     // Gray

        System.out.print("\u001B[40m");     // Default font, White highlight
        System.out.print("\u001B[41m");     // Default font, Red highlight
        System.out.print("\u001B[42m");     // Default font, Grass green highlight
        System.out.print("\u001B[43m");     // Default font, Grayed yellow highlight
        System.out.print("\u001B[44m");     // Default font, Blue highlight
        System.out.print("\u001B[45m");     // Default font, Grayed purple highlight
        System.out.print("\u001B[46m");     // Default font, Teal highlight
        System.out.print("\u001B[47m");     // Default font, Gray highlight

        System.out.print("\u001B[90m");     // Dark gray
        System.out.print("\u001B[91m");     // Light red
        System.out.print("\u001B[92m");     // Grass green
        System.out.print("\u001B[93m");     // Yellow
        System.out.print("\u001B[94m");     // Light Blue
        System.out.print("\u001B[95m");     // Light magenta
        System.out.print("\u001B[96m");     // Cyan
        System.out.print("\u001B[97m");     // Black

        System.out.print("\u001B[100m");     // Default font, Dark gray highlight
        System.out.print("\u001B[101m");     // Default font, Light red highlight
        System.out.print("\u001B[102m");     // Default font, Grass green highlight
        System.out.print("\u001B[103m");     // Default font, Yellow highlight
        System.out.print("\u001B[104m");     // Default font, Light blue highlight
        System.out.print("\u001B[105m");     // Default font, Light magenta highlight
        System.out.print("\u001B[106m");     // Default font, Cyan highlight
        System.out.print("\u001B[107m");     // Default font, Black highlight

        System.out.print("\u001B[0m");      // Reset
    }
}