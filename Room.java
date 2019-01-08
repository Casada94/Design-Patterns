/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class describes a generic Room, with a description, cost, set of amenities and cost of amenities
 * Inputs: AmenityDecorator to add to the set of amenities
 * Output: string description, cost with and without amenities, and the set of amenities
 */

import java.util.HashSet;
import java.util.Set;



public abstract class Room {

    private Set<AmenityDecorator> amenities; //set of amenities because there should be no duplicates

    /**
     * Default constructor - creates a HashSet of amenities because order is not important
     */
    public Room(){
        amenities = new HashSet<>();
    }

    /**
     * @return string description of a room
     */
    public abstract String getDescription();

    /**
     * @return cost of a room
     */
    public abstract double cost();

    /**
     * Adds an amenity to the HashSet
     * @param ad - AmenityDecorator
     */
    public void addAmenity(AmenityDecorator ad){ amenities.add(ad); }

    /**
     * @return cost - sum of all amenities for this room
     */
    public double getAmenityCost() {
        Double cost = 0.0;
        for(AmenityDecorator amenity : amenities) { cost += amenity.cost(); }
        return cost;
    }

    /**
     * @return Set - the HashSet of amenities
     */
    public Set<AmenityDecorator> getAmenities() { return amenities; }

    /**
     * @return string representation of this class with name and set of amenities
     */
    @Override
    public String toString() {
        String str = "This is a " + getDescription() + " with the following amenities: ";
        for (AmenityDecorator ad : amenities){ str += ad.getDescription() + ", ";}
        return str;
    }
}
