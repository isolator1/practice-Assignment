package com.gl.stockService;

import java.util.Scanner;
import com.gl.sorting.MergeSortAsc;
import com.gl.sorting.MergeSortDsc;
import com.gl.searching.BinarySearch;

public class StockAnalysis implements IStockAnalysisService {
	private final static Scanner sc = new Scanner(System.in);

	@Override
	public double[] stockPriceAscendingOrder(double[] stockPriceArray) {
		MergeSortAsc msasc = new MergeSortAsc();
		msasc.mergeSortAsc(stockPriceArray, 0, stockPriceArray.length - 1);
		return stockPriceArray;
	}

	@Override
	public double[] stockPriceDescendingOrder(double[] stockPriceArray) {
		MergeSortDsc msdsc = new MergeSortDsc();
		msdsc.mergeSortDsc(stockPriceArray, 0, stockPriceArray.length - 1);
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
		BinarySearch bs = new BinarySearch();
		System.out.println("Enter key value to be found in the list");
		double keyValue = sc.nextDouble();
		double priceKeyValue = bs.binarySearch(stockPriceArray, 0, stockPriceArray.length - 1, keyValue);
//		System.out.println(priceKeyValue);
//		System.out.println(stockPriceArray.length);
//		System.out.println(Arrays.toString(stockPriceArray));
		if (priceKeyValue > -1) {
			System.out.println("Stock of Value " + keyValue + " is present");
		} else {
			System.out.println("Stock of Value " + keyValue + " is not present");
		}

	}
}
