package nodes;

public class whileNode extends treeNode {
    @Override
    public Object execute() {
        System.out.println("hi from whileNode");
        while ((boolean)children.get(0).execute())
            children.get(1).execute();
        return null;
    }
}
