package nodes;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

public class foreachNode extends treeNode {
    private stringNode var1;
    private stringNode var2;
    private stringNode type;
    private blockNode block;
    public foreachNode(stringNode v1, stringNode v2, stringNode t, blockNode b) {
        var1 = v1;
        var2 = v2;
        type = t;
        block = b;
    }
    public Object execute() {
        System.out.println("Salute from foreachNode");
        if (!(Static.variables.containsKey(var2.execute().toString())))
            System.out.println("EXCEPTION: Array does not exist");
        else {
            Object[] ugh = (Object[]) Static.arrays.get(var2.execute().toString());
            Static.variables.put(var1.execute().toString(),type.execute().toString());
            for (Object i : ugh) {
                Static.values.put(var1.execute().toString(), i);
                block.execute();
            }
            Static.variables.remove(var1.execute().toString());
            Static.values.remove(var1.execute().toString());
        }
        return null;
    }
}