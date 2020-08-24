public class SelectionSortTest {

    public static void main(String[] args) throws Exception {
        int[] array = {4,3,2,6,2,9,1};

        int[] r = selectionSort(array);

        System.out.println(r);
    }

    public static int[] selectionSort(int[] array){
        int[] newArray = new int[array.length];

        int max = -1;
        int maxIndex = -1;

        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= max) {
                    max = array[i];

                    maxIndex = i;
                }
            }

            newArray[j] = max;

            max = -1;
            array[maxIndex] = -1;
        }



        return newArray;
    }

}
