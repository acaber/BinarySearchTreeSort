/**
 * FileName: BinarySearchTree.java 
 * Author: Rebecca Johnson 
 * Date: 9/24/2017
 * Description: This class creates the binary tree. It initializes the tree,
 * allows new values to be inserted, and orders the values in the tree through
 * traversing through each node.
 *
 */

public class BinarySearchTree<BST> {

	//used to store the sorted string
	private String output = " ";
	
	//root of the tree
	private Tree<BST> root;

	//this method initializes the tree
	public Tree<BST> initializeTree(BST inputArray[]) {
		
		//initializes the root to null each time this method is called
		root = null;
		Tree<BST> insertNode;

		//loops through each element in the input and calls insertNodeToTree method to 
		//		store data in each node on the tree
		for (int i = 0; i < inputArray.length; i++) {
			insertNode = new Tree<>(inputArray[i]);
			root = insertNodeToTree(root, insertNode);
		}
		return root;
	}

	//this method is what inserts each node to the tree
	public Tree<BST> insertNodeToTree(Tree<BST> rootNode, Tree<BST> nextNode) {

		//checks if the rootNode is null
		if (rootNode == null)
			return nextNode;

		//executes if the data is an integer
		if (isValidInteger(rootNode.key)) {

			//converts the given nodes to integers and stores them to a variable
			int parentNode = (Integer) rootNode.key;
			int newNode = (Integer) nextNode.key;

			//if the new node is less that the current node, it will store the data to the left node
			if (newNode < parentNode)
				rootNode.leftChild = insertNodeToTree(rootNode.leftChild, nextNode);
			
			//if the new node equals the current node, it will store the data to the right node
			else if (newNode == parentNode)
				rootNode.rightChild = insertNodeToTree(rootNode.rightChild, nextNode);
			
			//if the new node is greater than the current node, it will store the data to the right side
			else if (newNode > parentNode)
				rootNode.rightChild = insertNodeToTree(rootNode.rightChild, nextNode);
			
			return rootNode;
		}

		//executes if data is a fraction
		else {

			//creates a fraction variable and stores the new node data to it
			Fraction newFractionNode = (Fraction) nextNode.key;
			
			//variable to hold the return value of comparing the two nodes
			int compareNodes = (newFractionNode).compareTo(rootNode.key);

			//if the new node is less that the current node, it will store the data to the left node 
			if (compareNodes < 0)
				rootNode.leftChild = insertNodeToTree(rootNode.leftChild, nextNode);
			
			//if the new node equals the current node, it will store the data to the right node
			else if (compareNodes == 0)
				rootNode.rightChild = insertNodeToTree(rootNode.rightChild, nextNode);
			
			//if the new node is greater than the current node, it will store the data to the right side
			else if (compareNodes > 0)
				rootNode.rightChild = insertNodeToTree(rootNode.rightChild, nextNode);
			
			return rootNode;
		}
	}

	//this method checks if an object is an integer
	public boolean isValidInteger(Object node) {
		
		//if object is an integer, return true
		if (node instanceof Integer)
			return true;
		
		//otherwise, return false
		else
			return false;
	}

	// this method organizes the output in ascending order
	public String inOrderTreeTraversal(Tree<BST> node) {
		
		//will execute as long as there are nodes remaining
		if (node != null) {
			
			//starts with the left node
			inOrderTreeTraversal(node.leftChild);
			
			//stores each node to the output string
			output += String.valueOf(node.key + " ");
			
			//then will traverse to the right node
			inOrderTreeTraversal(node.rightChild);
		}
		return output;
	}

	// this method organizes the output in descending order
	public String reverseOrderTreeTraversal(Tree<BST> node) {
		
		//will execute as long as there are nodes remaining
		if (node != null) {
			
			//starts with the right node
			reverseOrderTreeTraversal(node.rightChild);
			
			//stores each node to the output string
			output += String.valueOf(node.key + " ");
			
			//then will traverse to the left node
			reverseOrderTreeTraversal(node.leftChild);
		}
		return output;
	}
}