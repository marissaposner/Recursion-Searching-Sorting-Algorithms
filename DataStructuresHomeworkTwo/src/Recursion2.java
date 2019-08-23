import java.util.*;
/**
 * @author marissaposner
 *Design and implement a recursive algorithm that returns the number of zeroes in the binary representation of N. 
 *In this exercise the input to the algorithm must be an integer N. Your algorithm should not calculate the binary representation 
 *of N but recursively finds the number of zeroes in the binary representation of N. 
 */
public class Recursion2 {
//base case n==1
	public static int getZeros(int n) {
		if(n==1) {
			return 0;
		}
		else if(n%2==1) {//meaning its odd
			return getZeros(n/2);
		}
		else {
			return getZeros(n/2)+1;
		}
	}
	//O(log(n)) runtime because keep divide by 2 
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("What is the number you want to get the number of zeros for? ");
		int num=in.nextInt();
		int z=getZeros(num);
		System.out.println(z);
		
	}
}
