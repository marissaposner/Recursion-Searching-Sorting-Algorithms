import java.util.*;

public class Sorting {

	public static void BubbleSortNonRecursive(int[] arr) {
		int temp;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}//worst case: run time = O(n^2)
	//best case is if it is sorted so then just n
	
	public static void BubbleSortRecursive(int[] arr, int n) {
		//Base case=array size is 1
		if(n==1) {
			return;
		}
		
		for(int i=0; i<n-1; i++) { 
			if(arr[i]>arr[i+1]){		
				swap(arr, i, i+1);
			}
		}
		//first move largest element to end and then recursively do the rest of the elements
		BubbleSortRecursive(arr, n-1); //
	}
	public static void swap(int[] arr, int first, int second) {
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}
	public static void SelectionSort(int[] arr) {
		//repeatedly find minimum element and put at beginning
		//algorithm has 2 subarrays in a given array.
		int n=arr.length;
		int min;
		for(int i=0; i<n-1; i++) { 
			min=i; 
			for(int j=i+1; j<n; j++) { //inner loop finds the next smallest (or largest) value
				if (arr[min]>arr[j]) {
					min=j;
				}
			}
			swap(arr, min,i); //swaps min with i 
			////and the outer loop places that value into its proper location 
		}
	}//O(n^2)
	public static void InsertionSort(int[] arr) {
		//shifting and then inserting
		//divide list into 2 parts: sorted & unsorted
		//sorted part contains the first element 
		//unsorted part contains the elements from index 1 to N-1
		int temp; 
		int n=arr.length; 
		for(int i=1; i<arr.length; i++) {
			int j=i; //set j to i 
			temp=arr[i];
			while(j>0 && temp<arr[j-1]) {
				arr[j]=arr[j-1]; //because arr[j-1] is smaller than arr[j]

				j--; //subtract until j=0 
	
			} //shift all the elements up if temp is less than arr[j-1] which is one to the left of it 
			//iteratively shifting elements to the right until hit boundary of j=0 or temp!<arr[j-1]
			arr[j]=temp; //now insert the smallest element in the spot 
		
		}
	}
	public static void mergeSort(int[] arr, int left, int right) {
//		if(right-left<1) {
//			return;
//		}
		if(left<right) {
			int mid=(left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
		
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int size1=mid-left+1;
		int size2=right-mid;
		//create 2 new arrays
		int Left[]=new int[size1];
		int Right[]=new int[size2];
		//fill temp arrays 
		for(int p=0; p<size1; p++) {
			Left[p]=arr[left+p]; //iterate through the array and then add i to the left point to get indexes
		}
		for(int q=0; q<size2; q++) {
			Right[q]=arr[mid+1+q]; //add 1 because start from 1 over from mid 
		}
		
		//merge the two arrays
		int i=0,j=0; 
		
		int k=left; //initialize int k to be left index 
		while(i<size1 && j<size2) { //when both still have elements to fill 
			if(Left[i]<=Right[j]) {
				arr[k]=Left[i];
				i++;
			}
			else {
				arr[k]=Right[j];
				j++;
			}
			k++;
		}
		//copy remaining elements
		while(i<size1) {
			arr[k]=Left[i]; 
			i++; 
			k++;
		}
		while(j<size2) {
			arr[k]=Right[j];
			j++;
			k++;
		}
	}
	public static void quickSort(int[] arr, int low, int high) {
		if(low<=high) {
			Random rand=new Random(); 
			int random_index=low+rand.nextInt(high-low+1);
			int pivot_index=partition(arr,low,high,random_index);
			quickSort(arr,low,pivot_index-1); //split into two halves 
			quickSort(arr, pivot_index+1, high);
		}
	}
	public static int partition(int[] arr, int low, int high, int pivot_index) {
		//put pivot index value to the back of the array and then later we will put it back in the right middle spot after we move
		//all the other vals to correct spot
		swap(arr, pivot_index, high); 
		//then swap elements less than or equal to pivot_index to the left half of the array 
		//swap elements greater than pivot to right half
		int i=low; //at beginning i and j point at the same thing and then i increases 
		int pivot=arr[high];
		for(int j=low; j<high; j++) {
			if(arr[j]<=pivot) {
				swap(arr, i,j); 
				i++; 
			}
		}
		//put pivot element back in the right place
		//everything left of i is less than pivot and everything right of i is greater than pivot 
		swap(arr, i,high); //i is at end which is where you put the pivot_index at beg 
		return i;  //now i is at the position of the pivot index that was told in the beginning 
		
	}
	
	public static void main(String[] args) {
		int[] array= {64,25,11,22,12};
		printBubbleSortNonRecursive();
		printBubbleSortRecursive();
		printSelectionSort();
		printInsertionSort();
		printMergeSort();
		printQuickSort();
	}
	public static void printBubbleSortNonRecursive() {
		int[] array= {64,25,11,22,1};
		BubbleSortNonRecursive(array);
		System.out.println("Bubble Sort Non Recursive");
		printArray(array);
		System.out.println();
	}
	public static void printBubbleSortRecursive() {
		int[] array= {64,11,25,11,22,24};
		BubbleSortRecursive(array, array.length);
		System.out.println("Bubble Sort Recursive");
		printArray(array);
		System.out.println();
	}
	public static void printSelectionSort() {
		int[] array= {64,5,25,22,-1};
		SelectionSort(array);
		System.out.println("Selection Sort");
		printArray(array);
		System.out.println(); 
	}
	public static void printInsertionSort() {
		int[] array= {64,25,11,22,11};
		InsertionSort(array); 
		System.out.println("Insertion Sort");
		printArray(array);
		System.out.println();
	}
	public static void printMergeSort() {
		int[] array={12, 11, 13, 5, 6, 7};
		mergeSort(array, 0, array.length-1); 
		System.out.println("Merge Sort ");
		printArray(array);
		System.out.println(); 
	}
	public static void printQuickSort() {
		int[] array={64,25,11,22,11,-1,5};
		quickSort(array,0,array.length-1);
		System.out.println("Quick Sort ");
		printArray(array);
		System.out.println();
	}
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}
}
