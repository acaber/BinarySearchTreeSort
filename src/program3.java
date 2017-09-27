/**
 * FileName: program3.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: This class builds the GUI and reads the user's input. 
 * 		It contains the main method.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class program3 extends JFrame {

	//creates a new binary tree search class instance
	private static BinarySearchTree binaryTree;
	
	//to hold the sorted list
	private static String sortedList = "";

	//labels
	private JLabel originalListLabel;
	private JLabel sortedListLabel;

	//text fields
	private static JTextField originalListText;
	private static JTextField sortedListText;

	//perform sort button
	private static JButton performSortBtn;

	//radio buttons
	private static JRadioButton ascendingRadioBtn;
	private static JRadioButton descendingRadioBtn;
	private static JRadioButton integerRadioBtn;
	private static JRadioButton fractionRadioBtn;

	//button groups
	private ButtonGroup sortOrderBtnGroup;
	private ButtonGroup numericTypeBtnGroup;

	//panels
	private JPanel mainPanel;
	private JPanel sortedListPanel;
	private JPanel performSortBtnPanel;
	private JPanel buttonGroupsPanel;
	private JPanel sortOrderPanel;
	private JPanel numericTypePanel;

	//containers
	private Container sortOrderContainer;
	private Container numericTypeContainer;
	private Container allPanels;

	private program3() {

		//sends window title to the parent class
		super("Binary Search Tree Sort");

		//sets titles to the labels
		originalListLabel = new JLabel("Original List");
		sortedListLabel = new JLabel("  Sorted List");

		//sets width to the text fields and sets whether they can be edited 
		originalListText = new JTextField(30);
		sortedListText = new JTextField(30);
		sortedListText.setEditable(false);

		//sets the title to the perform sort button
		performSortBtn = new JButton("Perform Sort");

		//sets the title to the ascending radio button and selects it
		ascendingRadioBtn = new JRadioButton("Ascending");
		ascendingRadioBtn.setSelected(true);

		//sets the title to the descending radio button
		descendingRadioBtn = new JRadioButton("Descending");

		//sets the title to the integer radio button and selects it
		integerRadioBtn = new JRadioButton("Integer");
		integerRadioBtn.setSelected(true);

		//sets the title to the fraction radio button
		fractionRadioBtn = new JRadioButton("Fraction");

		//adds radio buttons to group
		sortOrderBtnGroup = new ButtonGroup();
		sortOrderBtnGroup.add(ascendingRadioBtn);
		sortOrderBtnGroup.add(descendingRadioBtn);

		//adds radio buttons to group
		numericTypeBtnGroup = new ButtonGroup();
		numericTypeBtnGroup.add(integerRadioBtn);
		numericTypeBtnGroup.add(fractionRadioBtn);

		//creates the main panel and adds components to it
		mainPanel = new JPanel();
		addComponent(mainPanel, originalListLabel);
		addComponent(mainPanel, originalListText);

		//creates the sorted list panel and adds components to it
		sortedListPanel = new JPanel();
		addComponent(sortedListPanel, sortedListLabel);
		addComponent(sortedListPanel, sortedListText);

		//creates the perform sort panel and adds components to it
		performSortBtnPanel = new JPanel();
		addComponent(performSortBtnPanel, performSortBtn);

		//creates the sort order container and adds components to it
		sortOrderContainer = new Container();
		sortOrderContainer.setLayout(new BoxLayout(sortOrderContainer, BoxLayout.Y_AXIS));
		addComponent(sortOrderContainer, ascendingRadioBtn);
		addComponent(sortOrderContainer, descendingRadioBtn);

		//creates the numeric type container and adds components to it
		numericTypeContainer = new Container();
		numericTypeContainer.setLayout(new BoxLayout(numericTypeContainer, BoxLayout.Y_AXIS));
		addComponent(numericTypeContainer, integerRadioBtn);
		addComponent(numericTypeContainer, fractionRadioBtn);
		
		//creates the sort order panel and sets it up
		sortOrderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setUpPanel(sortOrderPanel, sortOrderContainer, "Sort Order");

		//creates the numeric type panel and sets it up
		numericTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		setUpPanel(numericTypePanel, numericTypeContainer, "Numeric Type");
		
		//sets up the buttons group panel
		buttonGroupsPanel = new JPanel();
		buttonGroupsPanel.add(sortOrderPanel, BorderLayout.CENTER);
		buttonGroupsPanel.add(numericTypePanel, BorderLayout.CENTER);

		//adds the panels to the container
		allPanels = new Container();
		allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS));
		allPanels.add(mainPanel);
		allPanels.add(sortedListPanel);
		allPanels.add(performSortBtnPanel);
		allPanels.add(buttonGroupsPanel);

		//sets up the frame
		setPreferredSize(new Dimension(500, 350));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(allPanels);
		pack();
		setVisible(true);

	}

	//this method sets a few of the panels on the frame
	public void setUpPanel(JPanel p, Container c, String title) {
		p.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), title));
		p.setPreferredSize(new Dimension(230, 85));
		p.add(c);
	}
	
	//this method adds a component to a container
	public void addComponent(Container c, Component c2) {
		c.add(c2);
	}
	
	//this method adds a component to a panel
	public void addComponent(JPanel p, Component c) {
		p.add(c, BorderLayout.CENTER);
	}

	//this method validates that the fraction is valid
	public static void validateFraction(String[] input) throws NumberFormatExpression {

		//goes through each element in the array
		for (int i = 0; i < input.length; i++) {
			
			//if a fraction has more than 2 parts, it will throw a new exception
			if (input.length > 2)
				throw new NumberFormatExpression();

			//tries to convert each element to an integer
			try {
				Integer.parseInt(input[i]);

			} catch (NumberFormatException f) {
				
				//if it is not an integer, it will throw a new exception
				throw new NumberFormatExpression();
			}

		}

	}

	//this method displays the results in the selected order
	public static void displayResult(Tree data) {

		//sorts the list in ascending order
		if (ascendingRadioBtn.isSelected())
			sortedListText.setText(binaryTree.inOrderTreeTraversal(data));

		//sorts the list in descending order
		else if (descendingRadioBtn.isSelected())
			sortedListText.setText(binaryTree.reverseOrderTreeTraversal(data));
	}

	//main method
	public static void main(String[] args) {
		new program3();

		//perform button action listener
		performSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				//to hold the original entered list
				String originalList = originalListText.getText();
				
				//stores to array, diving up based off a space
				String splitList[] = originalList.split(" ");

				//executes if the integerRadioBtn is selected
				if (integerRadioBtn.isSelected()) {
					
					try {
						
						//creates a new array to hold the integers
						Integer integerArray[] = new Integer[splitList.length];
						
						//creates a new instance of the binarySearchTree class of type Integer
						binaryTree = new BinarySearchTree<Integer>();

						//goes through each element in the array and tries to convert them to integers
						for (int i = 0; i < splitList.length; i++)
							integerArray[i] = Integer.parseInt(splitList[i]);

						//creates a new tree object and sends over the list of integers
						Tree<Integer> tree = binaryTree.initializeTree(integerArray);
						
						//displays the results
						displayResult(tree);

					} catch (NumberFormatException e) {
						
						//otherwise, prints out error message
						NumberFormatExpression.getError();
					}
				}
				
				//executes if fractionRadioBtn is selected
				else
					
					try {
						
						//creates a new array to hold the fractions
						Fraction fractionArray[] = new Fraction[splitList.length];
						
						//creates a new instance of the binarySearchTree class of type Fraction
						binaryTree = new BinarySearchTree<Fraction>();

						//goes through each element in the list
						for (int i = 0; i < splitList.length; i++) {
							
							//stores each fraction to array
							String[] fractionNumbers = splitList[i].split("/");

							//calls the validateFraction method
							validateFraction(fractionNumbers);

							//creates new instance of the fraction class and sends over current fraction
							Fraction input = new Fraction(splitList[i]);
							
							//stores each valid fraction to a new element in the array
							fractionArray[i] = input;
						}

						//creates a new tree object and sends over the list of valid fractions
						Tree<Fraction> tree = binaryTree.initializeTree(fractionArray);
						
						//displays the results
						displayResult(tree);

					} catch (NumberFormatExpression f) {
						
						//otherwise, prints out error message
						NumberFormatExpression.getError();
					}
			}
		});

	}
}