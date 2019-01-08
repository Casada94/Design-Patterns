/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class describes a concrete Room of type Suite, with a description and cost
 * Inputs:
 * Output: string description, and cost
 */

public class SuiteRoom extends Room {

    private double cost; //the cost of a Suite Room

    /**
     * Default constructor setting cost to 100
     */
    public SuiteRoom(){
        cost = 100.0;
    }

    /**
     * @return string representation of a Suite Room
     */
    @Override
    public String getDescription() { return "Suite room"; }

    /**
     * @return cost of a Suite Room
     */
    @Override
    public double cost(){
        return cost;
    }

    @Override
    public String toString() {
        return "Suite room with a cost of " + cost;
    }
}
