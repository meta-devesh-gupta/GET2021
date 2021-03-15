package Dictionary;

public interface Dictionary {

	/**
	 * This method will add the key value pair into the Binary search tree
	 * 
	 * @param key
	 *            It is the key value of the data
	 * @param value
	 *            It is value of the data
	 * @return root node of the binary search tree
	 */
	TreeNode addKeyValue(String key, String value);

	/**
	 * This method will delete the key value pair node from the BST
	 * 
	 * @param key
	 *            It represents the key of the node that is to be deleted
	 * @return root node after deletion
	 */
	TreeNode deleteKeyValue(String key);

	/**
	 * This method will return the value of the given key in the BST
	 * 
	 * @param key
	 *            It is the key of the node whose value is to be returned
	 * @return value of the key
	 */
	String getValue(String key);
	
	/**
	 * This method will return sorted list of key value pairs
	 * 
	 * @return linked list of treenodes
	 */
	LinkedList<TreeNode> getSortedList();

	/**
	 * This method will return the sorted list
	 * 
	 * @return linked list of key value pairs for all the keys >=key1 and <=key2
	 */
	LinkedList<TreeNode> getSortedList(String key1, String key2);
}
