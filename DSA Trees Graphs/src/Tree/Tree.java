package Tree;

public class Tree {
	TreeNode root = new TreeNode("/", null);

	/**
	 * This method will create the new directory in current directory
	 * 
	 * @param directoryName
	 *            The directory name of new directory
	 * @param currentNode
	 *            current tree node where directory has to be created
	 * @return true if directory is created else return false if directory exits
	 */
	public boolean makeDirectory(String directoryName, TreeNode currentNode) {
		if (directoryName.length() == 0)
			return false;
		if (isPresentInCurrentDirectory(directoryName, currentNode))
			throw new AssertionError("Directory Already exists");
		// throw new AssertionError("directory already exists");
		TreeNode treeNode = new TreeNode(directoryName, currentNode);
		currentNode.childrenNodes.add(treeNode);
		return true;
	}

	/**
	 * It is the helper method to check whether the directory with same
	 * directory name as input exists already or not
	 * 
	 * @return true if directory exists else return false
	 */
	private boolean isPresentInCurrentDirectory(String directoryName,
			TreeNode currentNode) {
		// Traversing the children nodes of current directory and matching the
		// name
		if (currentNode.childrenNodes == null)
			return false;
		for (int index = 0; index < currentNode.childrenNodes.getSize(); index++) {
			if (currentNode.childrenNodes.get(index).directoryName
					.equalsIgnoreCase(directoryName))
				return true;
		}
		return false;
	}

	/**
	 * This method move back to its parent directory
	 * 
	 * @return parent tree node of current tree node
	 */
	public TreeNode moveBack(TreeNode currentNode) {
		if (currentNode == root)
			throw new AssertionError("Root directory can't go back ");
		return currentNode.parentNode;
	}

	/**
	 * This method lists all the directory exists in current directory
	 * 
	 * @param currentNode
	 *            It is the current location where we have to list all directory
	 */
	public void listDirectory(TreeNode currentNode) {
		TreeNode temp = currentNode;
		for (int index = 0; index < temp.childrenNodes.getSize(); index++) {
			TreeNode node = temp.childrenNodes.get(index);
			System.out.println(node.timestamp + "\t" + node.directoryName);
		}
	}

	/**
	 * This method changes the directory location
	 * 
	 * @param directoryName
	 *            It is the directory name of next directory
	 * @param currentNode
	 *            It is the current location
	 * @return current location node after changind directory
	 */
	public TreeNode changeDirectory(String directoryName, TreeNode currentNode) {
		if (directoryName.length() == 0)
			throw new AssertionError("Directory name is empty");
		TreeNode temp = currentNode;
		TreeNode newNode = null;
		int index;
		for (index = 0; index < temp.childrenNodes.getSize(); index++) {
			if (temp.childrenNodes.get(index).directoryName
					.equalsIgnoreCase(directoryName)) {
				newNode = temp.childrenNodes.get(index);
				break;
			}
		}
		return newNode;
	}

	// public static void main(String[] args) {
	// Tree tree = new Tree();
	// System.out.println(tree.makeDirectory("DJ", tree.root));
	// System.out.println(tree.makeDirectory("com", tree.root));
	// System.out.println(tree.makeDirectory("org", tree.root));
	// System.out.println(tree.makeDirectory("metacube", tree.root));
	// System.out.println(tree.makeDirectory("metaphore", tree.root));
	// TreeNode cd = tree.changeDirectory("DJ", tree.root);
	// tree.makeDirectory("dsa", cd);
	// tree.makeDirectory("stack", cd);
	// tree.makeDirectory("tree", cd);
	// tree.makeDirectory("metamoto", cd);
	// // cd = tree.moveBack(cd);
	// tree.displayTree(tree.root);
	// tree.listDirectory(cd);
	// System.out.println(tree.findDirectory("meta", tree.root));
	// }
}
