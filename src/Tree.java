/**
 * FileName: Tree.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: This class holds the nodes in the tree.
 *
 */

public class Tree<BST> {

	public Tree<BST> right;
	public Tree<BST> left;
	public BST data;

	public Tree(BST data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Tree<BST> getRightNode() {
		return right;
	}

	public Tree<BST> getLeftNode() {
		return left;
	}

	@Override
	public String toString() {
		return data + " ";
	}

}