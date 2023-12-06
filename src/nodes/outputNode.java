package nodes;

public class outputNode extends treeNode {
    String print = ""; // the string to be printed
    String str = ""; // the string to store the result of each child node
    @Override
    public Object execute() {
        str = "";
        print = "";
        System.out.println("Hey From outputNode");
        for (treeNode c: children) { // loop through the children of the node
            str = c.execute().toString(); // execute the child node and convert the result to a string
            if (c instanceof constNode) // constant node is appended to the print string
                print += str;
            else if (c instanceof stringNode)
                if (str.contains("\"")) 
                    print += str.substring(1, str.length() - 1);
                else if (!Static.variables.containsKey(str))
                    System.out.println("EXCEPTION: Variable doesn't exist");
                else if (Static.values.get(str) == null)
                    System.out.println("EXCEPTION: Variable is not initialized");
                else if (Static.values.get(str).toString().contains("\""))
                    print += Static.values.get(str).toString().substring(1, Static.values.get(str).toString().length() - 1);
                else
                    print += Static.values.get(str).toString();
        }
        System.out.println(print);
        return null;
    }
}
