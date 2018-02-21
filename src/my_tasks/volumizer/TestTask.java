package my_tasks.volumizer;

/**
 * @author Artur at 12.12.2017 13:40
 */
public class TestTask {

    private static final int LOWER_LIMIT = 10;
    private static final int UPPER_LIMIT = 200;
    private static int count = 0;
    private static int storageVolume;
    private static int[] buckets;

    public static void main(String[] args) {

        int[] bucketsVolumes = {1, 2, 5, 10};

        countOptionsToFillVolume(12, bucketsVolumes);

    }

    private static void countOptionsToFillVolume(int volume, int[] bucket) {

        storageVolume = volume;
        buckets = bucket;
        if (storageVolume >= LOWER_LIMIT && storageVolume <= UPPER_LIMIT) {

            checkBucket(-1, null);

            System.out.println("\n--------\nИтого, при n = " + storageVolume + " наш ответ будет: " + count);
        } else {
            System.err.println("invalid value of storageVolume: " + storageVolume);
        }
    }
    private static void checkBucket(int iteration, int[] bucketsCount){
        if (bucketsCount == null) {
            bucketsCount = new int[buckets.length];
        }
        iteration++;
        for (int i = 0; i <= storageVolume / buckets[iteration]; i++) {
            int currentVol = storageVolume - buckets[iteration] * (i + 1);
            bucketsCount[iteration] = i + 1;
            if (currentVol == 0) {
                System.out.print(++count + ") ");
                for (int p = 0; p < buckets.length; p++) {
                    System.out.print(bucketsCount[p] + "*" + buckets[p] + "л");
                    if (p + 1 < buckets.length) {
                        System.out.print(" + ");
                    } else {
                        System.out.println();
                    }
                }
                break;
            } else if (currentVol < 0) {
                checkBucket(iteration, bucketsCount);
            }
        }
    }
}