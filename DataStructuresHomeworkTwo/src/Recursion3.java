import java.util.*;

/**
 * @author marissaposner
 *Implement a recursive algorithm that checks if word is A palindrome.Please ignore all punctuation
 */
public class Recursion3 {
	public static boolean palindrome(String original) { //create reverse method
		original=original.replaceAll("\\s+","").toLowerCase(); 
		if(original.length()<=1) { //if len <=1
			return true;
		}
		else if(original.charAt(0) == original.charAt(original.length()-1)) { //if first and last are equal then continue to check
			return palindrome(original.substring(1,original.length()-1)); //run palindrome again from substring from position 1
		}
		return false; //else if they are not equal then false
	
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("What is the word you want to check if it is a palindrome? ");
		String p=in.nextLine();
		if(palindrome(p)) {
			System.out.println("True ");
			
		}
		else {
			System.out.println("Not a palindrome");
		}
	}
}
