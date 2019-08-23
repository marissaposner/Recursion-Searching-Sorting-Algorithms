import java.util.*;
public class Arrays1 {
/**
Design and implement and algorithm that compare two strings and check if they are reversed. 
For instance, if the two strings are google and elgoog, then the method returns 1. 
If the two strings are “data”, “ata” then the method returns 0. The algorithm should ignore white spaces, lower/upper cases. 
*/
	public static int compareStrings(String original, String rev){
		//String r=new StringBuilder(original.replaceAll("\\s+","").toLowerCase()).reverse().toString();
		
		if(reverseStr(original.replaceAll("\\s+","").toLowerCase()).equals(rev.replaceAll("\\s+","").toLowerCase())) {
			return 1;
		}
		else {
			return 0;
		}
	} //runtime of algorithm: O(N)
	public static String reverseStr(String original) { //create reverse method
		if(original==null ||original.length()<=1) { //if string empty ot 
			return original;
		}
		return reverseStr(original.substring(1))+original.charAt(0); //takes the first character of string and puts it at the end
		//and do recursion on substring from beginning 
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("What is the original string you want to enter?");
		String o=in.nextLine();
		System.out.println("What is the reversed string you want to enter?");
		String rev=in.nextLine();
		int result=compareStrings(o,rev);
		System.out.println(result);
		
	}
}
