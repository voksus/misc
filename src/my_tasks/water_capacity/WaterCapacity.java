package my_tasks.water_capacity;

/**
 * Created by voksus on 01.03.2017.
 */
public class WaterCapacity {

    public static void main(String[] args) {

        int[] myIntArray = {2, 6, 1, 2, 3, 4, 7, 9, 6, 5, 2, 1, 3, 2, 1, 1, 1, 4, 7, 1, 3};
        System.out.println(calculateVolume(myIntArray));

    }

    public static int calculateVolume(int[] land) {

        int max = 0;
        for (int i : land) {
            max = max < i ? i : max;
        }

        System.out.println();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < land.length; j++) {
                System.out.print(land[j] + i < max ? " - " : "[" + (land[j] == max - i ? max - i : "+") + "]");
            }
            System.out.println();
        }
        System.out.println();

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = land.length - 1;
        int volume = 0;

        while (left < right) {
            if (land[left] > leftMax) {
                leftMax = land[left];
            }
            if (land[right] > rightMax) {
                rightMax = land[right];
            }
            if (leftMax >= rightMax) {
                volume += rightMax - land[right];
                right--;
            } else {
                volume += leftMax - land[left];
                left++;
            }
        }
        return volume;
    }
}