package nodes;

import java.text.ParseException;

public class constNode extends treeNode {
    String value;

    public constNode(String v) {
        this.value = v;
    }

    public constNode() {
    }

    public void setValue(String v) {
        this.value = v;
    }

    public Object execute()  {
        double res = Double.parseDouble(this.value);
        System.out.println("Hi from constNode, res: " + res);
        return res;
    }
}
