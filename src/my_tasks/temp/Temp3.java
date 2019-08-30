package my_tasks.temp;

import my_tasks.Timer;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Volodymyr Burtsev at 23.08.2019 12:35
 */
public class Temp3 {

    private static int[] arr = new int[1 << 18];
    private final static Random r = new Random();

    public static void main(String[] args) {

        // generating the array with random int values
        System.out.printf("\nGenerating random int...\nTotally %,d numbers.\n", arr.length);
        Timer.timerStart();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1 << 5);
        }
        System.out.println("Done!");
        Timer.timerStop(true);

        // sort the array using my solution
        System.out.println("\nTrying to sort the array using my own method...");
        Timer.timerStart();
        sort(arr);
        System.out.println("Done!");
        Timer.timerStop(true);
//        Arrays.stream(arr).mapToObj((s) -> s + " ").forEachOrdered(System.out::print);

        System.exit(0);

        // sort the array using 'Arrays.sort'
        System.out.println("\nTrying to sort the array using Arrays.sort() method...");
        Timer.timerStart();
        Arrays.sort(arr);
        System.out.println("Done!");
        Timer.timerStop(true);
    }

    private static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

}