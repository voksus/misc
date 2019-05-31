import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Volodymyr Burtsev at 01.01.2018 12:00
 *
 * Application generates and showing two random numbers and waiting to input its' sum or "0" to exit
 */
public class SumTutor {

    public static void main(String[] args) {

        addTwoRandomNumbers();  // generates 2 random N-digits numbers then waiting for input and then shows it's sum

    }

    private static void addTwoRandomNumbers() {
        Scanner scan = new Scanner(System.in);

        Random r = new Random();
        BigInteger answer;

        // finish when input '0'
        do {
            int size = r.nextInt(Integer.MAX_VALUE) % 9 + 2;
            System.out.println("Number of digits: " + size);
            StringBuilder sb;

            // number a
            BigInteger a = getRandomNumber(size);
            System.out.println(a.toString());

            // number b
            BigInteger b = getRandomNumber(size);
            System.out.println(b.toString());

            // get input number
            String s;
            do {
                s = scan.next();
                if (!s.matches("\\D+")) {
                    break;
                }
                System.err.println("Wrong input! Please use numbers only.");
            } while (true);

            answer = new BigInteger(s);
            if (answer.equals(BigInteger.ZERO)) {
                System.out.println("Ok. See you... =)");
            } else if (!answer.subtract(a.add(b)).equals(BigInteger.ZERO)) {
                System.out.println("Sorry, the answer is:\n" + a.add(b) + "\n");
            } else {
                System.out.println("CORRECT ! =)");
            }
        } while (answer.intValue() != 0);
    }

    private static BigInteger getRandomNumber(int minDigits, int maxDigits) throws InvalidRange {
        if (minDigits > maxDigits) throw new InvalidRange("Wrong range! First number should be less then second.");

        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        sb.append(r.nextInt(Integer.MAX_VALUE) % 8 + 1);
        int totalDigits = r.nextInt(maxDigits - minDigits + 1) + minDigits - 1;
        for (int i = 0; i < totalDigits; i++) {
            sb.append(r.nextInt(Integer.MAX_VALUE) % 9);
        }
        return BigInteger.valueOf(Long.valueOf(sb.toString()));
    }

    private static BigInteger getRandomNumber(int digitsCount) {
        return getRandomNumber(digitsCount, digitsCount);
    }

    private static class InvalidRange extends RuntimeException {
        public InvalidRange(String msg) {
            System.err.println(msg);
        }
    }

}