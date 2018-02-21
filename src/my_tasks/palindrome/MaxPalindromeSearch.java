package my_tasks.palindrome;

import java.util.Locale;

/**
 * @author Volodymyr Burtsev at 29.12.2017 16:59
 */
public class MaxPalindromeSearch {

    private static Locale l = Locale.ENGLISH;
    private static long timer;                                  // to check used time
    private static boolean showMoreInformation = false;         // to show additional info
    private static boolean showTotalPalindromesCount = true;    // to count all possible palindromes

    public static void main(String[] args) {

        System.out.printf(l, "%n%,d ", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println("bytes of memory used when program started.\n");
        int[] primeNumbers = getPrimeNumbers(10_000, 99_999);

        findBiggestPalindrome(primeNumbers);

        Runtime.getRuntime().gc();

        System.out.printf(l, "%n%nProgram used %,d bytes of memory with array of prime numbers%n%n", Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

    }

    private static int[] getPrimeNumbers(int minNumber, int maxNumber) {
        if (minNumber < 2 || minNumber > maxNumber) throw new RuntimeException("Wrong range numbers. You can use range from 2 to Integer.MAX_VALUE");
        System.out.printf(l, "%nSearching all prime numbers in range [%,d..%,d]%n", minNumber, maxNumber);
        System.out.print("Time used to search all prime numbers: ");

        timerStart();
        int[] primeNumbers = new int[maxNumber - minNumber + 1];
        primeNumbers[0] = 2;    // 1st even and single prime number
        int countPrimeNumbers = 1;

        // search all prime numbers in range 3..maxNumber
        for (int i = 3; i <= maxNumber; i = i + 2) {
            boolean isPrime = true;
            int limit = (int) Math.sqrt(i);
            for (int j = 0; j < limit; j++) {
                if (i % primeNumbers[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers[countPrimeNumbers++] = i;
            }
        }
        int[] result = new int[countPrimeNumbers];
        System.arraycopy(primeNumbers, 0, result, 0, countPrimeNumbers);
        primeNumbers = result;

        // trim selected range by lower value
        result = null;
        for (int i = 0; i < primeNumbers.length; i++) {
            if (primeNumbers[i] >= minNumber) {
                result = new int[primeNumbers.length - i];
                System.arraycopy(primeNumbers, i, result, 0, primeNumbers.length - i);
                break;
            }
        }
        timerStop();
        System.out.printf(l, "%nTotal %,d prime numbers found.%n%n", result.length);
        return result;
    }

    private static void findBiggestPalindrome(int[] primeNumbersInRange) {

        timerStart();

        long palindrome = 0;
        int palindromesCount = 0;
        int multiplier1 = 0;
        int multiplier2 = 0;

        if (!showMoreInformation) System.out.println("\nSearching palindromes in selected range...");
        if (showMoreInformation) System.out.println("\n\nPalindromes list:");
        boolean palindromeFound;
        for (int i = primeNumbersInRange.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                long n1 = primeNumbersInRange[i];
                long n2 = primeNumbersInRange[j];
                long numberToCheck = n1 * n2;
                palindromeFound = isPalindrome(numberToCheck);
                if (palindromeFound) {
                    palindromesCount++;
                    if (showMoreInformation) System.out.printf(l, "%5d)  %,d  x  %,d  =  %,d%n", palindromesCount, n1, n2, numberToCheck);
                    if (numberToCheck > palindrome) {
                        palindrome = numberToCheck;
                        multiplier1 = primeNumbersInRange[i];
                        multiplier2 = primeNumbersInRange[j];
                    }
                    // the line below will optimize calculations by ignoring other guaranteed smaller possible palindromes
                    // but useless when total palindromes count needed
                    if (!showTotalPalindromesCount) break;
                }
            }
        }
        System.out.print("Time used for searching all palindromes: ");
        timerStop();
        if (showTotalPalindromesCount) System.out.printf(l, "%nTotal palindromes found: %,d", palindromesCount);
        System.out.printf(l, "%n%n%n%nFinally biggest palindrom is:%n%,16d%nIt was taken by multiplying the prime numbers:%n%,11d and %,d%n%n", palindrome, multiplier1, multiplier2);
    }

    private static boolean isPalindrome(long numberToCheck) {
        String number = String.valueOf(numberToCheck);
        boolean isPalindrome = true;
        for (int i = 0; i < number.length() / 2; i++) {
            isPalindrome = number.charAt(i) == number.charAt(number.length() - i - 1);
            if (!isPalindrome) break;
        }
        return isPalindrome;
    }

    private static void timerStart() {
        timer = System.currentTimeMillis();
    }

    private static void timerStop() {
        System.out.printf(l, "%,dms", (System.currentTimeMillis() - timer));
    }

}