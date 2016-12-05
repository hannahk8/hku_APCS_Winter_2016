// this code receives input from the user and returns the answer to expressions
package fracCalc;

import java.util.Scanner;

public class Checkpoint3 {
	public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
    	String inputEquation = "";
    	
    	//continue prompting user for expression until the user types quit.
    	while(!inputEquation.equals("quit")){
    		System.out.println("Enter an equation: ");
    		inputEquation = userInput.nextLine();
    		String secondPart = produceAnswer(inputEquation);
        	System.out.println(secondPart);
    	}
    }
    
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	//splits string and declares variables
    	String[] noSpaces = input.split(" ");
    	String firstPart = "";
    	String operator = "";
    	String secPart = "";
    	
    	//splits equation into first part, operator and second part
    	for(int i = 0; i < noSpaces.length; i++){
    		if(noSpaces[i].equals("+") || noSpaces[i].equals("-") || noSpaces[i].equals("*")
    				|| noSpaces[i].equals("/")){
    			firstPart = noSpaces[0];
    			operator = noSpaces[i];
    			secPart = noSpaces[i + 1];
    		}
    	}
    	
    	//parse first and second parts(fractions into whole number, numerator and denominator)
    	int[] firstPartParsed = parseFraction(firstPart);
    	int[] secPartParsed = parseFraction(secPart);
    	
    	return secPartParsed;
    }
    
    public static int[] parseFraction(String fraction){
    	// initialize the whole, numerator, denominator and numAndDen values.
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
    	String numAndDen = "";
    	
    	//split fraction into whole number and fraction
    	if(fraction.indexOf("_") != -1){
    		String[] splitFraction = fraction.split("_");
        	whole = splitFraction[0];
        	numAndDen = splitFraction[1];
    	}else if(fraction.indexOf("/") == -1){
    		whole = fraction;
    	}
    	
    	//split fraction into numerator and denominator
    	if(numAndDen.indexOf("/") != -1){
    		String[] splitNumandDen = numAndDen.split("/");
        	numerator = splitNumandDen[0];
        	denominator = splitNumandDen[1];
    	}
    	//change all values from strings into integers
    	int integerWhole = Integer.parseInt(whole);
    	int integerNumerator = Integer.parseInt(numerator);
    	int integerDenominator = Integer.parseInt(denominator);

    	int[] fracArray = {integerWhole, integerNumerator, integerDenominator};
    	//return ("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
    	return fracArray;
    }
    
    public static int[] improperFrac(int[] wholeNumDenArray){
    	//initialize whole, numerator and denominator
    	int whole = wholeNumDenArray[0];
    	int numerator = wholeNumDenArray[1];
    	int denominator = wholeNumDenArray[2];
    	
    	//new improper fraction array
    	int[] improperFraction = new int[2];
    	improperFraction[0] = (whole*denominator) + numerator;
    	improperFraction[1] = denominator;
    	
    	return improperFraction;
    }
    
    public static int[] addFrac(int[] firstFracToAdd, int[] secFracToAdd){
    	// add numerators together, leave denominator the same.
    	int[] sum = new int[2];
    	sum[0] = firstFracToAdd[0] += secFracToAdd[0];
    	sum[1] = firstFracToAdd[1];
    	
    	return sum;
    }
    
    public static int[] multiplyFrac(int[] firstFracToMultiply, int[] secFracToMultiply){
    	int[] product = new int[2];
    	product[0] = 
    	product[1] = 
	}
}