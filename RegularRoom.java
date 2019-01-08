/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class describes a concrete Room of type Regular, with a description and cost
 * Inputs: N/A
 * Output: String description, and cost
 */

public class RegularRoom extends Room {

    private double cost; //the cost of a Regular Room

    /**
     * Default constructor setting cost to 50
     */
    public RegularRoom(){
        cost = 50.0;
    }

    /**
     * @return string representation of a Regular Room
     */
    @Override
    public String getDescription() {
        return "Regular room";
    }

    /**
     * @return cost of a Regular Room
     */
    @Override
    public double cost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Regular room with a cost of " + cost;
    }
}
