import java.util.*;
public class Arrays2 {
	/**
	 * @author marissaposner
	 Exercise Two (10pts) Design and implement an algorithm that takes a set of strings.
	 Then, for every three consecutive strings (assuming the list of strings is larger than 3 and
	 the number of strings in your sentence is a multiple of 3) leave only the shortest of the
	 three. In case two string among the three are of the same length then you leave the first one. 
	 */
	public static String shortestOfThree(String str) {
		String toReturn="";
		String[] strings=str.split(" "); 
		for(int i=0; i<strings.length; i+=3) { //assuming the list of strings is larger than 3 and
			//the number of strings in your sentence is a multiple of 3
			
			toReturn+=findSmallest(strings[i], strings[i+1], strings[i+2]);
			
		}
		return toReturn;
	}//O(n) runtime well actually O(n/3) which simplifies to O(n)
	public static String findSmallest(String one, String two, String three) { //find smallest string in array of strings
		String smallest=one;
		for(int s=0; s<3; s++) {
			if(two.length()<smallest.length()&& two.length()<three.length()) {
				smallest=two; 
			}
			else if(three.length()<smallest.length() && three.length()<two.length()) {
				smallest=three;
			}
		}
		return smallest +" ";
	} 
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("What is the string you want to get the subset of strings of?");
		String toCheck=in.nextLine();
		String reduced=shortestOfThree(toCheck);
		System.out.println("Substring: "+reduced);
	}
}
//Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex