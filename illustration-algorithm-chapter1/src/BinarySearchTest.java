public class BinarySearchTest {
    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int r = binarySearch(array, 99);

        System.out.println(r);
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            int midValue = array[mid];

            if (midValue == target) {
                return mid;
            }

            if (midValue > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
