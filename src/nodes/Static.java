package nodes;
import java.util.HashMap;
// This class will store the important hash maps that will be used to store the variable names, their values
public class Static {
    static HashMap<String, Object> values = new HashMap();
    static HashMap<String, String> variables = new HashMap();
    static HashMap<String, Object[]> arrays = new HashMap(); // a special map for arrays is needed
    public static Object get(String key) {
        if (!variables.containsKey(key)) {
            System.out.println("EXCEPTION: Variables doesn't exist?!?!?");
            return null;
        }
        String temp = variables.get(key);
        return switch (temp) { // return the value of the variable according to its type
            case "int" -> Integer.parseInt((values.get(key).toString()));
            case "double" -> Double.parseDouble(values.get(key).toString());
            case "string" -> (String) values.get(key);
            case "bool" -> Boolean.parseBoolean(values.get(key).toString());
            case "char" -> ((String) values.get(key)).charAt(0);
            case "int[]", "double[]", "string[]" -> arrays.get(key);
            default -> null;
        };
    }
}
