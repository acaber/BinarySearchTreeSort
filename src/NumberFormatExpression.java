/**
 * FileName: NumberFormatExpression.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: Checked exception that is thrown when the user
 * 		attempts to enter a value that is non-numeric.
 *
 */

import javax.swing.JOptionPane;

public class NumberFormatExpression extends Exception {

	public static void getError() {
		JOptionPane.showMessageDialog(null, "Error: Non-Numeric Input");
	}
}