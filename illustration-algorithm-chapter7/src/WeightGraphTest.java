import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightGraphTest {
    public static void main(String[] args) throws Exception {
        MyGraphNode start = new MyGraphNode("Start");
        MyGraphNode a = new MyGraphNode("A");
        MyGraphNode b = new MyGraphNode("B");
        MyGraphNode c = new MyGraphNode("C");
        MyGraphNode end = new MyGraphNode("End");

        start.addSiblingNode(a, 10);

        a.addSiblingNode(b, 20);

        b.addSiblingNode(c, 1);
        b.addSiblingNode(end, 30);

        c.addSiblingNode(a,1);

        Map<MyGraphNode, Integer> costs = new HashMap<>();
        Map<MyGraphNode, MyGraphNode> parents = new HashMap<>();

        for (MyGraphNode sibling : start.siblingNodes.keySet()) {
            costs.put(sibling, start.siblingNodes.get(sibling));
            parents.put(sibling, start);
        }

        Set<MyGraphNode> processed = new HashSet<>();

        MyGraphNode node = findLowestCostNode(costs, processed);

        while (node != null) {
            Integer cost = costs.get(node);

            Map<MyGraphNode, Integer> siblingNodes = node.siblingNodes;

            for (MyGraphNode siblingNode : siblingNodes.keySet()) {
                int newCost = cost + siblingNodes.get(siblingNode);

                Integer oldCost = costs.get(siblingNode);

                if (oldCost == null || oldCost > newCost) {
                    costs.put(siblingNode, newCost);
                    parents.put(siblingNode, node);
                }
            }

            processed.add(node);

            node = findLowestCostNode(costs, processed);
        }

        System.out.println(costs.get(end));

        MyGraphNode routeNode = end;

        while(routeNode != null) {
            MyGraphNode parentNode = parents.get(routeNode);

            if (parentNode != null) {
                System.out.println(parentNode.value);

                routeNode = parentNode;
            }
        }
    }

    public static MyGraphNode findLowestCostNode(Map<MyGraphNode, Integer> costs, Set<MyGraphNode> processed) {
        MyGraphNode lowestNode = null;
        Integer lowestCost = null;

        for (MyGraphNode node : costs.keySet()) {
            Integer cost = costs.get(node);

            if (cost == null) {
                continue;
            }

            if (processed.contains(node)) {
                continue;
            }

            if (lowestCost == null || lowestCost > cost) {
                lowestCost = cost;

                lowestNode = node;
            }
        }

        return lowestNode;
    }

}
