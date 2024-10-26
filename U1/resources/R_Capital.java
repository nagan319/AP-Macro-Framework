package U1.resources;

/**
 * Class to store and modify the amount of capital (machinery, tools, etc.) available in an economic context.
 */
class R_Capital {
    private double amount; 

    public R_Capital(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double additionalAmount) {
        this.amount += additionalAmount;
    }
}
