package edu.neu.csye7374;

public class Stock {

    protected String name;
    protected double price;
    protected StockStrategy strategy;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    public void updatePrice() {
        if (strategy != null) {
            price = strategy.calculateNewPrice(price);
            System.out.println(name + " new price: $" + price);
        } else {
            System.out.println("No strategy set for " + name);
        }
    }

    public static void demo() {
        Stock techStock = new TechStock("Apple", 150.0);
        Stock pharmaStock = new PharmaStock("Pfizer", 80.0);

        // Applying Bull Market Strategy
        StockStrategy bullStrategy = new BullMarketStrategy();
        techStock.setStrategy(bullStrategy);
        pharmaStock.setStrategy(bullStrategy);

        System.out.println("Bull Market Scenario:");
        techStock.updatePrice();
        pharmaStock.updatePrice();

        // Applying Bear Market Strategy
        StockStrategy bearStrategy = new BearMarketStrategy();
        techStock.setStrategy(bearStrategy);
        pharmaStock.setStrategy(bearStrategy);

        System.out.println("\nBear Market Scenario:");
        techStock.updatePrice();
        pharmaStock.updatePrice();
    }
}
