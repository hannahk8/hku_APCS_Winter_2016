package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class Checkpoint1
{
    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Enter an equation: ");
    	String inputEquation = userInput.nextLine();
    	
    	String secondPart = produceAnswer(inputEquation);
    	System.out.println(secondPart);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] noSpaces = input.split(" ");
    	String firstPart = "";
    	String operator = "";
    	String secPart = "";
    	
    	for(int i = 0; i < noSpaces.length; i++){
    		if(noSpaces[i].equals("+") || noSpaces[i].equals("-") || noSpaces[i].equals("*")
    				|| noSpaces[i].equals("/")){
    			firstPart = noSpaces[0];
    			operator = noSpaces[i];
    			secPart = noSpaces[i + 1];
    			return secPart;
    		}
    	}
    	return "error";
    }
}
    // TODO: Fill in the space below with any helper methods that you think you will need

