package Tree;

import java.util.Calendar;
import java.util.Date;

//It is the tree node class consisting of all the necessary informations 
public class TreeNode {
	String directoryName;
	String path;
	Date timestamp;
	TreeNode parentNode;
	LinkedList<TreeNode> childrenNodes;

	// Initializing the constructor
	public TreeNode(String directoryName, TreeNode parentNode) {
		this.directoryName = directoryName;
		this.timestamp = Calendar.getInstance().getTime();
		this.childrenNodes = new LinkedList<TreeNode>();
		this.parentNode = parentNode;
		if (parentNode == null)
			this.path = "R";
		else
			this.path = parentNode.path + "/" + directoryName;
	}
}