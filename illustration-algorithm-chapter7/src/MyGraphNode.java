import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyGraphNode {
    String value;

    Map<MyGraphNode, Integer> siblingNodes = new HashMap<>();

    boolean checked = false;

    public MyGraphNode(String value) {
        this.value = value;
    }

    public void addSiblingNode (MyGraphNode siblingNode, int distance) {
        siblingNodes.put(siblingNode, distance);
    }

}
