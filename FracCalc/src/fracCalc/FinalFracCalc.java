package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FinalFracCalc {
	public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
    	String inputEquation = "";
    	System.out.println("Enter an equation: ");
		inputEquation = userInput.nextLine();
		
		//continue prompting user for expression until the user types quit.
    	while(!inputEquation.equals("quit")){
    		String secondPart = produceAnswer(inputEquation);
        	System.out.println(secondPart);
        	System.out.println("Enter an equation: ");
    		inputEquation = userInput.nextLine();
    	}
    }
   	
	
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	
    	//splits equation into first part, operator and second part
    	String[] parsedExpression = parseInput(input);
    	String firstPart = parsedExpression[0];
    	String operator = parsedExpression[1];
    	String secPart = parsedExpression[2];
    	
    	//parse first and second parts(fractions into whole number, numerator and denominator)
    	int[] firstPartParsed = parseFraction(firstPart);
    	//int whole = firstPartParsed[0];
    	//int numerator = firstPartParsed[1];
    	//int denominator = firstPartParsed[2];
    	
    	int[] secPartParsed = parseFraction(secPart);
    	//int secPartWhole = secPartParsed[0];
    	//int secPartNumerator = secPartParsed[1];
    	//int secPartDenominator = firstPartParsed[2];
    	
    	//change first and second parsed parts into improper fractions
    	int[] firstPartImproper = improperFrac(firstPartParsed);
    	int[] secPartImproper = improperFrac(secPartParsed);
    	
    	//perform add or multiply based on operator
    	if(operator.equals("+")  || operator.equals("-")){
    		int[] sumAnswer = addFrac(firstPartImproper, secPartImproper, operator);
    		int[] simplifiedFrac = simplifyFrac(sumAnswer);
    		String mixedAnswer = toMixedNum(simplifiedFrac);
    		return mixedAnswer;
    	}
    	if(operator.equals("*")  || operator.equals("/")){
    		int[] productAnswer = multiplyFrac(firstPartImproper, secPartImproper, operator);
    		int[] simplifiedFrac = simplifyFrac(productAnswer);
    		String mixedAnswer = toMixedNum(simplifiedFrac);
    		return mixedAnswer;
    	}
    	return "wrong";
    }
    
    
    
    public static String[] parseInput(String expression){
    	String[] noSpaces = expression.split(" ");
    	return noSpaces;
    }
    
    
    
    public static int[] parseFraction(String fraction){
    	// initialize the whole, numerator, denominator and numAndDen values.
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
    	String numAndDen = "";
    	
    	//split fraction into whole number and fraction
    	//if "_" exists, split into whole number and fraction
    	if(fraction.indexOf("_") != -1){
    		String[] splitFraction = fraction.split("_");
        	whole = splitFraction[0];
        	numAndDen = splitFraction[1];
        //if "_" doesn't exist, check for "/"
        //if "/" doesn't exist, the fraction is the whole number
        //if "/" does exist the fraction is the numerator and denominator.
    	}else if(fraction.indexOf("/") == -1){
    		whole = fraction;
    	}else{
    		numAndDen = fraction;
    	}
    	
    	//split fraction into numerator and denominator
    	if(numAndDen.indexOf("/") != -1){
    		String[] splitNumandDen = numAndDen.split("/");
        	numerator = splitNumandDen[0];
        	denominator = splitNumandDen[1];
    	}
    	//change all values from strings into integers
    	int intWhole = Integer.parseInt(whole);
    	int intNumerator = Integer.parseInt(numerator);
    	int intDenominator = Integer.parseInt(denominator);

    	int[] fracArray = {intWhole, intNumerator, intDenominator};
    	return fracArray;
    }
    
    
    
    public static int[] improperFrac(int[] wholeNumDenArray){
    	//initialize whole, numerator and denominator
    	int whole = wholeNumDenArray[0];
    	int numerator = wholeNumDenArray[1];
    	int denominator = wholeNumDenArray[2];
    	
    	//new improper fraction array
    	int[] improperFraction = new int[2];
    	
    	if(whole < 0){
    		improperFraction[0] = (whole*denominator) - numerator;
    		improperFraction[1] = denominator;
    	}else{
    		improperFraction[0] = (whole*denominator) + numerator;
        	improperFraction[1] = denominator;
    	}

    	return improperFraction;                                                                                                         
    }
    
    
    
    public static int[] addFrac(int[] firstFracToAdd, int[] secFracToAdd, String operator){
    	//common denominator if denominators are not equal
    	int firstFracDenominator = firstFracToAdd[1];
    	int secFracDenominator = secFracToAdd[1];

    	if(firstFracToAdd[1] != secFracToAdd[1]){
    		firstFracToAdd[1] *= secFracDenominator;
    		secFracToAdd[1] *= firstFracDenominator;
    		
    		firstFracToAdd[0] *= secFracDenominator;
    		secFracToAdd[0] *= firstFracDenominator;
    	}
    	
    	
    	
    	// add numerators together, leave denominator the same.
		int[] sum = new int[2];
    	if(operator.equals("+")){
        	sum[0] = firstFracToAdd[0] += secFracToAdd[0];
        	sum[1] = firstFracToAdd[1];
    	}else{
        	sum[0] = firstFracToAdd[0] -= secFracToAdd[0];
        	sum[1] = firstFracToAdd[1];
    	}
    	
    	return sum;
    }
    
    
    
    public static int[] multiplyFrac(int[] firstFracToMultiply, int[] secFracToMultiply, String operator){
    	int[] product = new int[2];
    	if(operator.equals("*")){
    		product[0] = firstFracToMultiply[0]*secFracToMultiply[0];
        	product[1] = firstFracToMultiply[1]*secFracToMultiply[1];
    	}else{
    		product[0] = firstFracToMultiply[0]*secFracToMultiply[1];
        	product[1] = firstFracToMultiply[1]*secFracToMultiply[0];
    	}
    	return product;
	}
    
    public static int[] simplifyFrac(int[] improperFracArray){
    	double numerator = (double)(improperFracArray[0]);
    	double denominator = (double)(improperFracArray[1]);
    	double gcf;
    	boolean numeratorIsNegative = false;
    	boolean denominatorIsNegative = false;

    	if(numerator < 0.0){
    		numeratorIsNegative = true;
    		numerator *= -1;
    	}
    	if(denominator < 0.0){
    		denominatorIsNegative = true;
    		denominator *= -1;
    	}
    	
    	for(double i = numerator; i > 1.0; i --){
    		for(double j = denominator; j > 1.0; j --){
    			if(numerator % j == 0.0 && denominator % i == 0.0 && i == j){
    		    	gcf = i;
    		    	numerator /= gcf;
    		    	denominator /= gcf;
    			}
    		}
    	}
    	
    	if(numeratorIsNegative == true){
    		numerator *= -1;
    	}
    	if(denominatorIsNegative == true){
    		denominator *= -1;
    	}
    	
    	improperFracArray[0] = (int)(numerator);
    	improperFracArray[1] = (int)(denominator);

    	return improperFracArray;

    }
    
    public static String toMixedNum(int[] improperFracAnswer){
    	int wholeNum = improperFracAnswer[0]/improperFracAnswer[1];
    	int numerator = improperFracAnswer[0] % improperFracAnswer[1];
    	int denominator = improperFracAnswer[1];
    	////
    	if(wholeNum != 0 && numerator < 0){
    		numerator *= -1;
    	}
    	if(denominator < 0){
    		denominator *= -1;
    	}
    	
    	if(numerator == 0 || denominator == 0){
    		return Integer.toString(wholeNum);
    	}
    	if(wholeNum == 0){
    		return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    	}
    	return Integer.toString(wholeNum) + "_" + Integer.toString(numerator) + "/" +
    			Integer.toString(denominator);
    }
}
