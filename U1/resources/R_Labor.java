package U1.resources;

/**
 * Class to store and modify the labor force (number of workers) available in an economic context.
 */
class R_Labor {
    private int numberOfWorkers;

    public R_Labor(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void addWorkers(int additionalWorkers) {
        this.numberOfWorkers += additionalWorkers;
    }
}
