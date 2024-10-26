package U1.resources;

/**
 * Class to store total amount of resources available in an economy using
 * CELL (land, labor, capital, entrepreneurship) model
 */
public class Resources {
    private R_Land land;
    private R_Labor labor;
    private R_Capital capital;
    private R_Entrepreneurship entrepreneurship;

    public Resources(R_Land land, R_Labor labor, R_Capital capital, R_Entrepreneurship entrepreneurship) {
        this.land = land;
        this.labor = labor;
        this.capital = capital;
        this.entrepreneurship = entrepreneurship;
    }

    // Accessor methods for various resource types

    public double totalLand() {
        return land.getAmount();
    }

    public int totalLabor() {
        return labor.getNumberOfWorkers();
    }

    public double totalCapital() {
        return capital.getAmount();
    }

    public double totalEntrepreneurship() {
        return entrepreneurship.getAbility();
    }

    // Arbitrary calculation - probably not accurate
    public double totalAmount() {
        return (totalLand() + totalCapital() + totalLabor()) * totalEntrepreneurship(); 
    }

    // Methods for modifying the amount of resources available

    public void addLand(double amount) {
        land.addAmount(amount);
    }

    public void addLabor(int numberOfWorkers) {
        labor.addWorkers(numberOfWorkers);
    }

    public void addCapital(double amount) {
        capital.addAmount(amount);
    }

    public void improveEntrepreneurship(double additionalAbility) {
        entrepreneurship.increaseAbility(additionalAbility);
    }
}
