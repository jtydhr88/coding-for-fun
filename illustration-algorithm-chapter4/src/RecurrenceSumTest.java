import java.util.Arrays;

public class RecurrenceSumTest {

    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println(recurrenceSum(array));
    }

    public static int recurrenceSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        return array[0] + recurrenceSum(Arrays.copyOfRange(array, 1, array.length));
    }

}
