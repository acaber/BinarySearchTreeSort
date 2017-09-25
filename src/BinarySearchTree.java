/**
 * FileName: BinarySearchTree.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: This class creates the binary tree. It initializes the tree,
 * 		allows new values to be inserted, and orders the values in the tree through
 * 		traversing through each node.
 *
 */
public class BinarySearchTree<BST> {

	private String output = " ";
	private Tree<BST> root = null;

	public Tree<BST> initializeTree(BST input[]) {
		root = null;
		Tree<BST> insertNode;

		for (int i = 0; i < input.length; i++) {
			insertNode = new Tree<>(input[i]);
			root = insertValueToTree(root, insertNode);
		}
		return root;
	}

	public Tree<BST> insertValueToTree(Tree<BST> tree, Tree<BST> node) {

		if (tree == null)
			return node;

		// executes if data is integer
		if (isValidInteger(tree.data)) {

			int value1 = (Integer) tree.data;
			int value2 = (Integer) node.data;

			if (value2 < value1)
				tree.left = insertValueToTree(tree.left, node);
			else if (node.data.equals(tree.data))
				tree.right = insertValueToTree(tree.right, node);
			else if (value2 > value1)
				tree.right = insertValueToTree(tree.right, node);
			return tree;
		}

		// executes if data is fraction
		else {
			Fraction value = (Fraction) node.data;
			int compareValues = (value).compareTo(tree.data);

			if (compareValues < 0)
				tree.left = insertValueToTree(tree.left, node);
			else if (compareValues == 0)
				tree.right = insertValueToTree(tree.right, node);
			else if (compareValues > 0)
				tree.right = insertValueToTree(tree.right, node);
			return tree;
		}
	}

	public boolean isValidInteger(Object data) {
		if (data instanceof Integer)
			return true;
		else
			return false;
	}

	// this method organizes the output in ascending order
	public String inOrderTreeTraversal(Tree<BST> treeData) {
		if (treeData != null) {
			inOrderTreeTraversal(treeData.left);
			output += String.valueOf(treeData.data + " ");
			inOrderTreeTraversal(treeData.right);
		}
		return output;
	}

	// this method organizes the output in descending order
	public String reverseOrderTreeTraversal(Tree<BST> treeData) {
		if (treeData != null) {
			reverseOrderTreeTraversal(treeData.right);
			output += String.valueOf(treeData.data + " ");
			reverseOrderTreeTraversal(treeData.left);
		}
		return output;
	}
}