package U1.supplyDemand;

import U1.PPC.Product;

/**
 * Simple supply-demand model for evaluating the production of goods at 
 * different price and quantity points.
 */
public class SupplyDemandModel {
    private Product product;
    private SupplyCurve supplyCurve;
    private DemandCurve demandCurve;

    /**
     * Enum containing all the possible states of an economy modeled using a supply-demand model.
     */
    public enum SupplyDemandState {
        SURPLUS,
        SHORTAGE,
        EQUILIBRIUM
    }

    /**
     * Create a new supply-demand model.
     * @param supplyCurve Supply curve.
     * @param demandCurve Demand curve.
     */
    public SupplyDemandModel(SupplyCurve supplyCurve, DemandCurve demandCurve) {
        if (!supplyCurve.getProduct().equals(demandCurve.getProduct())) {
            throw new IllegalArgumentException("Indicated supply and demand curves have mismatched products.");
        }
        this.product = supplyCurve.getProduct();
        this.supplyCurve = supplyCurve;
        this.demandCurve = demandCurve;
    }

    // Accessor methods

    public Product getProduct() {
        return product;
    }

    public SupplyCurve getSupplyCurve() {
        return supplyCurve;
    }

    public DemandCurve getDemandCurve() {
        return demandCurve;
    }

    /**
     * Get the economic state given a certain amount of a good being
     * produced.
     * @param quantity Quantity of the good being produced.
     * @return
     */
    public SupplyDemandState getEconomicStateGivenQ(int quantity) {

        var ps = supplyCurve.getPgivenQs(quantity);
        var pd = demandCurve.getPGivenQd(quantity);

        if (ps > pd) {
            return SupplyDemandState.SHORTAGE;
        } else if (ps < pd) {
            return SupplyDemandState.SURPLUS;
        }
        return SupplyDemandState.EQUILIBRIUM;
    }

    /**
     * Get the economic state given a certain price of a good.
     * @param price Price of good.
     * @return The economic state.
     */
    public SupplyDemandState getEconomicStateGivenP(double price) {

        var qs = supplyCurve.getQsGivenP(price);
        var qd = demandCurve.getQdGivenP(price);

        if (qs > qd) {
            return SupplyDemandState.SURPLUS;
        } else if (qs < qd) {
            return SupplyDemandState.SHORTAGE;
        } 
        return SupplyDemandState.EQUILIBRIUM;
    }

}
