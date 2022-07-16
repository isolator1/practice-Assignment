package com.gl.driver;

import com.gl.stockService.StockAnalysis;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
	private static final Scanner sc = new Scanner(System.in);
	private static final StockAnalysis sa = new StockAnalysis();

	public static void main(String[] args) {
		System.out.println("Enter Number of Companies for which you wish to enter stock prices :- ");
		int noOfCompanies = sc.nextInt();
		Boolean[] priceStatus = new Boolean[noOfCompanies];
		double[] stockPriceArray = new double[noOfCompanies];
		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter Stock Price of Company --->" + (i + 1));
			stockPriceArray[i] = sc.nextDouble();
			System.out
					.println("Whether the company's --> " + (i + 1) + " stock price rose today compared to yesterday?");
			try {
			priceStatus[i] = sc.nextBoolean();
			} catch (InputMismatchException exp) {
			    System.err.println("Please, enter only true or false");
			}
		}
		Boolean menuLoopStatus = true;

		while (menuLoopStatus == true) {
			System.out.println("  ");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Enter the Operation you want to perform form the followings : - ");
			System.out.println("1. Display the stock prices in Ascending Order : - ");
			System.out.println("2. Display the stock prices in Descending Order : - ");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stockPrice");
			System.out.println("6. Press 0 to exit");
			System.out.println(" ------------------------------------------------------------------------ ");
			System.out.println("");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Stock Prices in Ascendng Order are :- ");
				System.out.println(Arrays.toString(sa.stockPriceAscendingOrder(stockPriceArray)).replace("[", "")
						.replace("]", ""));
				break;

			case 2:
				System.out.println("Stock Prices in Descendng Order are :- ");
				System.out.println(Arrays.toString(sa.stockPriceDescendingOrder(stockPriceArray)).replace("[", "")
						.replace("]", ""));
				break;

			case 3:
				sa.stockPriceComparisionRise(priceStatus);
				break;

			case 4:
				sa.stockPriceComparisionDecline(priceStatus);
				break;

			case 5:
				sa.stockPriceAvailability(stockPriceArray);
				break;

			case 0:
				System.out.println("Exited Successfuly");
				System.exit(0);
				break;

			default:
				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}

		}

	}
}
