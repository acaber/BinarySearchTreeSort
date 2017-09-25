/**
 * FileName: Fraction.java
 * Author: Rebecca Johnson
 * Date: 9/24/2017
 * Description: This class defines the data type Fraction to compare
 * 		fractions and determine which one is larger/smaller.
 *
 */
public class Fraction implements Comparable {

	private String fraction;

	public Fraction(String fraction) {
		this.fraction = fraction;
	}

	
	@Override
	public int compareTo(Object input) {

		String numbers[] = fraction.split("/");
		
		int numerator1 = Integer.valueOf(numbers[0]);
		int denominator1 = Integer.valueOf(numbers[1]);

		String s = input.toString();
		
		numbers = s.split("/");

		int numerator2 = Integer.valueOf(numbers[0]);
		int denominator2 = Integer.valueOf(numbers[1]);


		if ((numerator1 * denominator2) > (numerator2 * denominator1)) 
			return 1;
		else if ((numerator1 * denominator2) < (numerator2 * denominator1))
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return fraction;
	}

} 