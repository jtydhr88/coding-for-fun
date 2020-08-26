public class RecurrenceCountTest {

    public static void main(String[] args) throws Exception {
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);
        MyNode n5 = new MyNode(5);

        n1.nextNode = n2;
        n2.nextNode = n3;
        n3.nextNode = n4;
        n4.nextNode = n5;

        System.out.println(recurrenceCount(n1, 0));
    }



    public static int recurrenceCount(MyNode rootNode, int count) {
        count = count + 1;

        if (rootNode.nextNode == null) {
            return count;
        }

        return recurrenceCount(rootNode.nextNode, count);
    }

}
