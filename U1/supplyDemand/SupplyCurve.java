package U1.supplyDemand;

import U1.PPC.Product;

/**
 * Model for a linear supply curve in a given economy.
 */
public class SupplyCurve {
    private Product product;
    private double intercept; 
    private double slope; 

    /**
     * Create a supply curve using a linear supply function.
     * @param intercept Intercept of supply function.
     * @param slope Slope of supply function (generally positive).
     */
    public SupplyCurve(Product product, double intercept, double slope) {
        this.product = product;
        this.intercept = intercept;
        this.slope = slope;
    }

    // Accessor methods

    public Product getProduct() {
        return product;
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    /**
     * Get price of the product given a certain quantity produced.
     * @param quantity Quantity produced.
     * @return Price producers are willing to pay to produce the good.
     */
    public double getPgivenQs(int quantity) {
        return intercept + (slope * quantity);
    }

    /**
     * Get the quantity of a product supplied at a certain price.
     * @param price Price of good.
     * @return Quantity of the good producers are willing to produce at the given price.
     */
    public int getQsGivenP(double price) {
        return (int) Math.max(0, (intercept - price) / slope); 
    }

    /**
     * Shift supply curve by a certain amount. 
     * @param shiftAmount Amount by which to shift curve. Increase shifts curve rightward.
     */
    public void shiftSupplyCurve(double shiftAmount) {
        intercept += shiftAmount;
    }

    /**
     * Increasing input prices decreases supply since it raises production costs.
     * @param change Increase in input prices.
     */
    public void increaseInputPrices(double change) {
        shiftSupplyCurve(-change);
    }

    /**
     * Increasing taxes decreases supply, while subsidies increase it.
     * @param taxChange Increase in taxes (negative effect).
     * @param subsidyChange Increase in subsidies (positive effect).
     */
    public void adjustForGovernmentTools(double taxChange, double subsidyChange) {
        shiftSupplyCurve(-(taxChange - subsidyChange)); // Taxes decrease supply; subsidies increase supply
    }

    /**
     * Increasing the number of sellers increases supply.
     * @param change Increase in the number of sellers.
     */
    public void increaseNumberOfSellers(int change) {
        shiftSupplyCurve((double) change);
    }

    /**
     * Advancements in technology increase supply by improving productivity.
     * @param change Increase in technology level.
     */
    public void improveTechnology(double change) {
        shiftSupplyCurve(change);
    }

    /**
     * If the price of other goods increases, it may affect supply.
     * @param change Increase in the price of alternative goods.
     */
    public void increasePriceOfOtherGoods(double change) {
        shiftSupplyCurve(-change); // Depending on context, this may need adjustment
    }

}
