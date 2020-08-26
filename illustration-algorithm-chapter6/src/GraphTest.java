import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphTest {

    public static void main(String[] args) throws Exception {
        MyGraphNode n1 = new MyGraphNode(1);
        MyGraphNode n2 = new MyGraphNode(2);
        MyGraphNode n3 = new MyGraphNode(3);
        MyGraphNode n4 = new MyGraphNode(4);
        MyGraphNode n5 = new MyGraphNode(5);
        MyGraphNode n6 = new MyGraphNode(6);
        MyGraphNode n7 = new MyGraphNode(7);
        MyGraphNode n8 = new MyGraphNode(8);
        MyGraphNode n9 = new MyGraphNode(9);

        n1.addSiblingNode(n2);
        n1.addSiblingNode(n3);
        n1.addSiblingNode(n4);
        n1.addSiblingNode(n5);

        n2.addSiblingNode(n7);
        n2.addSiblingNode(n5);

        n3.addSiblingNode(n8);
        n3.addSiblingNode(n6);

        n4.addSiblingNode(n8);

        n5.addSiblingNode(n7);
        n5.addSiblingNode(n9);

        n6.addSiblingNode(n2);

        n8.addSiblingNode(n9);

        breadthFirstSearch(n2);
    }

    public static void breadthFirstSearch(MyGraphNode myGraphNode) {
        Queue<MyGraphNode> myQueue=new LinkedList<>();

        myQueue.add(myGraphNode);

        while (!myQueue.isEmpty()) {
            MyGraphNode node = myQueue.poll();

            System.out.println(node.value);

            for (MyGraphNode sn : node.siblingNodes) {
                if (!sn.checked) {
                    myQueue.add(sn);
                    sn.checked = true;
                }
            }

        }
    }
}
