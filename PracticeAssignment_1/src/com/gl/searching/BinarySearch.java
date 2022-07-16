package com.gl.searching;

public class BinarySearch {


	public static double binarySearch(double[] array, int low, int high, double key) {
		if (high < low) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (key == array[mid]) {
			return mid;
		} else if (key > array[mid]) {
			return binarySearch(array, mid + 1, high, key);
		} else  {
			return binarySearch(array, low, mid - 1, key);
		}
	}
}
