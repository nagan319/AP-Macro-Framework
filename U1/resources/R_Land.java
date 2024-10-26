package U1.resources;

/**
 * Class to store and modify the land (natural resources) available in an economic context.
 */
class R_Land {
    private double amount; 

    public R_Land(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double additionalAmount) {
        this.amount += additionalAmount;
    }
}
