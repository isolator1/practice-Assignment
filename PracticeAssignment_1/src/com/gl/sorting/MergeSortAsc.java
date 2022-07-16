package com.gl.sorting;


public class MergeSortAsc {

	public static void merge(double[] array, int left, int mid, int right) {
		int sizeOfLeft;
		int sizeOfRight;
		sizeOfLeft = mid - left + 1;
	    sizeOfRight = right - mid;
		double leftArray[] = new double[sizeOfLeft];
		double rightArray[] = new double[sizeOfRight];
		for (int index = 0; index < sizeOfLeft; index++) {
			leftArray[index] = array[left + index];
		}
		for (int index = 0; index < sizeOfRight; index++) {
			rightArray[index] = array[mid + 1 + index];
		}
			int i = 0, j = 0;
			int k = left;
			while (i < sizeOfLeft && j < sizeOfRight) {
				if (leftArray[i] <= rightArray[j]) {
					array[k++] = leftArray[i++];
				} else {
					array[k++] = rightArray[j++];
				}
			}
			while (i < sizeOfLeft) {
				array[k++] = leftArray[i++];
			}
			while (j < sizeOfRight) {
				array[k++] = rightArray[j++];
			}
	}

	public static double[] mergeSortAsc(double[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right)/ 2;
			mergeSortAsc(array, left, mid);
			mergeSortAsc(array, mid + 1, right);
			merge(array,left,mid,right);
		}
		return array;
	}
}
