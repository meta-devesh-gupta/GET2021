package Dictionary;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DictionaryImpl implements Dictionary {
	private TreeNode root;

	/**
	 * Constructor to create a dictionary with a specified initial dictionary
	 * entries
	 * 
	 * @param jsonObject
	 *            It is the input jsonObject to initialize the dictionary
	 */
	public DictionaryImpl(JSONObject jsonObject) {
		try {
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int index = 0; index < jsonArray.length(); index++) {
				String key = jsonArray.getJSONObject(index).getString("key");
				String value = jsonArray.getJSONObject(index)
						.getString("value");
				addKeyValue(key, value);
			}
		} catch (JSONException jsonException) {
			System.out.println(jsonException.getMessage());
		}
	}

	/**
	 * This method will add the key value pair into the Binary search tree
	 * 
	 * @param key
	 *            It is the key value of the data
	 * @param value
	 *            It is value of the data
	 * @return root node of the binary search tree
	 */
	@Override
	public TreeNode addKeyValue(String key, String value) {
		root = addKeyValueRecursive(root, key, value);
		return root;
	}

	/**
	 * This is the private helper method to add the key value pair into the
	 * binary search tree recursively
	 * 
	 * @param currentNode
	 *            It is the current node of the BST
	 * @param key
	 *            It is the key value of the data
	 * @param value
	 *            It is value of the data
	 * @return root node of the binary search tree
	 */
	private TreeNode addKeyValueRecursive(TreeNode currentNode, String key,
			String value) {
		TreeNode node = new TreeNode(key, value);
		if (currentNode == null) {
			currentNode = node;
			return currentNode;
		}
		if (currentNode.key.compareTo(key) < 0)
			currentNode.rightChild = addKeyValueRecursive(
					currentNode.rightChild, key, value);
		else if (currentNode.key.compareTo(key) > 0)
			currentNode.leftChild = addKeyValueRecursive(currentNode.leftChild,
					key, value);
		return currentNode;
	}

	/**
	 * This method will delete the key value pair node from the BST
	 * 
	 * @param key
	 *            It represents the key of the node that is to be deleted
	 * @return root node after deletion
	 */
	@Override
	public TreeNode deleteKeyValue(String key) {
		root = deleteKeyValueRecursive(root, key);
		return root;
	}

	/**
	 * This is the private helper method to delete the key value pair node
	 * recursively from the BST
	 * 
	 * @param currentNode
	 *            It represents the current position in the tree
	 * @param key
	 *            It represents the key of the node that is to be deleted
	 * @return root node after deletion
	 */
	private TreeNode deleteKeyValueRecursive(TreeNode currentNode, String key) {
		if (currentNode.key.compareTo(key) < 0)
			currentNode.rightChild = deleteKeyValueRecursive(
					currentNode.rightChild, key);
		else if (currentNode.key.compareTo(key) > 0)
			currentNode.leftChild = deleteKeyValueRecursive(
					currentNode.leftChild, key);
		else {
			if (currentNode.leftChild == null && currentNode.rightChild == null)
				currentNode = null;
			else if (currentNode.leftChild == null)
				currentNode = currentNode.rightChild;
			else if (currentNode.rightChild == null)
				currentNode = currentNode.leftChild;
			else {
				// finding minimum key node in left child of right subtree
				TreeNode minNode = findMinNode(currentNode.rightChild);
				currentNode.key = minNode.key; // copying the value
				currentNode.value = minNode.value;

				// deleting the leaf node
				currentNode.rightChild = deleteKeyValueRecursive(
						currentNode.rightChild, currentNode.key);
			}

		}
		return currentNode;
	}

	/**
	 * Private helper method to find the minimum value node
	 * 
	 * @param currentNode
	 *            It is the node in which we have to find the minimum value
	 * @return minimum value node
	 */
	private TreeNode findMinNode(TreeNode currentNode) {
		while (currentNode.leftChild != null) {
			currentNode = currentNode.leftChild;
		}
		return currentNode;
	}

	/**
	 * This method will return the value of the given key in the BST
	 * 
	 * @param key
	 *            It is the key of the node whose value is to be returned
	 * @return value of the key
	 */
	@Override
	public String getValue(String key) {
		TreeNode node = searchRecusive(root, key);
		if (node == null)
			throw new AssertionError("Key not found");
		return node.value;
	}

	/**
	 * Private helper method which will find the node of the input key
	 * 
	 * @param currentNode
	 *            Current position in the BST
	 * @param key
	 *            It is the key of the node which needs to be returned
	 * @return node having same key as given in input
	 */
	private TreeNode searchRecusive(TreeNode currentNode, String key) {
		if (currentNode == null)
			return null;
		if (currentNode.key.compareTo(key) == 0)
			return currentNode;
		else if (currentNode.key.compareTo(key) < 0)
			return searchRecusive(currentNode.rightChild, key);
		else
			return searchRecusive(currentNode.leftChild, key);
	}

	/**
	 * This method will return sorted list of key value pairs
	 * 
	 * @return linked list of treenodes
	 */
	@Override
	public LinkedList<TreeNode> getSortedList() {
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		getSortedListRecursive(root, linkedList);
		return linkedList;
	}

	// private helper method to get the sorted list
	private void getSortedListRecursive(TreeNode currentNode,
			LinkedList<TreeNode> linkedList) {
		if (currentNode == null)
			return;
		getSortedListRecursive(currentNode.leftChild, linkedList);
		linkedList.add(currentNode);
		getSortedListRecursive(currentNode.rightChild, linkedList);
	}

	/**
	 * This method will return the sorted list
	 * 
	 * @return linked list of key value pairs for all the keys >=key1 and <=key2
	 */
	@Override
	public LinkedList<TreeNode> getSortedList(String key1, String key2) {
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		getSortedListRecursive(root, linkedList, key1, key2);
		return linkedList;
	}

	// private helper method to get linked list of key value pairs for all the
	// keys >=key1 and <=key2
	private void getSortedListRecursive(TreeNode currentNode,
			LinkedList<TreeNode> linkedList, String key1, String key2) {
		if (currentNode == null)
			return;
		getSortedListRecursive(currentNode.leftChild, linkedList, key1, key2);
		if (currentNode.key.compareTo(key1) >= 0
				&& currentNode.key.compareTo(key2) <= 0)
			linkedList.add(currentNode);
		getSortedListRecursive(currentNode.rightChild, linkedList, key1, key2);
	}

	// For the traversal of the BST
	public void traverse() {
		traverseRecursive(root);
	}

	// Helper method to traverse the BST recursively
	private void traverseRecursive(TreeNode currentNode) {
		if (currentNode == null)
			return;
		traverseRecursive(currentNode.leftChild);
		System.out.println(currentNode);
		traverseRecursive(currentNode.rightChild);
	}

	public static void main(String[] args) {

		try {
			JSONObject jsonObject = new JSONObject("{data:[{key:50, value: A},"
					+ "{key:30, value:B}," + "{key:70, value:C},"
					+ "{key:10, value:D}," + "{key:60, value:E},"
					+ "{key:90, value:F}," + "{key:55, value:G},"
					+ "{key:65, value:H}," + "{key:63, value:I},"
					+ "{key:64, value:J}]}");
			// System.out.println(jsonObject.getJSONArray("data"));
			DictionaryImpl dictionaryImpl = new DictionaryImpl(jsonObject);
			// dictionaryImpl.deleteKeyValue("50");
			System.out.println(dictionaryImpl.getValue("65"));
			dictionaryImpl.traverse();

			// System.out.println(dictionaryImpl.search("60"));
			// dictionaryImpl.getSortedList("30", "65").display();
		} catch (JSONException jsonException) {
			System.out.println(jsonException.getMessage());
		}
	}
}
