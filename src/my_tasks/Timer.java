package my_tasks;

/**
 * @author Volodymyr Burtsev at 22.01.2018 13:25
 */
public class Timer {

    private static long timer;

    public static long timerStop() {
        long delta = System.currentTimeMillis() - timer;
        timerStart();
        return delta;
    }

    public static long timerStop(boolean showUsedTime) {
        long delta = System.currentTimeMillis() - timer;
        if (showUsedTime) System.out.printf("Time used: %,d millis%n", delta);
        timerStart();
        return delta;
    }

    public static void timerStart() {
        timer = System.currentTimeMillis();
    }

}