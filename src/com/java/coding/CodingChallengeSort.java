package com.java.coding;

import java.util.Arrays;

/**
* Sort the following list in numeric order 
* Sorted ascending by using bubble sort, quick sort and Java.utils sort API
* @author  Ketaki Raste
* @12/12/2016 
*/

public class CodingChallengeSort {
	
	public static void main(String args[]){
		int array1[] = {10,5,63,29,71,10,12,44,29,10,-1};
		int array2[] = {10,5,63,29,71,10,12,44,29,10,-1};
		int array3[] = {10,5,63,29,71,10,12,44,29,10,-1};
		
		Arrays.sort(array1);
		System.out.println("Ascending sort using java.util.Arrays: " + Arrays.toString(array1));
		
		bubbleSort(array2);
		System.out.println("Ascending bubble sort: " + Arrays.toString(array2));
		
		quickSort(array3, 0, array3.length-1);
		System.out.println("Ascending quick sort: " + Arrays.toString(array3));
	}
	
			
	public static void bubbleSort(int[] inputArray){
		int temp = 0;
		for(int i = 0; i < inputArray.length; i++){
			for(int j = 1; j< (inputArray.length - i); j++){
				if(inputArray[j-1] > inputArray[j]){
					temp = inputArray[j-1];
					inputArray[j-1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
	}
	
	public static void quickSort(int[] inputArray, int lowIndex, int highIndex) {
		if (inputArray == null || inputArray.length == 0)
			return;
 
		if (lowIndex >= highIndex)
			return;
 
		// find pivot and divide array into two parts
		int middle = lowIndex + (highIndex - lowIndex) / 2;
		int pivot = inputArray[middle];

		int i = lowIndex, j = highIndex;
		while (i <= j) {
			// find element from left part of array that is greater than pivot element
			while (inputArray[i] < pivot) {
				i++;
			}
			// find element from right part of array that is smaller than pivot element
			while (inputArray[j] > pivot) {
				j--;
			}
			// if we find element in left part that is greater 
			// and find element in right part that is smaller
			// then swap those elements
			if (i <= j) {
				int temp = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (lowIndex < j)
			quickSort(inputArray, lowIndex, j);
 
		if (highIndex > i)
			quickSort(inputArray, i, highIndex);
	}
}
