import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

public class FastSortTest {
    public static void main(String[] args) throws Exception {
        Integer[] array = {3, 2, 4, 1, 6, 2, 7, 9, 0};

        Integer[] result = fastSort(array);

        System.out.println(result);
    }

    public static Integer[] fastSort(Integer[] array) {
        if (array.length < 2) {
            return array;
        }
        else {
            int pivot = array[0];

            List<Integer> less = new ArrayList<>();

            for (int i = 1; i < array.length; i++) {
                int lessNumber = array[i];

                if (lessNumber <= pivot) {
                    less.add(lessNumber);
                }
            }

            List<Integer> greater = new ArrayList<>();

            for (int i = 1; i < array.length; i++) {
                int greaterNumber = array[i];

                if (greaterNumber > pivot) {
                    greater.add(greaterNumber);
                }
            }

            Integer[] lessSort = fastSort(less.toArray(new Integer[0]));
            Integer[] greaterSort = fastSort(greater.toArray(new Integer[0]));

            Integer[] finalSort = new Integer[lessSort.length + 1 + greaterSort.length];

            for (int i = 0; i < lessSort.length; i++) {
                finalSort[i] = lessSort[i];
            }

            finalSort[lessSort.length] = pivot;

            for (int i = 0; i < greaterSort.length; i++) {
                finalSort[lessSort.length + 1 + i] = greaterSort[i];
            }

            return finalSort;
        }
    }

}
