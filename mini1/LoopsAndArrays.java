package mini1;

import java.util.Arrays;
import java.util.ArrayList;

public class LoopsAndArrays {

	public static void main(String[] args) {
		/*
		String s = "abcdefg";
		String t = "abcbe";
		System.out.println("should be 4, it is: " + countMatches(s, t));
		**/
		
		//int[] a = new int[] {12};
		
		//int[] a = new int[] {};
		
		
		//System.out.println(collatz(7, 3));
		
		/*
		int[] a = new int[] {1,2,3};
		
		int[] b = new int[] {4,5,6,7,8};
		
		System.out.println(interleaveArray(a,b));
		
		//System.out.println(isArithmetic(a));
		 * 
		 * 
		 */
		
		
		int[] a = new int[] {1};
		System.out.println(isAscending(a));
		

	}

	
	
	//done
	public static int countMatches(java.lang.String s, java.lang.String t) {
		int matches = 0;
		
		for(int i = 0; i < s.length() && i < t.length(); i++) {
			if(s.charAt(i) == t.charAt(i)) {
				matches++;
			}
		}
		return matches;
	}
	
	
	
	//done
	public static int numFirstChar(java.lang.String s) {
		int num = 0;
		
		
		for(int i = 0; i < s.length(); i++) {
			char firstChar = s.charAt(0);
			
			if(s.charAt(i) == firstChar) {
				num++;
			}
		}
		return num;
	}
	
	
	
	//done
	public static int countSubstringsWithOverlap(java.lang.String t, java.lang.String s) {
		int count = 0;

		
		for(int i = s.length();i >= t.length(); i--) {
			String tSub = t.substring(0, t.length());
			String sSub = s.substring(i - t.length(), i);
			if(tSub.equals(sSub)){
				count++;
			}
		}
		return count;
	}
	
	
	
	//done
	public static java.lang.String arrayToString(int[] array){
		String arr = null;
		String endgoal = "";
		
		for(int i = (array.length-1); i >= 0; i--) {
			
			arr = String.valueOf(array[i]);
			
			endgoal += arr;

		}
		return endgoal;
	}
	
	
	//done
	public static boolean isArithmetic(int[] array) {
		
		if(array.length <= 1) {
			return true;
		}
		
		int difference = array[1] - array[0];
		
		int dTest = 0;
		
		boolean end = false;
		
		
		
		
		for(int i = 1; i < array.length; i++) {
			
		
			
			dTest = array[i] - array[i-1];
			
			if(dTest == difference) {
				end = true;
			}
			else {
				return false;
			}
		
			
			
			
		}
		
		return end;
	}
	
	
	
	//done for now
	public static int[] collatz(int start, int numIterations) {
		

		int n = start;
		

		
		
		int[] arr = new int[numIterations + 1];
		
		arr[0] = n;
		
		
		for(int i = 1; i <= numIterations; i++) {
			
			
			
			if(n%2 == 0) {
				n = n/2;
				arr[i] = n;
			}
			else {
				n = (3*n)+1;
				arr[i] = n;
			}
			
			
		}
		
		
		
		
		return arr;
	}
	
	
	
	
	public static int[] interleaveArray(int[] a, int[] b) {
		
		int arrLength = a.length + b.length;
		
		int[] interleave = new int[arrLength];
		
		int j = 0;
			
		for(int i = 0; i <= arrLength +1; i++) {
			
			
			if(i < a.length) {
				interleave[j++] = a[i];
			}
			
			if(i < b.length) {
				interleave[j++] = b[i];
			}
			

			
		}
		
		
		
		
		return interleave;
	}
	
	
	
	
	public static boolean isAscending(int[] a) {
		
		boolean ascending = false;
		

		if(a.length == 1) {
			return true;
		}
		
		
		for(int i= 0, j = 1; j <= a.length -1; i++, j++) {
			
			
			
			
			
			
				if(a[i] < a[j]) {
					ascending = true;
				}
				else {
					return false;
				}
			
			
			
		}
		
		
		
		return ascending;
	}
	
	
}
