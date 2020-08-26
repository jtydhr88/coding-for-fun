import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyGraphNode {

    int value;

    Set<MyGraphNode> siblingNodes = new HashSet<>();

    boolean checked = false;

    public MyGraphNode(int value) {
        this.value = value;
    }

    public void addSiblingNode (MyGraphNode siblingNode) {
        siblingNodes.add(siblingNode);
    }

}
