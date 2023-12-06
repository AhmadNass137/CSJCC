package nodes;

import java.text.ParseException;
import java.util.HashMap;

public class declareNode extends treeNode {

    @Override
    public Object execute() {
        if (Static.variables.containsKey((String) children.get(0).execute())) {
            System.out.println("EXCEPTION: Key Already Exists");
        }
            Static.variables.put((String) children.get(0).execute(), (String) children.get(1).execute());
            System.out.println("Hi from declarationNode. map: " + Static.variables);
            if (children.size() == 3)
                Static.values.put((String) children.get(0).execute(), children.get(2).execute());
            System.out.println("Hi from declaration & assign. values: " + Static.values);

        return null;
    }
}