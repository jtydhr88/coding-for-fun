public class MyQuene {
    MyQueneNode firstQueneNode;
    MyQueneNode lastQueneNode;

    public void add(MyGraphNode node) {
        MyQueneNode myQueneNode = new MyQueneNode(node);

        if (firstQueneNode == null) {
            firstQueneNode = myQueneNode;
        }

        if (lastQueneNode != null) {
            lastQueneNode.setNextNode(myQueneNode);
        }

        lastQueneNode = myQueneNode;
    }

    public MyGraphNode popup() {
        MyGraphNode graphNode = null;

        if (firstQueneNode != null) {
            graphNode = firstQueneNode.graphNode;

            firstQueneNode = firstQueneNode.nextNode;
        }

        if (firstQueneNode == null){
            lastQueneNode = null;
        }

        return graphNode;
    }

    class MyQueneNode {
        MyGraphNode graphNode;
        MyQueneNode nextNode;

        public MyQueneNode(MyGraphNode graphNode) {
            this.graphNode = graphNode;
        }

        public void setNextNode(MyQueneNode nextNode) {
            this.nextNode = nextNode;
        }
    }

}
