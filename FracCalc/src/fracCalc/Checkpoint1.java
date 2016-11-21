package fracCalc;

public class Checkpoint1
{
	import java.util.*;
    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	String inputEquation = userInput.next();
    	String secondPart = produceAnswer(inputEquation);
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
        for(int i = 0; i < input.length(); i++){
        	if(input.substring(i, i+1) == "+" || input.substring(i, i+1) == "-"
        			|| input.substring(i, i+1) == "*"){
        		String secPart = "";
        		for(int j = i; j < input.length(); j++){
        			secPart += input.substring(j, j+1);
        		}
        		return secPart;
        	}
        }
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

