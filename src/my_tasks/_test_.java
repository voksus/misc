package my_tasks;

import java.util.*;

/**
 * @author Volodymyr Burtsev at 15.02.2018 23:45
 */
public class _test_ {

    static Timer t;
    final static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {

        // generateRandomNumbers(20, 50);
        // checkDecimalAccuracy();
        // collectionsTests();
        // benchmarkForStringConcatinations("00000", 50_000);
        System.out.println("abcdefg".charAt(5));

    }


    /**
     * This method calculates time used to concatenate {@param chars} with {@param iterations} times
     * @param chars is sample string to be concatenated
     * @param iterations is multiplier and it is number of concatenation repeats
     * @throws InterruptedException mean possibility of Exception in {@code Thread.sleep()}
     */
    private static void benchmarkForStringConcatinations(String chars, int iterations) throws InterruptedException {
        int wait = 2000;
        StringBuilder sbd = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        long timer1, timer2, timer3, timer4;
        String str = "";

        // working with String 1
        System.out.println("Starting benchmark for 'String' with '+=' ...");
        t.timerStart();
        for (int i = 0; i < iterations; i++) {
            str += chars;
        }
        System.out.printf("Current size of String variable is: %,d chars%n", str.length());
        timer1 = t.timerStop(false);

        str = "";
        System.out.printf("Waiting for %.1f seconds...%n%n", (double) wait / 1000);
        System.gc();
        Thread.sleep(wait);

        // working with String.concat()
        System.out.println("Starting benchmark for 'String' with '.concat(..)' ...");
        t.timerStart();
        for (int i = 0; i < iterations; i++) {
            str.concat(chars);
        }
        System.out.printf("Current size of String variable is: %,d chars%n", str.length());
        timer2 = t.timerStop(false);

        str = null;
        System.out.printf("Waiting for %.1f seconds...%n%n", (double) wait / 1000);
        System.gc();
        Thread.sleep(wait);

        // working with StringBuffer
        System.out.println("Starting benchmark for 'StringBuffer' ...");
        t.timerStart();
        for (int i = 0; i < iterations; i++) {
            sbf.append(chars);
        }
        System.out.printf("Current size of String variable is: %,d chars%n", sbf.length());
        timer3 = t.timerStop(false);

        sbf = null;
        System.out.printf("Waiting for %.1f seconds...%n%n", (double) wait / 1000);
        System.gc();
        Thread.sleep(wait);

        // working with StringBuilder
        System.out.println("Starting benchmark for 'StringBuilder' ...");
        t.timerStart();
        for (int i = 0; i < iterations; i++) {
            sbd.append(chars);
        }
        System.out.printf("Current size of String variable is: %,d chars%n", sbd.length());
        timer4 = t.timerStop(false);

        sbd = null;
        String format = "There is calculations:%n";
        format.concat(" - String used        %,9d millis%n");
        format.concat(" - .concat(..) used   %,9d millis%n");
        format.concat(" - StringBuffer used  %,9d millis%n");
        format.concat(" - StringBuilder used %,9d millis%n");
        System.out.printf(format, timer1, timer2, timer3, timer4);
        System.out.println("Done!");
    }


    /**
     * Method trying to check two {@code double} with {@code ==} and each time decrease the power of numbers by 10
     */
    private static void checkDecimalAccuracy() {
        double a = 1d, b = 2d;
        int i = 0;
        do {
            a /= 10;
            b /= 10;
            i++;
            System.out.printf("%3d)  %.1e  =  %.1e  - ", i, a, b);
            if (a != b) {
                System.out.println("WRONG =)");
            } else {
                System.out.println("WOW!!! It's happen 0_0");
                break;
            }
        } while (true);
    }


    /**
     * Method used array of empty {@code int}'s with {@code count} of elements.
     * Then it will randomly encreazing wach element up to {@code limit} as true average.
     * And finally it will show all elements' volumes and an additional graphically view.
     *
     * @param limit taking number of posible volume
     * @param count says how many elements will be generated
     */
    private static void generateRandomNumbers(int limit, int count) {
        int[] array = new int[count];
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < limit * count; i++) {
            array[r.nextInt(count)]++;
        }
        for (int i : array) {
            if (min > i) min = i;
            if (max < i) max = i;
        }
        int digits = 0, tmp = max * 10;
        String volFilled = " ", volCorr = " ", volEmpty = " ";
        for (; (tmp /= 10) > 0; ) {
            digits++;
            volEmpty += " ";
            volCorr += "\u2588";
            volFilled += "\u2592";
        }
        System.out.println("Count of random numbers is: " + count);
        System.out.println("Objective number is: " + limit);
        System.out.println("Random range is: " + min + ".." + max + " and " + digits + " maximum digits\n");
        String s = " %" + digits + "d";
        System.out.printf(s, 1);
        for (int i = 1; i < count; i++) {
            System.out.printf(s, i + 1);
        }
        System.out.println();
        for (int volume = max; volume > min - 1; volume--) {
            for (int idx = 0; idx < count; idx++) {
                String str = volume > array[idx] ? volEmpty : volFilled;
                if (volume == limit && volume <= array[idx]) str = volCorr;
                /*if (volume > array[idx]) {
                    System.out.print(volEmpty);
                } else {
                    System.out.print(volFilled);
                }*/
                System.out.print(str);
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf(s, array[0]);
        for (int i = 1; i < count; i++) {
            System.out.printf(s, array[i]);
        }
        System.out.println();
    }


    /**
     * Just some experiments with {@code Collection}
     */
    private static void collectionsTests() {
        LinkedList<String> list = new LinkedList<>();
        TreeSet<String> set = new TreeSet<>();
        Hashtable<String, String> ht = new Hashtable();

        Collection<String> c = Collections.unmodifiableList(list);


        class View {
            View() {
            }

            void showList(LinkedList<String> list) {
                System.out.println();
                for (String s : list) {
                    System.out.println(list.indexOf(s) + " > " + s);
                }
            }
        }

        View v = new View();
        list.add("0");
        list.add("111");
        list.add("22");
        list.add("3");
        list.add("4444");
        list.add("5 5 5 5 5");
        v.showList(list);
        list.add(5, "55");
        v.showList(list);
        list.remove(4);
        v.showList(list);
        list.add(null);
        v.showList(list);
//        System.out.println(list.get(5));
    }

}