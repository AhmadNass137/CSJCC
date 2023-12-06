package nodes;

import java.text.ParseException;

public class stringNode extends treeNode {
    String value;

    public stringNode (String x) {
        this.value = x;
    }
    public stringNode () {}

    public Object execute() {
        System.out.println("Hi from stringNode. value: " + value);
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
