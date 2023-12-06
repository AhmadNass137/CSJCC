package nodes;

import java.text.ParseException;
import java.util.ArrayList;

// treeNode is an abstract parent class parent class from which the statement classes' nodes will be inherited
public abstract class treeNode {
    ArrayList<treeNode> children = new ArrayList();
    public void addChild (treeNode x) {
        children.add(x); // append the child to the end of the array of children
    }
    public abstract Object execute();
}
