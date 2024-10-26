package U1.PPC;

/**
 * Represents a product that can be produced in an economy.
 */
public class Product {
    private String name;
    private double baseCost; 

    /**
     * Create a new product object.
     * @param baseCost Base cost of product without taking into account technology.
     */
    public Product(String name, double baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    /**
     * Returns cost of producing a certain product based on the technological level of an economy.
     * @param tech Technology level of economy.
     * @return Cost of product given technology level.
     */
    public double cost(Technology tech) {
        return tech.applyTech(baseCost);
    }

    public boolean equals(Product p) {
        return this.name.equals(p.name);
    }
}

