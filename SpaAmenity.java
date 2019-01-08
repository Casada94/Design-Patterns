/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: Decorated class to describe the Spa Amenity as well as the cost
 * Inputs:
 * Output: description, and cost of Spa
 */

public class SpaAmenity extends AmenityDecorator {

    /**
     * Default constructor - no body
     */
    public SpaAmenity(){}

    /**
     * @return String description of Spa
     */
    public String getDescription(){
        return "Spa";
    }

    /**
     * @return cost of Spa
     */
    public double cost(){
        return 20.00;
    }

    @Override
    public String toString() {
        return "Spa amenity with a cost of " + cost();
    }
}

