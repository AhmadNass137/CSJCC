package nodes;

public class conditionNode extends treeNode {
    String cond;
    public conditionNode(String cond) {
        this.cond = cond; // the condition operator, such as &&, ||, ==, etc.
    }
    public conditionNode() { }
    public Object execute() {
        System.out.println("Hola from conditionNode");
        Object v1 = children.get(0).execute(); // evaluate the first operand
        Object v2 = children.get(1).execute(); // evaluate the second operand
        String op = (String) children.get(2).execute(); // get the comparison operator, such as >, <, >=, etc.
        System.out.println("v1 is " + v1 + " v2 is " + v2);
        if(!isNumeric(v1.toString())){
            String test1 = (String)v1;
            v1 = Static.values.get(test1); // get the value of the variable from the static map
        }
        if(!isNumeric(v2.toString())){
            String test2 = (String)v2;
            v2 = Static.values.get(test2); // get the value of the variable from the static map
            System.out.println("v1 is " + v1 + " v2 is " + v2);
        }
        System.out.println("v1 is " + v1 + " v2 is " + v2);
        switch (op) {
            case "==":
                return (v1.equals(v2)); // check if the values are equal
            case "!=":
                System.out.println(!v1.equals(v2));
                return (!v1.equals(v2)); // check if the values are not equal
            case ">":
                System.out.println(v2);
                return (Double.parseDouble(v1.toString()) > Double.parseDouble((String) v2.toString())); // check if the first value is greater than the second value
            case "<":
                return (Double.parseDouble(v1.toString()) < Double.parseDouble(v2.toString())); // check if the first value is less than the second value
            case ">=":
                return (Double.parseDouble(v1.toString()) >= Double.parseDouble(v2.toString())); // check if the first value is greater than or equal to the second value
            case "<=":
                return (Double.parseDouble(v1.toString()) <= Double.parseDouble(v2.toString())); // check if the first value is less than or equal to the second value
        }

        return switch (cond) {
            case "&&" -> (Boolean) v1 && (Boolean) v2; // return the logical AND of the values
            case "||" -> (Boolean) v1 || (Boolean) v2; // return the logical OR of the values
            default -> true; // return true by default
        };

    }
    // function to check if the given string could be interpreted as a double data type
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
