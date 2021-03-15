package Dictionary;

//TreeNode for Binary Search Tree
public class TreeNode {
	String key;
	String value;
	TreeNode leftChild;
	TreeNode rightChild;

	public TreeNode(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	@Override
	public String toString() {
		return "TreeNode [key=" + key + ", value=" + value + "]";
	}

}
