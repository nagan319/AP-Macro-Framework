package U1.PPC;

/**
 * Model for comparing the PPC models of two countries and determining
 * comparative and absolute advantages for given products.
 */
class TradeModel {

	private PPCModel countryA;
	private PPCModel countryB;

    public TradeModel(PPCModel countryA, PPCModel countryB) {
        if (!countryA.getProductA().equals(countryB.getProductA()) ||
            !countryA.getProductB().equals(countryB.getProductB()))
                throw new IllegalArgumentException("Attempted to create trade model using PPC models with mismatched products.");
        this.countryA = countryA;
        this.countryB = countryB;
    }

    /**
     * Returns country with absolute advantage in terms of producing a certain product.
     * @param product Product to be compared.
     * @return PPC model for ountry with absolute advantage in terms of production.
     */
    public PPCModel absoluteAdvantage(Product product) {
        if (product.equals(countryA.getProductA())) {
            if (countryA.getAmtA(0) > countryB.getAmtA(0)) {
                return countryA;
            } else if (countryA.getAmtA(0) < countryB.getAmtA(0)) {
                return countryB;
            } else {
                return null;
            }
        } else if (product.equals(countryA.getProductB())) {
            if (countryA.getAmtB(0) > countryB.getAmtB(0)) {
                return countryA;
            } else if (countryA.getAmtB(0) < countryB.getAmtB(0)) {
                return countryB;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * Returns country with comparative advantage in terms of producing a certain product.
     * @param product Product to be compared.
     * @return PPC model for ountry with comparative advantage in terms of production.
     */
    public PPCModel comparativeAdvantage(Product product) {
        if (countryA.getOpportunityCost(product) < countryB.getOpportunityCost(product)) {
            return countryA;
        } else if (countryA.getOpportunityCost(product) > countryB.getOpportunityCost(product)) {
            return countryB;
        }
        return null;
    }

}

