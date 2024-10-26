package U1.supplyDemand;

import U1.PPC.Product;

/**
 * Model for a linear demand curve in an economy.
 */
public class DemandCurve {
    private Product product;
    private double intercept; 
    private double slope; 
    private boolean isInferiorGood; 

    /**
     * Create a demand curve using a linear demand function and whether the good is inferior.
     * @param intercept Intercept of demand function.
     * @param slope Slope of demand function (generally negative).
     * @param isInferiorGood Whether the demanded good is an inferior good.
     */
    public DemandCurve(Product product, double intercept, double slope, boolean isInferiorGood) {
        this.product = product;
        this.intercept = intercept;
        this.slope = slope;
        this.isInferiorGood = isInferiorGood;
    }

    // Accessor methods

    public Product getProduct() {
        return product;
    }

    public boolean isInferiorGood() {
        return isInferiorGood;
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    /**
     * Get price of the product given a certain quantity demanded.
     * @param quantity Quantity demanded.
     * @return Price consumers are willing to pay for the good.
     */
    public double getPGivenQd(int quantity) {
        return intercept + (slope * quantity);
    }

    /**
     * Get the quantity of a product demanded at a certain price.
     * @param price Price of good.
     * @return Quantity of the good consumers are willing to consume at the given price.
     */
    public int getQdGivenP(double price) {
        return (int) Math.max(0, (intercept - price) / slope); 
    }

    /**
     * Shift demand curve by a certain amount. 
     * @param shiftAmount Amount by which to shift curve. Increase shifts curve rightward.
     */
    public void shiftDemandCurve(double shiftAmount) {
        intercept += shiftAmount; 
    }

    /**
     * Increasing the preference for the product increases demand for it.
     * @param change Increase in preference for a product.
     */
    public void increasePreferenceForProduct(double change) {
        shiftDemandCurve(change);
    }

    /**
     * Increasing the market size increases demand for a product since there are
     * more consumers.
     * @param change Increase in market size.
     */
    public void increaseMarketSize(int change) {
        shiftDemandCurve((double) change);
    }

    /**
     * Increasing the price of complementary goods decreases demand for the good,
     * since it tends to be consumed along with the complementary good.
     * @param change Increase in the price of complementary goods.
     */
    public void increaseComplementaryGoodPrice(double change) {
        shiftDemandCurve(-change);
    }

    /**
     * Increasing the price of substitutes increases demand for the good, since
     * it is comparitively cheaper.
     * @param change Increase in the price of substitute goods.
     */
    public void increaseSubstituteGoodPrice(double change) {
        shiftDemandCurve(change);
    }

    /**
     * Increasing consumer income increases demand for the good unless it is an 
     * inferior good, in which case alternatives are purchased.
     * @param change Increase in average consumer income.
     */
    public void increaseConsumerIncome(double change) {
        if (isInferiorGood) {
            shiftDemandCurve(-change); 
        } else {
            shiftDemandCurve(change);
        }
    }

    /**
     * Increasing consumer expectations for the usefulness of a product raises its 
     * demand.
     * @param change Positive change in consumer expectations for product.
     */
    public void increaseExpectationsForProduct(double change) {
        shiftDemandCurve(change);
    }

}
