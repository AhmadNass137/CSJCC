package nodes;

public class modificationNode extends treeNode {

    public Object execute() {
        String varName = (String) children.get(0).execute();
        String op = (String) children.get(1).execute();
        double varValue;

        if ((Static.values.get(varName) != null)) {
            varValue = Double.parseDouble(Static.values.get(varName).toString());
            if (op.equalsIgnoreCase("++")) {
                varValue++;
            } else if (op.equalsIgnoreCase("--")) {
                varValue--;
            }

            Static.values.put(varName, varValue);
        } else {
            System.out.print("EXCEPTION: Variable is not defined");
        }

        System.out.println("hi from  assign node " + Static.values);

        return null;
    }

}