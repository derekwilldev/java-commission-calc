/*
 * Programmer: Derek Will
 * Date: May 1, 2017
 * Purpose: Determine commission
 */



import java.text.DecimalFormat;
import javax.swing.*;



public class TravelCommission {
	
	public static void main(String[] args) {
		//Calling all methods
		double dollars = getSales(0);
		int empCode = getCode(0);
		double answer = getCommission(dollars, empCode);
		output(dollars, answer);
		finish();

	}
	
	
	
	private static double getSales(double sales) {
		//Getting sales along with error checking and exception handeling
		try {
			
			sales = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter in sales:", "Sales", JOptionPane.DEFAULT_OPTION));
			if(sales <= 0) {
				JOptionPane.showMessageDialog(null, "Please enter a value greater than 0.", "Error", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			else if(sales == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}
		catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Enter in a double value.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
		return sales;
	}
	
	
	
	
	private static int getCode(int code) {
		
		try {
			
			code = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the code for the type of sale\n1 = Telephone\n2 = In-store\n3 = Outdoor:", "Sales", JOptionPane.DEFAULT_OPTION));
			
			if(code <= 0 || code > 3) {
				JOptionPane.showMessageDialog(null, "Please enter a 1, 2, or 3.", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(code == 2) {
				code = 2;
			}
			else if(code == JOptionPane.CANCEL_OPTION) {				
				System.exit(0);
			}
		}
		catch (IllegalArgumentException e) {			
			JOptionPane.showMessageDialog(null, "Please enter in a 1, 2, or 3.", "Error!", JOptionPane.ERROR_MESSAGE);			
		}
		
		
		return code;
	}
	
	
	
	private static double getCommission(double dollars, int empCode) {
		double answer = 0;
		
		//Determine the amount of commission made based off of the type of sale
		if(empCode == 1) {
			answer = dollars * 0.10;			
		}
		else if(empCode == 2) {			
			answer = dollars * 0.14;			
		}
		else if(empCode == 3) {
			answer = dollars * 0.18;			
		}
		
		
		return answer;
	}
	
	
	
	
		//Outputing the commission
	public static int output(double dollars, double answer)	{
		DecimalFormat decimal = new DecimalFormat(".##");
		
		JOptionPane.showMessageDialog(null, "Your total commission on sales of $" + dollars + " is $" + decimal.format(answer));
		return 0;
	}
	
	
	
	
		//Closes the program
	public static void finish() {
		System.exit(0);
		
		return;
	}

}