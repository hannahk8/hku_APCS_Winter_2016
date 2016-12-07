package fracCalc;
// Hannah Ku Calculate Library 09/24/16 This is a math library that contains different
// methods that can calculate things such as the cube and square of a number.

public class Calculate {
	//returns the square of an integer input.
	public static int square(int num){
		return(num*num);
	}
	
	//returns the cube of an integer input.
	public static int cube(int num){
		return(num*num*num);
	}

	//returns the average of two double inputs.
	public static double average(double num1, double num2){
		return((num1+num2)/2);
	}

	//returns the average of three double inputs.
	public static double average(double num1, double num2, double num3){
		return((num1+num2+num3)/3);
	}

	//takes in a radian and returns that number in degrees.
	public static double toDegrees(double num){
		return((num*180)/3.14159);
	}

	//takes in a degree and returns that number in radians.
	public static double toRadians(double num){
		return((num*3.14159)/180);
	}

	//returns the discriminant of three double inputs a, b and c.
	public static double discriminant(double a, double b, double c){
		return((b*b)-(4*a*c));
	}

	//takes in three integers, (whole number, numerator, and denominator) and returns an improper fraction as a string.
	public static String toImproperFrac(int wholeNum, int numerator, int denom){
		return(((wholeNum*denom)+numerator)+ "/" + denom);
	}

	//takes in two integers, a numerator and denominator, and returns a mixed number.
	public static String toMixedNum(int numerator, int denominator){
		int remainder = numerator%denominator;
		if(numerator % denominator == 0){
			return "" + numerator/denominator + "";
		}
		return((numerator - remainder)/denominator + "_" + 
				numerator%denominator + "/" + denominator);
	}

	// returns the foil of four integers and a String (variable) input.
	public static String foil(int a, int b, int c, int d, String x){
		return((a*c) + x + "^2" + "+" + ((b*c) + (a*d)) + x  + /*+ "+" +*/ (b*d) );
	}
	
	//part two

	//returns a boolean true or false as to whether a number is divisible by another.
	public static boolean isDivisibleBy(int num, int divisor){
		if(divisor == 0){
			throw new IllegalArgumentException("divisor cannot be zero");
		}
		if(num % divisor == 0){
			return true;
		}else{
			return false;
		}
	}

	// returns the absolute value of a double input.
	public static double absValue(double num){
		if(num >= 0){
			return num;
		}else{
			return num * -1;
		}
	}

	//returns the maximum of two integer inputs.
	public static int max(int num1, int num2){
		if(num1 > num2){
			return num1;
		}else{
			return num2;
		}
	}

	//returns the maximum of three double inputs.
	public static double max(double a, double b, double c){
		if(a > b && a > c){
			return a; 
		}
		if(b > a && b > c){
			return b;
		}
		if(c > a && c > b){
			return c;
		}
		return 0.0;
	}

	//returns the minimum of two integer inputs.
	public static int min(int a, int b){
		if(a > b){
			return b;
		}else{
			return a;
		}
	}

	//returns the input number that is rounded to the nearest hundredths place.
	public static double round2(double num){
		int integer = (int) (num*100);
		double answer;
		if(100*num - integer >= .5){
			answer = (int) (num * 100 + 1);
			answer = answer / 100;
		}else{
			answer = (int) (num * 100);
			answer = answer / 100;
		}
		return answer;
	}
	
	//part 3

	//returns the value of a number(a) to the power of an exponent(b).
	public static double exponent(double a, int b){
		if(b < 0){
			throw new IllegalArgumentException("exponent power cannot be negative.");
		}
		double exponent = a;
		for(int i = 0; i < b - 1; i++){
			a *= exponent;
		}
		return a;
	}

	//returns the product of all the integers lower than the input number and above zero.
	public static int factorial(int number){
		if(number <= 0){
			throw new IllegalArgumentException("factorial input cannot be negative.");
		}
		int num = 1;
		for(int i = 1; i <= number; i++){
			num*= i;
		}
		return num;
	}

	//returns a boolean to signify whether the input is prime or not.
	public static boolean isPrime(int num){
		int factor = num - 1;
		while(isDivisibleBy(num, factor) == false){
			factor -= 1;
			if(factor == 1){
				return true;
			}
		}
		return false;
	}

	//returns the greatest common factor of two integer inputs.
	public static int gcf(int num1, int num2){
		if(num1 == 0){
			return num2;
		}
		if(num2 == 0){
			return num1;
		}
		for(int i = num1; i > 1; i -= 1){
			for(int j = num2; j > 1; j -= 1){
				if(isDivisibleBy(num1, i) && isDivisibleBy(num2, j) && i == j){
					return i;
				}
			}
		}
		return 1;
	}

	//returns the square root of two double inputs.
	public static double sqrt(double num){
		if(num < 0){
			throw new IllegalArgumentException("your input cannot be negative");
		}
		double n;
		double sqRoot = num / 2.0;
		do {
			n = sqRoot;
			sqRoot = ( n + (num / n)) / 2.0;
		} while ((n - sqRoot) != 0);
		round2(sqRoot);
		return sqRoot;
	}
	
	//part 4

	//returns a quadratic formula for three integer inputs.
	public static String quadForm(int num1, int num2, int num3){
		double number1 = (double)(num1);
		double number2 = (double)(num2);
		double number3 = (double)(num3);

		double discrim = discriminant(number1, number2, number3);
		
		String strg = "";
		
		if(discrim < 0.0){
			return strg + "no real roots";
		}
		if(discrim == 0.0){
			double answer = (-1.0 *number2)/(2.0 *number1);
			return strg += round2(answer);
		}
		if(discrim > 0.0){
			double answer1 = ((-1.0*number2) + sqrt(discrim))/(2.0*number1);
			double answer2 = ((-1.0*number2) - sqrt(discrim))/(2.0*number1);
			return strg += round2(answer1) + " and" + round2(answer2);
		}
		return strg += -1;
	}
}