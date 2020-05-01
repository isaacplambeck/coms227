package mini2;

public class Mini2 {

	public static void main(String[] args) {

		System.out.println(toInt("-12345"));
		System.out.println("Expected: -12345 ");
		
		//System.out.println(isMatched("<{>}"));
		
	}

	public Mini2() {
		
	}
	
	//done
	public static java.lang.String everyNth(java.lang.String s, int n){

		if(s.length() == n) {
			return s.substring(n-1);
		}
		
		if(s.length() < n) {
			return "";
		}
		
		if(s.length()%n == 0) {
			return everyNth(s.substring(0, s.length() -1) , n) + s.charAt(s.length() - 1);
		}

		
		return everyNth(s.substring(0, s.length() - 1), n);
	}
	
	
	//done
	public static java.lang.String noNth(java.lang.String s, int n){
		
		if(s.length() == n) {
			return s.substring(0, n-1);
		}
		
		if(s.length() < n) {
			return s;
		}
		
		if(s.length()%n != 0) {
			return noNth(s.substring(0, s.length() - 1), n) + s.charAt(s.length() - 1);
		}
		
		
		
		return noNth(s.substring(0, s.length() - 1), n);
		
	}
	
	
	//done
	public static java.lang.String unique(java.lang.String s){
		
		if(s.length() == 0) {
			return s;
		}
		
		if(s.length() == 1) {
			return s;
		}
		
		if(s.charAt(0) == s.charAt(1)) {
			return unique(s.substring(1));
		}
		
		if(s.length() == 2 && s.charAt(0) == s.charAt(1)) {
			return s.substring(1);
		}
		
		
		
		return s.charAt(0) + unique(s.substring(1));
	}
	
	
	//work on
	public static int toInt(java.lang.String number) {
		
		
		
		if(number.length() == 1) {
			return Character.getNumericValue(number.charAt(0));
		}
		
		
		if(number.charAt(0) == '-') {
			//int negative = 	0 - Character.getNumericValue(number.charAt(0));
			//return negative;
			
			//number = number.substring(1, number.length() - 1) + "" + number.substring(1);
			
			number = "" + number.substring(1);
			
			return (Character.getNumericValue(number.charAt(number.length() - 1))) + (toInt(number.substring(0, number.length() - 1))) * -1 * 10 - 10;
			
			
			
			
			
			//return ( 0 - (Character.getNumericValue(number.charAt(number.length() - 1))) + (toInt(number.substring(0, number.length() - 1))) * 10);
			
		}
		
		
		
		return (Character.getNumericValue(number.charAt(number.length() - 1))) + (toInt(number.substring(0, number.length() - 1))) * 10;
		
		//return Character.getNumericValue(number.charAt(number.length()-1));
				
				//+(toInt(number.substring(0,number.length()-1)))*10;
		
	}
	
	
	//done
	public static boolean isMatched(java.lang.String s) {
		
		
		
		if(s.length() == 0) {
			return true;
		}
		
		
		
		
		
		
		
		
		if(s.length() == 1) {
			return false;
		}
		
		if(s.length() == 2) {
			
			if(s.charAt(0) == '(') {
				
				if(s.charAt(1) == ')') {
					return true;
				}
				
				return false;
			}
			
			if(s.charAt(0) == '[') {
				
				if(s.charAt(1) == ']') {
					return true;
				}
				
				return false;
				
			}
			
			if(s.charAt(0) == '{') {
				
				if(s.charAt(1) == '}') {
					return true;
				}
				
				return false;
				
			}
			
			if(s.charAt(0) == '<') {
				
				if(s.charAt(1) == '>') {
					return true;
				}
				
				return false;
				
			}
			
		}
		
		
		char bracket = s.charAt(0);
		
		
		for(int i = 0; i < s.length() - 2;i++) {
			
			if(bracket == '(') {
				
				if(s.charAt(i+1) == ')') {
					
				return isMatched(s.substring(1, i+1)+s.substring(i+2, s.length()));
			
				}
			}	
			
			
			if(bracket == '[') {
				
				if(s.charAt(i+1) == ']') {
					
				return isMatched(s.substring(1, i+1)+s.substring(i+2, s.length()));
			
				}
			}	
			
			if(bracket == '{') {
				
				if(s.charAt(i+1) == '}') {
					
				return isMatched(s.substring(1, i+1)+s.substring(i+2, s.length()));
			
				}
			}
			
			if(bracket == '<') {
				
				if(s.charAt(i+1) == '>') {
					
				return isMatched(s.substring(1, i+1)+s.substring(i+2, s.length()));
			
				}
			}	
			
			
			
			//Testing isMatched('<{>}') should return false
			
			if(s.charAt(0) == '<') {
				if(s.charAt(2) == '>') {
					if(s.charAt(1) == '{') {
						if(s.charAt(3) == '}') {
							return false;
						}
					}
				}
			}
			
			
			
		}
		
		return false;
		
	}
	
	
	//done
	public static double pow(double base, int exponent) {
		
		if(exponent == 0) {
			return 1;
		}
		
		if(exponent == 1) {
			return base;
		}
		
		return pow(base, exponent-1) * base;
	}
	
	
	
	
	
}
