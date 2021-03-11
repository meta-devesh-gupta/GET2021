package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Tree.TreeNode;

public class TreeMain {
	public static String stringInput() {

		String token = "";
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		while (true) {
			try {
				token = bufferedReader.readLine();
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return token;
	}

	/**
	 * This method displays the tree structure
	 */
	public static void displayTree(TreeNode currentNode) {
		TreeNode temp = currentNode;
		for (int index = 0; index < temp.childrenNodes.getSize(); index++) {
			System.out.println(temp.childrenNodes.get(index).path);
			displayTree(temp.childrenNodes.get(index));
		}
	}

	/**
	 * This method will find all the directories containing the input name in
	 * directory name
	 * 
	 * @param directoryName
	 *            Directory name to look for
	 * @param currentNode
	 *            Current location in tree
	 * @param flag
	 *            true if find directory containing the same input name
	 * @return true if found else return false
	 */
	public static boolean findDirectory(String directoryName,
			TreeNode currentNode, boolean flag) {
		if (directoryName.length() == 0)
			throw new AssertionError("Directory Name is empty");
		TreeNode temp = currentNode;

		for (int index = 0; index < temp.childrenNodes.getSize(); index++) {
			if (temp.childrenNodes.get(index).directoryName
					.contains(directoryName)) {
				System.out.println(temp.childrenNodes.get(index).path);
				flag = true;
			}
			flag = findDirectory(directoryName, temp.childrenNodes.get(index),
					flag);
		}
		return flag;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode currentNode = tree.root;
		while (true) {
			System.out.println(currentNode.path + "/>");
			String token = stringInput();
			token = token.trim();
			String command = token;
			String directoryName = "";
			for (int index = 0; index < token.length(); index++) {
				if (token.charAt(index) == ' ') {
					command = token.substring(0, index);
					directoryName = token.substring(index + 1);
					break;
				}
			}
			command = command.toLowerCase();
			switch (command) {
			case "":
				break;
			case "mkdir":
				try {
					if (tree.makeDirectory(directoryName, currentNode))
						System.out.println("Directory Created Successfully...");
				} catch (AssertionError assertionError) {
					System.out.println(assertionError.getMessage());
				}

				break;

			case "cd":
				try {
					TreeNode temp = currentNode;
					temp = tree.changeDirectory(directoryName, currentNode);
					if (temp == null)
						throw new AssertionError("Directory not exits...");
					currentNode = temp;
				} catch (AssertionError assertionError) {
					System.out.println(assertionError.getMessage());
				}
				break;

			case "bk":
				try {
					currentNode = tree.moveBack(currentNode);
				} catch (AssertionError assertionError) {
					System.out.println(assertionError.getMessage());
				}
				break;

			case "ls":
				tree.listDirectory(currentNode);
				break;

			case "find":
				try {
					if (!findDirectory(directoryName, currentNode, false))
						System.out.println("Directory does not exists");
				} catch (AssertionError assertionError) {
					System.out.println(assertionError.getMessage());
				}
				break;

			case "tree":
				displayTree(tree.root);
				break;

			case "exit":
				System.exit(0);

			default:
				System.out.println("Command does not exits....");
				break;
			}
		}
	}
}
