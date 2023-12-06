package nodes;

public class arrayNode extends treeNode {
    Object[] x;

    public arrayNode() {
    }


    @Override
    public Object execute() {
        System.out.println("hiiii from me, arrayNode");
        x = new Object[children.size() - 2];
        for (int i = 0; i < children.size() - 2; i++)
            x[i] = children.get(i).execute();
        String name = children.get(children.size() - 1).execute().toString();
        String type = children.get(children.size() - 2).execute().toString() + "[]";
        System.out.println("name " + name + " type " + type);
        Static.variables.put(name, type);
        Static.arrays.put(name, x);
        return null;
    }
}
