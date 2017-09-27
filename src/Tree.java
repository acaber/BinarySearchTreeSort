/**
 * FileName: Tree.java 
 * Author: Rebecca Johnson 
 * Date: 9/24/2017 
 * Description: This class holds the nodes in the tree.
 */

public class Tree<BST> {

	//to hold left child node
	public Tree<BST> leftChild;
	
	//to hold right child node
	public Tree<BST> rightChild;
	
	//to hold the key
	public BST key;

	//constructor
	public Tree(BST key) {
		this.key = key;
		this.leftChild = null;
		this.rightChild = null;
	}

	//this method returns the right node when called
	public Tree<BST> getRightNode() {
		return rightChild;
	}

	//this method returns the left node when called
	public Tree<BST> getLeftNode() {
		return leftChild;
	}

	//to string method
	@Override
	public String toString() {
		return key + " ";
	}

}