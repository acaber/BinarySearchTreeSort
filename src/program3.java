/**
 * FileName: program3.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: This class builds the GUI and reads the user's input. 
 * 		It contains the main method.
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class program3 extends JFrame {

	private static BinarySearchTree binaryTree;
	private static String sortedList = "";

	JLabel originalListLabel;
	JLabel sortedListLabel;

	static JTextField originalListText;
	static JTextField sortedListText;

	static JButton performSortBtn;

	static JRadioButton ascendingRadioBtn;
	static JRadioButton descendingRadioBtn;
	static JRadioButton integerRadioBtn;
	static JRadioButton fractionRadioBtn;

	ButtonGroup sortOrderBtnGroup;
	ButtonGroup numericTypeBtnGroup;

	JPanel mainPanel;
	JPanel sortedListPanel;
	JPanel performSortBtnPanel;
	JPanel buttonGroupsPanel;
	JPanel sortOrderPanel;
	JPanel numericTypePanel;

	Container sortOrderContainer;
	Container numericTypeContainer;
	Container allPanels;

	private program3() {

		super("Binary Search Tree Sort");

		// labels
		originalListLabel = new JLabel("Original List");
		sortedListLabel = new JLabel("  Sorted List");

		// text fields
		originalListText = new JTextField(30);
		sortedListText = new JTextField(30);
		sortedListText.setEditable(false);

		// perform sort button
		performSortBtn = new JButton("Perform Sort");

		// ascending radio button
		ascendingRadioBtn = new JRadioButton("Ascending");
		ascendingRadioBtn.setSelected(true);

		// descending radio button
		descendingRadioBtn = new JRadioButton("Descending");

		// integer radio button
		integerRadioBtn = new JRadioButton("Integer");
		integerRadioBtn.setSelected(true);

		// fraction radio button
		fractionRadioBtn = new JRadioButton("Fraction");

		// sort order button group
		sortOrderBtnGroup = new ButtonGroup();
		sortOrderBtnGroup.add(ascendingRadioBtn);
		sortOrderBtnGroup.add(descendingRadioBtn);

		// numeric type button group
		numericTypeBtnGroup = new ButtonGroup();
		numericTypeBtnGroup.add(integerRadioBtn);
		numericTypeBtnGroup.add(fractionRadioBtn);

		mainPanel = new JPanel();
		addComponent(mainPanel, originalListLabel);
		addComponent(mainPanel, originalListText);

		sortedListPanel = new JPanel();
		addComponent(sortedListPanel, sortedListLabel);
		addComponent(sortedListPanel, sortedListText);

		performSortBtnPanel = new JPanel();
		addComponent(performSortBtnPanel, performSortBtn);

		// sort order container
		sortOrderContainer = new Container();
		sortOrderContainer.setLayout(new BoxLayout(sortOrderContainer, BoxLayout.Y_AXIS));
		sortOrderContainer.add(ascendingRadioBtn);
		sortOrderContainer.add(descendingRadioBtn);

		// numeric type container
		numericTypeContainer = new Container();
		numericTypeContainer.setLayout(new BoxLayout(numericTypeContainer, BoxLayout.Y_AXIS));
		numericTypeContainer.add(integerRadioBtn);
		numericTypeContainer.add(fractionRadioBtn);

		sortOrderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sortOrderPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Sort Order"));
		sortOrderPanel.setPreferredSize(new Dimension(230, 85));
		sortOrderPanel.add(sortOrderContainer);

		numericTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		numericTypePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Numeric Type"));
		numericTypePanel.setPreferredSize(new Dimension(230, 85));
		numericTypePanel.add(numericTypeContainer);

		buttonGroupsPanel = new JPanel();
		buttonGroupsPanel.add(sortOrderPanel, BorderLayout.CENTER);
		buttonGroupsPanel.add(numericTypePanel, BorderLayout.CENTER);

		allPanels = new Container();
		allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS));
		allPanels.add(mainPanel);
		allPanels.add(sortedListPanel);
		allPanels.add(performSortBtnPanel);
		allPanels.add(buttonGroupsPanel);

		setPreferredSize(new Dimension(500, 350));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(allPanels);
		pack();
		setVisible(true);

	}

	public void addComponent(JPanel p, Component c) {
		p.add(c, BorderLayout.CENTER);
	}

	public static void validateFraction(String[] input) throws NumberFormatExpression {

		for (int i = 0; i < input.length; i++) {
			if (input.length > 2)
				throw new NumberFormatExpression();

			try {
				Integer.parseInt(input[i]);

			} catch (NumberFormatException f) {

				throw new NumberFormatExpression();
			}

		}

	}

	public static void main(String[] args) {
		new program3();

		performSortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				String originalList = originalListText.getText();
				String splitList[] = originalList.split(" ");

				if (integerRadioBtn.isSelected()) {
					try {

						Integer integers[] = new Integer[splitList.length];
						binaryTree = new BinarySearchTree<Integer>();

						for (int i = 0; i < splitList.length; i++)
							integers[i] = Integer.parseInt(splitList[i]);

						Tree<Integer> root = binaryTree.initializeTree(integers);

						if (ascendingRadioBtn.isSelected())
							sortedListText.setText(binaryTree.inOrderTreeTraversal(root));

						else if (descendingRadioBtn.isSelected())
							sortedListText.setText(binaryTree.reverseOrderTreeTraversal(root));

					} catch (NumberFormatException e) {

						NumberFormatExpression.getError();
					}
				}

				else
					try {

						Fraction array[] = new Fraction[splitList.length];
						binaryTree = new BinarySearchTree<Fraction>();

						for (int i = 0; i < splitList.length; i++) {
							String[] fractionNumbers = splitList[i].split("/");

							validateFraction(fractionNumbers);

							Fraction input = new Fraction(splitList[i]);
							array[i] = input;
						}

						Tree<Fraction> root = binaryTree.initializeTree(array);

						if (ascendingRadioBtn.isSelected())
							sortedListText.setText(binaryTree.inOrderTreeTraversal(root));

						else if (descendingRadioBtn.isSelected())
							sortedListText.setText(binaryTree.reverseOrderTreeTraversal(root));

					} catch (NumberFormatExpression e1) {
						NumberFormatExpression.getError();
					}
			}
		});

	}
}