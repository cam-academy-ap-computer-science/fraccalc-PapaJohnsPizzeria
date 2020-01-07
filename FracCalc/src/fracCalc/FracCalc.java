/* MAIN:
 * New scanner
 * get input
 * run black box
 * close scanner
 * accepting multiple inputs
 * do while (string "quit" != (underscored)"QuIt")
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
 * COMMON DENOMINATOR:
 * if they have the same denominator, then add the numerator
 * if the numerator is the same as the denominator, then "+1" to the whole number
 * if the numerator is bigger than the denominator, then do numerator % denominator
 * 
 * ESSENTIAL TO ANS!!! reduces fraction:
 * divide numerator by denominator = a
 * multiply numerator by the original faction = b
 * if a * b != a then do it again
 * 
 * MIXED TO IMPROPER FRACTION:
 * Simple: whole * denominator + numerator (assumes everything is whole)
 * Whole is negative: whole times denominator - numerator (assumes whole is negative)
 * 
 */
package fracCalc;
import java.util.*;

public class FracCalc {
	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		System.out.println("This calculator can operate on fractions and mixed numbers. \n"
				+ "Type \"quit\" to turn off this calculator. \n"
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

		//splits first operand into 3 integers
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

		//splits second operand into 3 integers
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

		//conversions for the "test input" methods
		int aA = wholeA;
		int bA = numeratorA;
		int cA = denominatorA;
		int aB = wholeB;
		int bB = numeratorB;
		int cB = denominatorB;

		//tests input for an operation
		if(input.indexOf(" + ") != -1) { 
			ans = add(aA, bA, cA, aB, bB, cB);
		} else if(input.indexOf(" - ") != -1) {
			ans = sub(aA, bA, cA, aB, bB, cB);
		} else if(input.indexOf(" * ") != -1) {
			ans = mul(aA, bA, cA, aB, bB, cB);
		} else if(input.indexOf(" / ") != -1) {
			ans = div(aA, bA, cA, aB, bB, cB);
		}
		return ans;
	}

	public static String mul(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
		String ans = "jarjarbinks";
		int wholeFINAL;
		int numeratorFINAL;
		int denominatorFINAL;

		//converts to improper fraction
		if(wholeA < 0) {
			numeratorA = (wholeA * denominatorA) - numeratorA;
		} else if(wholeA > 0) {
			numeratorA = (wholeA * denominatorA) + numeratorA;
		}
		if(wholeB < 0) {
			numeratorB = (wholeB * denominatorB) - numeratorB;
		} else if(wholeB > 0) {
			numeratorB = (wholeB * denominatorB) + numeratorB;
		}

		//runs the operation
		numeratorFINAL = numeratorA * numeratorB;
		denominatorFINAL = denominatorA * denominatorB;
		wholeFINAL = numeratorFINAL / denominatorFINAL;
		numeratorFINAL = numeratorFINAL % denominatorFINAL;

		//simplify fraction
		int smaller = numeratorFINAL < denominatorFINAL ? numeratorFINAL : denominatorFINAL;
		int gcf = -1;
		for (int i = smaller; i > 0; --i) {
			if ((numeratorFINAL % i==0) && (denominatorFINAL%i==0)) {
				gcf = i;
				break;
			}
		}

		//stitches the answer together
		if(wholeFINAL == 0 && numeratorFINAL != 0) { //fraction
			ans = numeratorFINAL/gcf + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL != 0) { //mixed number
			ans = wholeFINAL + "_" + (Math.abs(numeratorFINAL/gcf)) + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL == 0) { //whole number
			ans = Integer.toString(wholeFINAL);
		} else if(wholeFINAL == 0 && numeratorFINAL == 0) {//zero
			ans = Integer.toString(wholeFINAL);
		}
		return ans;
	}

	public static String div(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
		String ans = "jarjarbinks";
		int wholeFINAL;
		int numeratorFINAL;
		int denominatorFINAL;

		//turns mixed into improper
		if(wholeA < 0) {
			numeratorA = (wholeA * denominatorA) - numeratorA;
		} else if(wholeA > 0) {
			numeratorA = (wholeA * denominatorA) + numeratorA;
		}
		if(wholeB < 0) {
			numeratorB = (wholeB * denominatorB) - numeratorB;
		} else if(wholeB > 0) {
			numeratorB = (wholeB * denominatorB) + numeratorB;
		}


		//flips the second operand
		int a = numeratorB;
		numeratorB = denominatorB;
		denominatorB = a;

		//runs multiplication
		numeratorFINAL = numeratorA * numeratorB;
		denominatorFINAL = denominatorA * denominatorB;
		wholeFINAL = numeratorFINAL / denominatorFINAL;
		numeratorFINAL = numeratorFINAL % denominatorFINAL;

		//simplify fraction
		int smaller = numeratorFINAL < denominatorFINAL ? numeratorFINAL : denominatorFINAL;
		int gcf = -1;
		for (int i = smaller; i > 0; --i) {
			if ((numeratorFINAL % i==0) && (denominatorFINAL%i==0)) {
				gcf = i;
				break;
			}
		}

		//stitches the answer together
		if(wholeFINAL == 0 && numeratorFINAL != 0) { //fraction
			ans = numeratorFINAL/gcf + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL != 0) { //mixed number
			ans = wholeFINAL + "_" + (Math.abs(numeratorFINAL/gcf)) + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL == 0) { //whole number
			ans = Integer.toString(wholeFINAL);
		} else if(wholeFINAL == 0 && numeratorFINAL == 0) {//zero
			ans = Integer.toString(wholeFINAL);
		}
		return ans;
	}

