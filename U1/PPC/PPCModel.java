package U1.PPC;

import U1.resources.Resources;

/**
 * PPC model for evaluating the capabilites of an economy with respect to the production of two products.
 * Assumes linear opportunity cost across model.
 */
class PPCModel {
    private Product productA;
    private Product productB;
    private Resources availableResources;
    private Technology techA;
    private Technology techB;

    /**
     * Enum containing all the possible states of an economy modeled using a PPC graph.
     */
    public enum PPCState {
        IMPOSSIBLE,
        FULL_CAPACITY,
        UNDERPRODUCTION
    }

    /**
     * Create a new PPC model.
     * @param a Product A.
     * @param b Product B.
     * @param availableResources Total resources available in the economy.
     * @param techA Level of technology available for producing product A.
     * @param techB Level of technology available for producing product B.
     */
    public PPCModel(Product a, Product b, Resources availableResources, Technology techA, Technology techB) {
        this.productA = a;
        this.productB = b;
        this.availableResources = availableResources;
        this.techA = techA;
        this.techB = techB;
    }

    // Accessor methods for products

    public Product getProductA() {
        return this.productA;
    }

    public Product getProductB() {
        return this.productB;
    }

    /**
     * Get the units of product A that are available for production given the concurrent production of
     * amtB units of product B.   
     * @param amtB Amount of product B being concurrently produced.
     * @return Amount of product A able to be produced.
     */
    public int getAmtA(int amtB) {
        double availableAmount = availableResources.totalAmount();
        double costB = productB.cost(techB);
        double costA = productA.cost(techA);
        
        return (int) ((availableAmount - amtB * costB) / costA);
    }
    
    /**
     * Get the units of product B that are available for production given the concurrent production of
     * amtB units of product A.   
     * @param amtB Amount of product A being concurrently produced.
     * @return Amount of product B able to be produced.
     */
    public int getAmtB(int amtA) {
        double availableAmount = availableResources.totalAmount();
        double costA = productA.cost(techA);
        double costB = productB.cost(techB);
        
        return (int) ((availableAmount - amtA * costA) / costB);
    }

    /**
     * Get the opportunity cost of a certain product in terms of the units of the other product being
     * concurrently produced.
     * @param product Product for which to calculate opportunity cost.
     * @return Opportunity cost as a decimal.
     */
    public double getOpportunityCost(Product product) {
        if (product.equals(productA)) {
            double costOfProductA = product.cost(techA); 
            double costOfProductB = productB.cost(techB); 
            return costOfProductA / costOfProductB; 
        } else if (product.equals(productB)) {
            double costOfProductA = productA.cost(techA); 
            double costOfProductB = product.cost(techB);
            return costOfProductB / costOfProductA; 
        } 
        throw new IllegalArgumentException("Attempted to get opportunity cost of a product that is not being produced in the economy.");
    }

    /**
     * Check whether a certain point is on the PPC curve.
     * @param amtA Amount of product A being produced.
     * @param amtB Amount of product B being produced.
     * @return true if the point is on the PPC curve, false otherwise.
     */
    public boolean isOnPPC(int amtA, int amtB) {
        return amtA * productA.cost(techA) + amtB * productB.cost(techB) == availableResources.totalAmount();
    }

    /**
     * Get the state in which the economy would be if it was producing the inputted amount of products A and B.
     * @param amtA Amount of product A being produced.
     * @param amtB Amount of product B being produced.
     * @return Economic state at given point.
     */
    public PPCState getEconomicState(int amtA, int amtB) {
        var resourcesRequired = amtA * productA.cost(techA) + amtB * productB.cost(techB);
        var resourcesAvailable = availableResources.totalAmount();

        if (resourcesRequired < resourcesAvailable) {
            return PPCState.IMPOSSIBLE;
        } else if (resourcesRequired == resourcesAvailable) {
            return PPCState.FULL_CAPACITY;
        }
        return PPCState.UNDERPRODUCTION;
    }

    /**
     * Change the amount of available resources in an economy, shifting the PPC curve right or left.
     * Assumes all types of resources to be equally affected.
     * @param amount Amount by which to change available resources.
     */
    public void changeAvailableResources(double amount) {
        this.availableResources.addLand(amount / 4); 
        this.availableResources.addLabor((int) (amount / 4)); 
        this.availableResources.addCapital(amount / 4); 
        this.availableResources.improveEntrepreneurship(amount / 4); 
    }

    /**
     * Improve the technology for producing product A by a certain amount.
     * @param improvement Factor by which to increase efficiency factor.
     */
    public void improveTechnologyA(double improvement) {
        techA.improveTechnology(improvement);
    }

    /**
     * Improve the technology for producing product B by a certain amount.
     * @param improvement Factor by which to increase efficiency factor.
     */
    public void improveTechnologyB(double improvement) {
        techB.improveTechnology(improvement);
    }
}

