package com.smk.study.algo;

public class LinearSearchAlgorithm {
	public int search(int arr[], int val){
		
		for(int i = 0; i< arr.length;i++){
			if(arr[i] == val)
				return 1;
		}
		return -1;
	}
}
