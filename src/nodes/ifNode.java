package nodes;

public class ifNode extends treeNode {
	public Object execute() {
		if ((boolean)children.get(0).execute()) {
			System.out.println("hi from ifNode");
			children.get(1).execute();
		}
		else
			if (children.size() == 3)
				children.get(2).execute();
		return null;
	}
}
