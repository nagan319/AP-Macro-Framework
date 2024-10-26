package U1.resources;

public class Scarcity {
    
    private static double WANTS_AND_NEEDS = Double.POSITIVE_INFINITY;

    /**
     * The resources of any economy are scarce, since they do not match the
     * infinite wants and needs of a population
     * @param r Resources of an economy
     * @return Whether scarcity is present (always true)
     */
    public static boolean isScarce(Resources r) {
        return WANTS_AND_NEEDS > r.totalAmount();
    }

}
