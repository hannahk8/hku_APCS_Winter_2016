package fracCalc;

import java.util.Scanner;

public class Checkpoint2 {
	public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
    	String inputEquation = "";
    	
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
    	
    	String firstPartParsed = parseFraction(firstPart);
    	String secPartParsed = parseFraction(secPart);
    	
    	return secPartParsed;
    }
    
    public static String parseFraction(String fraction){
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
    	String numAndDen = "";
    	
    	if(fraction.indexOf("_") != -1){
    		String[] splitFraction = fraction.split("_");
        	whole = splitFraction[0];
        	numAndDen = splitFraction[1];
    	}else if(fraction.indexOf("/") == -1){
    		whole = fraction;
    	}
    	
    	if(numAndDen.indexOf("/") != -1){
    		String[] splitNumandDen = numAndDen.split("/");
        	numerator = splitNumandDen[0];
        	denominator = splitNumandDen[1];
    	}

    	return ("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
    }
}
