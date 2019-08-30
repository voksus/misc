package my_tasks.temp;

import my_tasks.Timer;

/**
 * @author Volodymyr Burtsev at 18.08.2019 1:12
 */
public class Temp2 {

    public static void main(String[] args) {

        long count = 0;
        long timer = 5000;

        System.out.println("Started...");
        Timer.timerThreadStart(timer);

        while (Timer.isFinished()) {
            if ("Hello".intern() == "Hello".intern()) count++;
        }

        /*
        System.out.printf("%,d times\n", count);

        t.thread.restart();
        count = 0;

        while (Timer.thread.getResult()) {
            if (new String("Hello").equals(new String("Hello"))) count++;
        }
        */

        System.out.printf("%,d times\n", count);

        System.out.println("Finished!\n" + (timer / 1000) + " sec used");
    }
}