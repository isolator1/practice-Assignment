package com.gl.stockService;

import java.util.Arrays;

import java.util.Scanner;


import com.gl.sorting.MergeSortAsc;
import com.gl.sorting.MergeSortDsc;
import com.gl.searching.BinarySearch;

public class StockAnalysis implements IStockAnalysisService {
	private final static Scanner sc = new Scanner(System.in);

	@Override
	public double[] stockPriceAscendingOrder(double[] stockPriceArray) {
		MergeSortAsc.mergeSortAsc(stockPriceArray, 0, stockPriceArray.length - 1);
		return stockPriceArray;
	}

	@Override
	public double[] stockPriceDescendingOrder(double[] stockPriceArray) {
		MergeSortDsc.mergeSortDsc(stockPriceArray, 0, stockPriceArray.length - 1);
		return stockPriceArray;
	}

	@Override
	public void stockPriceComparisionRise(Boolean[] priceStatus) {
		
		int countOfStatusTrue = 0;
		for (int i = 0; i < priceStatus.length; i++) {
			if (priceStatus[i] == true) {
				countOfStatusTrue++;
			}
		}
		System.out.println("Total no of companies whose stocks price rose today  :- " + countOfStatusTrue);
	}

	@Override
	public void stockPriceComparisionDecline(Boolean[] priceStatus) {
		int countOfStatusFalse = 0;
		for (int i = 0; i < priceStatus.length; i++) {
			if (priceStatus[i] == false) {
				countOfStatusFalse++;
			}
		}
		System.out.println("Total no of companies whose stocks price declined today  :- " + countOfStatusFalse);
	}

	@Override
	public void stockPriceAvailability(double[] stockPriceArray) {
		System.out.println(Arrays.toString(stockPriceArray));
		System.out.println("Enter key value to be found in the list");
		double keyValue = sc.nextDouble();
		MergeSortAsc.mergeSortAsc(stockPriceArray, 0, stockPriceArray.length - 1);
		double priceKeyValue = BinarySearch.binarySearch(stockPriceArray, 0, stockPriceArray.length - 1, keyValue);
		if (priceKeyValue > -1) {
			System.out.println("Stock of Value " + keyValue + " is present");
		} else {
			System.out.println("Stock of Value " + keyValue + " is absent");
		}

	}
}
