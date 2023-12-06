package nodes;

import java.util.Scanner;

public class inputNode extends treeNode {
    Scanner scan = new Scanner(System.in);
    @Override
    public Object execute() {
        Object read = scan.nextLine();
        String name = (String) children.get(0).execute();
        System.out.println("HELLO!! From inputNode");
        if ((Static.variables.containsKey(name))) {
            Static.values.put(name, read);
            System.out.println("values:" + Static.values);
        }
        else
            System.out.print("EXCEPTION: Variable is not defined");
        return null;
    }
}
