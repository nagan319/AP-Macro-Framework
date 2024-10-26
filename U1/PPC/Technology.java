package U1.PPC;

/**
 * Class representing the technological level of an economy.
 * Technology is different from capital since it is a function as opposed to a quantifiable value
 * and covers aspects such as logistics and infrastructure.
 */
class Technology {
    private double efficiencyFactor;

    /**
     * Initialize technology parameter. 
     * @param efficiencyFactor Factor by which production efficiency is improved.
     */
    public Technology(double efficiencyFactor) {
        this.efficiencyFactor = efficiencyFactor;
    }

    /**
     * Apply technological multiplier to base cost of product.
     * @param baseCost Base cost of product.
     * @return Modified cost.
     */
    public double applyTech(double baseCost) {
        return baseCost / efficiencyFactor; 
    }

    /**
     * Improve level of technological advancement by a certain factor.
     * @param improvement Factor by which to increase efficiency factor.
     */
    public void improveTechnology(double improvement) {
        efficiencyFactor += improvement; 
    }
}

