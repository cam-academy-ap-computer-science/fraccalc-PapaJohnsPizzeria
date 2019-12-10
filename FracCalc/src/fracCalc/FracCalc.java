/* MAIN:
 * New scanner
 * get input
 * run black box
 * close scanner
 * accepting multiple inputs
 * 		do while (string "quit" != (underscored)"QuIt")
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
 * COMMON DENOMINATOR;
 * if they have the same denominator, then add the numerator
 * if the numerator is the same as the denominator, then "+1" to the whole number
 * if the numerator is bigger than the denominator, then do numerator % denominator
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
 */
package fracCalc;
import java.util.*;

public class FracCalc {
    public static void main(String[] args) {
    	Scanner cs = new Scanner(System.in);
    	System.out.println("This is a calculator that does fractions. \n"
    					+ "Type \"quit\" to turn off the calculator. \n"
    					+ "Type your problem:");
    	String input = "jarjarbinks";
    	String quit = "quit";
    	do {input = cs.nextLine();
    		if(!(input.toLowerCase().equals(quit))) {
        		System.out.println(produceAnswer(input));
    		}
    	} while (!(input.toLowerCase().equals(quit)));
    	cs.close();
    }
    
    public static String produceAnswer(String input) {
    	//splits input into 2 operands
    	String ans = "jarjarbinks";
    	int a = input.indexOf(" ");
    	int b = input.length();
		String oOne = input.substring(0, a);
    	String oTwo = input.substring((a+3), b);

    	//splits first operand into 3
    	int wholeA = 1;
		int numeratorA = 1;
		int denominatorA = 1;
		
    	if((oOne.indexOf("_") == -1) && (oOne.indexOf("/") == -1)) {
    		wholeA = Integer.parseInt(oOne);
    		numeratorA = 0;
    		denominatorA = 1;
    	} else if((oOne.indexOf("_") != -1) && (oOne.indexOf("/") != -1)) {
    		wholeA = Integer.parseInt(oOne.substring(0, oOne.indexOf("_")));
    		numeratorA = Integer.parseInt(oOne.substring((oOne.indexOf("_") + 1), oOne.indexOf("/")));
    		denominatorA = Integer.parseInt(oOne.substring((oOne.indexOf("/") + 1), oOne.length()));
    	} else if((oOne.indexOf("/") != -1) && (oOne.indexOf("_") == -1)) { 
    		wholeA = 0;
    		numeratorA = Integer.parseInt(oOne.substring(0, (oOne.indexOf("/"))));
    		denominatorA = Integer.parseInt(oOne.substring((oOne.indexOf("/")+1), oOne.length()));
    	}    	
    	
    	//splits second operand into 3
    	int wholeB = 1;
		int numeratorB = 1;
		int denominatorB = 1;
		
    	if((oTwo.indexOf("_") == -1) && (oTwo.indexOf("/") == -1)) {
    		wholeB = Integer.parseInt(oTwo);
    		numeratorB = 0;
    		denominatorB = 1;
    	} else if((oTwo.indexOf("_") != -1) && (oTwo.indexOf("/") != -1)) {
    		wholeB = Integer.parseInt(oTwo.substring(0, oTwo.indexOf("_")));
    		numeratorB = Integer.parseInt(oTwo.substring((oTwo.indexOf("_") + 1), oTwo.indexOf("/")));
    		denominatorB = Integer.parseInt(oTwo.substring((oTwo.indexOf("/") + 1), oTwo.length()));
    	} else if((oTwo.indexOf("/") != -1) && (oTwo.indexOf("_") == -1)) { 
    		wholeB = 0;
    		numeratorB = Integer.parseInt(oTwo.substring(0, (oTwo.indexOf("/"))));
    		denominatorB = Integer.parseInt(oTwo.substring((oTwo.indexOf("/")+1), oTwo.length()));
    	}
    	
//    	ans = "whole:" + wholeB + " numerator:" + numeratorB + " denominator:" + denominatorB;
    	
    	//conversions for the "test input" methods
    	int aA = wholeA;
    	int bA = numeratorA;
    	int cA = denominatorA;
    	int aB = wholeB;
    	int bB = numeratorB;
    	int cB = denominatorB;
    	
    	//tests input for an operation
    	if(input.indexOf(" + ") != -1) { 
    		add(aA, bA, cA, aB, bB, cB);
    	} else if(input.indexOf(" - ") != -1) {
    		sub(aA, bA, cA, aB, bB, cB);
    	} else if(input.indexOf(" * ") != -1) {
    		mul(aA, bA, cA, aB, bB, cB);
    	} else if(input.indexOf(" / ") != -1) {
    		div(aA, bA, cA, aB, bB, cB);
    	}
    	return ans;
    }
    
    public static String mul(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
    	String ans = "jarjarbinks";
    	int solution = 1;
    	if(((numeratorB == 0) && (denominatorB == 1))&&((numeratorA == 0) && (denominatorA == 1))) {
    		solution = wholeA * wholeB;
        	ans = Integer.toString(solution);
    	}
    	
    	return ans;
    }
    public static String div(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }
    public static String add(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
    	String ans = "jarjarbinks";
    	int numeratorFINAL = 1;
    	int denominatorFINAL = 1;
    	int wholeFINAL = wholeA + wholeB;
    	
    	//whole number addition
    	if((numeratorA == 0)&&(numeratorB == 0)) {
    		wholeFINAL = wholeA + wholeB;
    	}
    	//common denominator
    	if(denominatorA != denominatorB) {
    		denominatorA = denominatorA * denominatorB;
    		denominatorB = denominatorA * denominatorB;
    		numeratorA = numeratorA * denominatorB;
    		numeratorB = numeratorB * denominatorA;
    	} else if(denominatorA == denominatorB) { 
    		numeratorFINAL = numeratorA + numeratorB;
    		denominatorFINAL =  denominatorA;
    	}
    	ans = wholeFINAL + "_" + numeratorFINAL + "/" + denominatorFINAL;
    	return ans;
    }   
    public static String sub(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
    	String ans = "jarjarbinks";
    	
    	return ans;
    }
    
}

