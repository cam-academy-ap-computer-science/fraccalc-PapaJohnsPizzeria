/* CLASS:
 * New scanner
 * get input
 * run black box
 * close scanner
 * :D
 * 
 * METHOD:
 * split the operands
 * store them separately
 * 
 * what's the operation?
 * runs if's for the specific operation
 * make methods for each operation
 * 
 * SEPERATING THE NUMBERS:
 * if there isn't an underscore, then the "numerator = 0" + "denominator = 1"
 * if there is an underscore, then the number between the "_" and "/" is the numerator
 * the number between the "/" and end of " " is the denominator

 * 
 * MULTIPLICATION:
 * look for " * "
 * 
 * DIVISION:
 * look for " / "
 * 
 * SUBTRACTION:
 * look for " - "
 * 
 * ADDITION:
 * look for " + "
 * 
 * 
 */
package fracCalc;
import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
    	System.out.println("This is a calculator that does fractions. \n"
    					+ "Type \"quit\" to turn off the calculator. \n"
    					+ "Type your problem:");
    	Scanner cs = new Scanner(System.in);
    	String input = cs.nextLine();
    	System.out.println(produceAnswer(input));
    	
    	cs.close();
    }
    
    public static String produceAnswer(String input) {
    	String ans = "jarjarbinks";
    	    	
    	int a = input.indexOf(" ");
    	int b = input.length();
		String oOne = input.substring(0, a);
    	String oTwo = input.substring((a+3), b);
        
    	String whole = "a";
		String numerater = "a";
		String denominator = "a";
		
    	if(oTwo.indexOf("_") == -1 && oTwo.indexOf("/") == -1) {
    		whole = oTwo;
    		numerater = "0";
    		denominator = "1";
    	} else if(oTwo.indexOf("_") >= 0) {
    		
    	}
    	
    	ans = "whole:" + whole + " numerator:" + numerater + " denominator:" + denominator;
    	
    	
    	return ans;

    	
/*   	
    	if(input.indexOf(" * ") != -1) {
    		mul(input);
    	}else if(input.indexOf(" / ") != -1) {
    		div(input);
    	}else if(input.indexOf(" + ") != -1) {
    		add(input);
    	}else if(input.indexOf(" - ") != -1) {
    		sub(input);
    	}
*/
    }
    
    public static String mul(String input) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }
    public static String div(String input) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }
    public static String add(String input) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }   
    public static String sub(String input) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
