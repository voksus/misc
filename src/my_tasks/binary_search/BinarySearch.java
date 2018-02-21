package my_tasks.binary_search;

/**
 * @author Volodymyr Burtsev at 18.12.2017 13:24
 */
// Java implementation of iterative Binary Search
class BinarySearch {
    // Returns index of x if it is present in arr[], else return -1
    int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x) {
                System.out.println(l + " " + m + " " + r);
                return m;
            }

            // If x greater, ignore left half
            if (arr[m] < x) {
                l = m + 1;
            }

            // If x is smaller, ignore right half
            else {
                r = m - 1;
            }
        }

        // if we reach here, then element was not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        System.out.println(args.length);
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 12, 28, 35, 49, 62, 73, 86, 98, 120};
        int n = arr.length;
        int x = 98;
        int result = ob.binarySearch(arr, x);
        if (result == -1) {
            System.out.println("Element not present");
        }
        else
            System.out.println("Element found at index " + result);
    }
}