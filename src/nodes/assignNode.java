package nodes;

import java.text.ParseException;
import java.util.HashMap;

public class assignNode extends treeNode {
    public Object execute() {
        if (!Static.variables.containsKey(children.get(0).execute()))
            System.out.println("EXCEPTION: Variable doesn't exist");
        Static.values.put((String) children.get(0).execute(), children.get(1).execute());
        System.out.println("hi from  assign node " + Static.values);
        return null;
    }
}
