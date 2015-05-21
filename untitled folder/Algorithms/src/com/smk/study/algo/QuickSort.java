package com.smk.study.algo;

public class QuickSort {
	
	public int partition(int arr[],int start , int h){
		int key = arr[h];
		int cursur = start;
		
		for (int i = start ; i <= h-1;i++){
			if(arr[i] < key){
				AlgoMain.swap(arr, cursur, i);
				cursur++;
			}
		}
		AlgoMain.swap(arr, cursur, h);
		
		return cursur;
	}
	
	//{1,2,4,33,55,22,6,62,98,56,34,23,87,97,12,14,19}
	public void quickSort(int arr[],int start , int h){
		if(start < h){
			
			int partionIndex = partition(arr, start, h);
			quickSort(arr, start, partionIndex-1);
			quickSort(arr, partionIndex+1, h);
			
		}
		
	}

}
