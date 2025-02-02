package edu.neu.csye7374;


public class BullMarketStrategy implements StockStrategy {
    @Override
    public double calculateNewPrice(double currentPrice) {
        return currentPrice * 1.20;
    }
}
