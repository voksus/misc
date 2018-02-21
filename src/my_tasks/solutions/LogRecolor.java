package my_tasks.solutions;

/**
 * Created by voksus on 24.03.2017.
 */
public class LogRecolor {

    public static void main(String[] args) {

        for (int i = 0; i < 256; i++) {
            System.out.print("\u001B[" + i + "m");
            System.out.printf("%3s", i);
            System.out.println(" · Hello world");
        }

        /*
        System.out.print("\u001B[1m");      // Bold font
        System.out.print("\u001B[4m");      // Underline font
        System.out.print("\u001B[4m");      // invert font and highlight
        System.out.print("\u001B[30m");     // White
        System.out.print("\u001B[31m");     // Red
        System.out.print("\u001B[32m");     // Yellow-green
        System.out.print("\u001B[33m");     // Yellow
        System.out.print("\u001B[34m");     // Blue
        System.out.print("\u001B[35m");     // Purple
        System.out.print("\u001B[36m");     // Teal
        System.out.print("\u001B[37m");     // Gray

        System.out.print("\u001B[40m");     // Default font, white highlight
        System.out.print("\u001B[41m");     // Default font, red highlight
        System.out.print("\u001B[42m");     // Default font, yellow-green highlight
        System.out.print("\u001B[43m");     // Default font, yellow highlight
        System.out.print("\u001B[44m");     // Default font, blue highlight
        System.out.print("\u001B[45m");     // Default font, purple highlight
        System.out.print("\u001B[46m");     // Default font, teal highlight
        System.out.print("\u001B[47m");     // Default font, gray highlight

        System.out.print("\u001B[90m");     // Dark gray
        System.out.print("\u001B[97m");     // Black

        System.out.print("\u001B[0m");      // Reset
        */
    }
}