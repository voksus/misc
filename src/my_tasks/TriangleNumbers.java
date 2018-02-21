package my_tasks;

/**
 * @author Volodymyr Burtsev at 06.01.2018 2:46
 */
public class TriangleNumbers {

    public static void main(String[] args) {
        int limit = 1000;
        for (int number = 0; number <= limit; number++) {
            boolean isTriangleNumber;

            // solution #1
            isTriangleNumber = isTriangleNumber_v1(number);

            // solution #2
            // isTriangleNumber = isTriangleNumber_v2(number);

            if (isTriangleNumber) {
                System.out.println("The number " + number + " is triangular number");
            }
        }
    }

    private static boolean isTriangleNumber_v1(int number) {
        return Math.sqrt(number * 8 + 1) % 1 == 0;
    }

    private static boolean isTriangleNumber_v2(int number) {
        boolean isTriangNum = false;
        int i = 0;
        int j = number;
        while (true) {
            if ((j -= i++) == 0) {
                isTriangNum = true;
                break;
            }
            if (j < 0) {
                break;
            }
        }
        return isTriangNum;
    }
}