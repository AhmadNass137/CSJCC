package nodes;

public class valueNode extends treeNode {
    Object value;

    public valueNode(Object v) {
        this.value = v;
    }

    public valueNode() {
    }

    public void setValue(Object v) {
        this.value = v;
    }

    public Object execute()  {
        System.out.println("Hi from valueNode, res: " + this.value);
        return this.value;
    }
}
