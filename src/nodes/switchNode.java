package nodes;

import java.lang.reflect.Array;

public class switchNode extends treeNode {
    boolean executed;
    String str;
    @Override
    public Object execute() {
        System.out.println("Hi from switchNode");
        executed = false;
        if (!Static.variables.containsKey(children.get(0).execute().toString()))
            System.out.println("Variable doesn't exist" + children.get(0).execute().toString());
        else {
            if (Static.variables.get(children.get(0).execute().toString()).equals("int")) { // int
                str = String.valueOf((Static.values.get(children.get(0).execute().toString()).toString())) + ".0";
                for (int i = 1; i <= (children.size() - 2) / 2; i++) {
                    System.out.println(str + " AND " + String.valueOf(children.get(2 * i - 1).execute().toString()));
                    if (str.equals(String.valueOf(children.get(2 * i - 1).execute().toString()))) {
                        children.get(2 * i).execute();
                        executed = true;
                    }
                }
            }
            else if (Static.variables.get(children.get(0).execute().toString()).equals("double")) { // double
                str = String.valueOf(Static.values.get(children.get(0).execute().toString()).toString());
                for (int i = 1; i <= (children.size() - 2) / 2; i++)
                    if (str.equals(String.valueOf(children.get(2 * i - 1).execute()))) {
                        children.get(2 * i).execute();
                        executed = true;
                    }
            } else {
                str = Static.values.get(children.get(0).execute().toString()).toString();
                for (int i = 1; i <= (children.size() - 2) / 2; i++)
                    if (str.equals(children.get(2 * i - 1).execute().toString())) {
                        children.get(2 * i).execute();
                        executed = true;
                    }
            }
            if (!executed)
                children.get(children.size() - 1).execute();
        }
        return null;
    }
}