	public static String add(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
		String ans = "jarjarbinks";
		int wholeFINAL;
		int numeratorFINAL;
		int denominatorFINAL;

		//turns it into improper fractions
		if(wholeA != 0) {
			numeratorA = (wholeA * denominatorA) + numeratorA;
		}
		if(wholeB != 0) {
			numeratorB = (wholeB * denominatorB) + numeratorB;
		}

		//common denominator
		if(denominatorB != denominatorA) {
			numeratorB *= denominatorA;
			numeratorA *= denominatorB;
			denominatorA *= denominatorB;
			denominatorB = denominatorA;
		}

		//runs the operation
		numeratorFINAL = numeratorA + numeratorB;
		denominatorFINAL = denominatorA;
		wholeFINAL = numeratorFINAL / denominatorFINAL;
		numeratorFINAL = numeratorFINAL % denominatorFINAL;

		//simplify fraction
		int smaller = numeratorFINAL < denominatorFINAL ? numeratorFINAL : denominatorFINAL;
		int gcf = -1;
		for (int i = smaller; i > 0; --i) {
			if ((numeratorFINAL % i==0) && (denominatorFINAL%i==0)) {
				gcf = i;
				break;
			}
		}

		//stitches the answer together
		if(wholeFINAL == 0 && numeratorFINAL != 0) { //fraction
			ans = numeratorFINAL/gcf + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL != 0) { //mixed number
			ans = wholeFINAL + "_" + (Math.abs(numeratorFINAL/gcf)) + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL == 0) { //whole number
			ans = Integer.toString(wholeFINAL);
		} else if(wholeFINAL == 0 && numeratorFINAL == 0) {//zero
			ans = Integer.toString(wholeFINAL);
		}
		return ans;
	}   

	public static String sub(int wholeA, int numeratorA, int denominatorA, int wholeB, int numeratorB, int denominatorB) {
		String ans = "jarjarbinks";
		int wholeFINAL;
		int numeratorFINAL;
		int denominatorFINAL;

		//turns it into improper fractions
		if(wholeA < 0) {
			numeratorA = (wholeA * denominatorA) - numeratorA;
		} else if(wholeA > 0) {
			numeratorA = (wholeA * denominatorA) + numeratorA;
		}
		if(wholeB < 0) {
			numeratorB = (wholeB * denominatorB) - numeratorB;
		} else if(wholeB > 0) {
			numeratorB = (wholeB * denominatorB) + numeratorB;
		}

		//common denominator
		if(denominatorB != denominatorA) {
			numeratorB *= denominatorA;
			numeratorA *= denominatorB;
			denominatorA *= denominatorB;
			denominatorB = denominatorA;
		}

		//runs the operation
		numeratorFINAL = numeratorA - numeratorB;
		denominatorFINAL = denominatorA;
		wholeFINAL = numeratorFINAL / denominatorFINAL;
		numeratorFINAL = numeratorFINAL % denominatorFINAL;

		//simplify fraction
		int smaller = numeratorFINAL < denominatorFINAL ? numeratorFINAL : denominatorFINAL;
		int gcf = -1;
		for (int i = smaller; i > 0; --i) {
			if ((numeratorFINAL % i==0) && (denominatorFINAL%i==0)) {
				gcf = i;
				break;
			}
		}

		//stitches the answer together
		if(wholeFINAL == 0 && numeratorFINAL != 0) { //fraction
			ans = numeratorFINAL/gcf + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL != 0) { //mixed number
			ans = wholeFINAL + "_" + (Math.abs(numeratorFINAL/gcf)) + "/" + (Math.abs(denominatorFINAL/gcf));
		} else if(wholeFINAL != 0 && numeratorFINAL == 0) { //whole number
			ans = Integer.toString(wholeFINAL);
		} else if(wholeFINAL == 0 && numeratorFINAL == 0) {//zero
			ans = Integer.toString(wholeFINAL);
		}
		return ans;
	}
}