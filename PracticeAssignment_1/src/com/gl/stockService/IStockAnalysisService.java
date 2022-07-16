package com.gl.stockService;

public interface IStockAnalysisService {

	double[] stockPriceAscendingOrder (double [] stockPriceArray);
	double[] stockPriceDescendingOrder(double [] stockPriceArray);
	void stockPriceComparisionRise(Boolean[]  priceStatus);
	void stockPriceComparisionDecline(Boolean[]  priceStatus);
	void stockPriceAvailability(double [] stockPriceArray);
	

}
