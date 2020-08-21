public class CircleQueueTest {

    public static void main(String[] args) throws Exception {
        CircleQueue c1 = new CircleQueue(9);

        for (int i = 3; i < 8; i++) {
            c1.add(String.valueOf(i));
        }

        System.out.println(c1.head());
        System.out.println(c1.end());

        System.out.println();

        String[] result = c1.showAll();

        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }

}
