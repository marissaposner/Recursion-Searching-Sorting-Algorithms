import java.util.Arrays;

/**
 * @author marissaposner
 *Design and implement a binary recursive algorithm that finds the maximum number in array of size n
 */
public class Recursion1 {
	public static int findMax(int[] arr,  int left, int right) {

		int mid=(left+right)/2;
		int maxnum=0; //initialize to 0

		if(left==right) {
			maxnum=arr[left]; 
		}
		else { //split into two and find max of both 
			int maxLeft=findMax(arr, 0,mid);
			int maxRight=findMax(arr, mid+1, right);
			if(maxLeft>maxRight) {
				maxnum=maxLeft;
			}
			else {
				maxnum=maxRight;
			}
		}
		return maxnum;
	}
	public static void main(String args[]) {
		int[] testArr= {0,-1,8,11,4,2,0,200,500,1020, -1000, -80, 5, 9,44};
		//sort
		Arrays.sort(testArr);
		System.out.println(findMax(testArr, 0,testArr.length-1));
	}
	//write recursive func that returns max element 
}
