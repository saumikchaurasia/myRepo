/**
 * 
 */
package com.smk.study.algo;


/**
 * @author munna
 *
 */
public class AlgoMain {
	static int count;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = 0;
		int arr[] = {1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19,76,344,222,455,244,21,57,32,67,32,688,355,267,43,667,322,7542,783,457,34,78,32,54};
		int val = 56;
		System.out.println(new LinearSearchAlgorithm().search(arr, val));
		startTime = System.currentTimeMillis();
		mergeSort(arr ,0, arr.length-1);
		printArr(arr, "mergeSort","Total Time " + (System.currentTimeMillis() - startTime));
		arr = new int[] {1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19,76,344,222,455,244,21,57,32,67,32,688,355,267,43,667,322,7542,783,457,34,78,32,54};
		
		startTime = System.currentTimeMillis();
		selectionSort(arr);
		printArr(arr, "selectionSort","Total Time " + (System.currentTimeMillis() - startTime));
		arr = new int[] {1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19,76,344,222,455,244,21,57,32,67,32,688,355,267,43,667,322,7542,783,457,34,78,32,54};
		
		startTime = System.currentTimeMillis();
		bubbleSort(arr);
		printArr(arr, "bubbleSort","Total Time " + (System.currentTimeMillis() - startTime));
		arr = new int[] {1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19,76,344,222,455,244,21,57,32,67,32,688,355,267,43,667,322,7542,783,457,34,78,32,54};
		
		startTime = System.currentTimeMillis();
		new QuickSort().quickSort(arr, 0, arr.length-1);
		printArr(arr, "QuickSort","Total Time " + (System.currentTimeMillis() - startTime));
		arr = new int[] {1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19,76,344,222,455,244,21,57,32,67,32,688,355,267,43,667,322,7542,783,457,34,78,32,54};
		
		val = 9;
		System.out.println("\n"+new BinarySearchAlgorithm().search(arr, val,0,arr.length));
		val = 19;
		//System.out.println(new BinarySearchAlgorithm().search(arr, val));
		
	}
	
	static void printArr(int arr[] , String AlgoName, String timeStr){
		System.out.print("\n"+AlgoName + "  " + timeStr +" **>** ");
		for(int a : arr)
			System.out.print(" " +a);
		
	}
	
	static void selectionSort(int arr[]){
		boolean flag = arr[0] <= arr[1];
		for(int i = 0 ; i< arr.length -1 ; i++){
			int minIndex =i; 
			for(int j =i+1; j< arr.length ; j++){
				if(arr[j]< arr[minIndex])
					minIndex = j;
				if(arr[j-1] > arr[j]){
					flag = false;
				}
			}
			if(flag ==true){
				System.out.println("Already Sorted");
				break;
			}
			if( i!= minIndex)
				swap(arr, minIndex,i);
		}
	}
	
	static void swap(int arr[],int minIndex,int index){
			int temp = arr[index];
			arr[index] = arr[minIndex];
			arr[minIndex] = temp;
	}
	
	static void bubbleSort(int arr[]){
		for(int i = 0 ; i< arr.length -1 ; i++){
			for(int j =i+1; j< arr.length-1 ; j++){
				if(arr[j] > arr[j+1])
					swap(arr,j+1,j);
			}
			
		}
	}
	
	static void mergeSort(int arr[],int l,int r){
		if(l < r){
			int middle = (l+ r)/2;
			//System.out.println("\npass : "+ ++count+" : "+middle+" : "+l+" : "+r);
			mergeSort(arr, l, middle);
			mergeSort(arr, middle+1, r);
			merge(arr,l,middle,r);
		}
		
	}

	private static void merge(int arr[], int l, int middle, int r) {
		int len1 = middle - l + 1;
		int len2 = r - middle;
		int temp1[] = new int[len1];
		int temp2[] = new int[len2];
		//System.out.println("\n");
		for(int i =0 ; i < len1; i++){
			//System.out.println("Array 1 " + arr[i]);
			temp1[i] = arr[l+i];
		}
		
		for(int i =0 ; i < len2; i++){
			//System.out.println("Array 1 " + arr[i]);
			temp2[i] = arr[middle+i+1];
		}
		
		//System.out.println("_------***********************************");
		int i =0,j=0,k=l;
		while(i < len1 && j< len2){
			if(temp1[i] < temp2[j]){
				arr[k] = temp1[i];
				i++;
			}else{
				arr[k] = temp2[j];
				j++;
			}
			k++;
		}
		
		//System.out.println("L = "+ l +" : Middle = "+middle+" : R = "+middle);
		for(;i<len1; i++){
			arr[k++] = temp1[i];
		}
		for(;j<len2; j++){
			arr[k++] = temp2[j];
		}
		
		
	}

	

}
