package nodes;

import java.text.ParseException;
import java.util.ArrayList;

public class blockNode extends treeNode {
    @Override
    public Object execute()  {
        System.out.println("Hi from Block node ");
        for (treeNode c: children)
            c.execute();
        return null;
    }
}
