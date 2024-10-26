package U1.resources;

/**
 * Class to store and modify the quality of entrepreneurship (ability to combine other resources effectively) available in an economic context.
 */
class R_Entrepreneurship {
    private double ability; 

    public R_Entrepreneurship(double ability) {
        this.ability = ability;
    }

    public double getAbility() {
        return ability;
    }

    public void increaseAbility(double additionalAbility) {
        this.ability += additionalAbility;
    }
}
