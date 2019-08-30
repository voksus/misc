package my_tasks;

/**
 * @author Volodymyr Burtsev at 22.01.2018 13:25
 */
public class Timer {

    private static long timer;
    private static MyThread thread = new MyThread();

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

    public static boolean isFinished() {
        return thread.isFinished();
    }

    public static void timerThreadStart(long millis) {

        thread.setMillis(millis);
        thread.start();
    }

    // class to use additional thread with limit in timer
    static class MyThread extends Thread {

        private boolean result;
        static private long millis = 0;

        public MyThread() {
            result = true;
        }

        @Override
        public void run() {
            if (millis < 1) {
                restart();
                return;
            }

            try {
                result = true;
                sleep(millis);
                result = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean isFinished() {
            return result;
        }

        void setMillis(long millis) {
            this.millis = millis;
        }

        void restart() {
            result = true;
        }

    }
}