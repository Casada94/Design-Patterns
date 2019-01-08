/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: Decorated class to describe the Foodbar Amenity as well as the cost
 * Inputs: N/A
 * Output: Description, and cost of Foodbar with or without optional Refill
 */

public class FoodBarAmenity extends AmenityDecorator {

    private boolean refill; //decides whether refill extra cost is on/off

    /**
     * Default constructor - sets refill option to false
     */
    public FoodBarAmenity(){
        refill = false;
    }

    /**
     * @return string description of the Foodbar amenity
     */
    public String getDescription(){
        return "Foodbar";
    }

    /**
     * @return cost based on if refill option is true/false
     */
    public double cost(){
        if(refill) {
            return 15.00;
        } else {
            return 10.00;
        }
    }

    /**
     * Sets refill option to true
     */
    public void AddRefill() {
        refill = true;
    }

    @Override
    public String toString() {
        return "Food bar amenity and refill is " + refill + " so cost is " + cost();
    }
}
