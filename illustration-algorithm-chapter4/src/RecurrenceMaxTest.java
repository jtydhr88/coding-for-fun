public class RecurrenceMaxTest {

    public static void main(String[] args) throws Exception {
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(77);
        MyNode n4 = new MyNode(4);
        MyNode n5 = new MyNode(5);

        n1.nextNode = n2;
        n2.nextNode = n3;
        n3.nextNode = n4;
        n4.nextNode = n5;

        System.out.println(recurrenceMax(n1, -1));
    }

    public static int recurrenceMax(MyNode node, int max) {
        if (max < node.value) {
            max = node.value;
        }

        if (node.nextNode == null) {
            return max;
        }

        return recurrenceMax(node.nextNode, max);
    }
}
