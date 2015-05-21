package com.smk.study.algo;

public class BinarySearchAlgorithm {
	int pass = 0;
	int search(int arr[],int val){
		int l = 0 , r = arr.length;
		for(int i = 0 ;  i< arr.length /2 ;i++){
			int mid = (l + r) /2;
			if(l > r)
				return -1;
			if(arr[mid] == val){
				return 1;
			}
			if(arr[mid] < val)
				l = mid +1;
			else
				r = mid -1;
			
		}
		return -1;
	}
	
	int search(int arr[],int val,int l ,int r){
		
		//System.out.println("pass :" + ++pass);
		if(r < l){
			return -1;
		}
		int mid = (r + l )/2;
		//System.out.print(" : "+l+" : "+r+" : "+mid +" : "+ arr[mid]);
		if(arr[mid] == val){
			return 1;
		}
		if(arr[mid] < val)
			return search(arr, val, mid +1, r);
		else
			return search(arr, val, l, mid-1);
		
		//return -1;
	}
}
