import java.util.ArrayList;
import java.util.List;

public class BucketTreeNode {

    int[] statees;

    public List<BucketTreeNode> children = new ArrayList<>();

    public BucketTreeNode(int[] states) {
        this.statees = states;
    }

    public boolean equals(Object obj){
        BucketTreeNode node = (BucketTreeNode)obj;

        for (int i = 0; i < statees.length; i++) {
            if (this.statees[i] != node.statees[i]) {
                return false;
            }
        }
        return true;
    }
}
