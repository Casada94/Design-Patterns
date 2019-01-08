/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class is the RoachMotel and our implementation on the Singleton design pattern.
 * Inputs: Keeps track of the RoachMotel and a map of the rooms and its vacancy and waitlist.
 * Output: toString to show rooms.
 */

import java.util.*;

public class RoachMotel implements Subject{

    private static RoachMotel RM;
    private Map<Room, Boolean> RM_map;
    private boolean vacancy;
    private ArrayList<Observer> waitList;

    /**
     * Private constructor to ensure only one instance (singleton)
     */
    private RoachMotel(){
        vacancy = true;
        waitList = new ArrayList<>();
        RM_map = new HashMap<Room,Boolean>();
    }

    /**
     *
     * @return the only Roach Motel instance
     */
    public static RoachMotel getInstance(){
        if(RM == null){
            RM = new RoachMotel();
        }
        return RM;
    }

    /**
     * Vacancy sign
     */
    public void vacancy(){
        vacancy = true;
    }

    /**
     * NoVacancy sign
     */
    public void noVacancy(){vacancy = false;}

    /**
     * Creating rooms and places them in the HashMap as a Regular room and vacant as a standard
     * @param numberOfRooms - takes the wished number of rooms for the Roach Motel
     */
    public void createRooms(int numberOfRooms){
        for (int i = 0; i<numberOfRooms; i++) {
            RM_map.put(new RegularRoom(), true);
        }

    }

    /**
     * Registers observers (for the wait list)
     * @param o - takes an observer (Roach colony)
     */
    @Override
    public void registerObserver(Observer o) {
        waitList.add(o);
    }

    /**
     * Removes observers (from the wait list)
     * @param o - takes an observer (Roach colony)
     */
    @Override
    public void removeObserver(Observer o) {

        int i = waitList.indexOf(o);
        if (i >=0 ){
            waitList.remove(i);
        }
    }

    /**
     * Notifies observers on the wait list
     */
    @Override
    public void notifyObserver() {
        for (Observer o : waitList){
            o.update();
        }
    }

    /**
     * Check in method
     * @param rc - The particular roach colony
     * @param roomType - The wished room type
     * @param foodBar - if wanted (true/false)
     * @param foodbarAndRefill - if wanted (true/false)
     * @param spa - if wanted (true/false)
     * @param shower - if wanted (true/false)
     */
    public void checkIn(RoachColony rc, String roomType, boolean foodBar, boolean foodbarAndRefill, boolean spa, boolean shower){

        int nonVacantRooms = 0;
        Room room;

        //Checks for a vacant room and removes it from the Hash map
        for(Room key : RM_map.keySet()) {
            if(RM_map.get(key)) {
                RM_map.remove(key);
                break;
            } else {
                nonVacantRooms++;
            }
        }

        //If there are no more vacant rooms, it prints a message
        //Otherwise the room is saved in the map again as the wished room type and with the wished amenities
        if(nonVacantRooms == RM_map.size()) {
            System.out.println(rc.getName() + " is trying to check in but there is no more vacant rooms\n" + rc.getName() + " is added to the waitlist");
            noVacancy();
            registerObserver(rc);

        } else {

            room = RoomFactory.createRoom(roomType);

            //If foodBar refill is chosen, then the room is added a foodbar with refill is added
            if((foodBar && foodbarAndRefill) || foodbarAndRefill) {
                FoodBarAmenity f = new FoodBarAmenity();
                f.AddRefill();
                room.addAmenity(f);
            } else if(foodBar) {                //Else the foodbar is added, only
                room.addAmenity(new FoodBarAmenity());
            }

            if (spa){
                room.addAmenity(new SpaAmenity());
            }

            if (shower){
                room.addAmenity(new SprayResistantShowerAmenity());
            }

            //The room is added and vacancy is now false
            RM_map.put(room, false);

            //The roach colony sets the room
            rc.setRoom(room);

            System.out.println(rc.getName() + " checked in to a " + room + " with the following amenities " + room.getAmenities());
            System.out.println("Cost per night for this room is " + room.cost() + " and cost of amenities per night is " + room.getAmenityCost() + " so total cost per night is " + (room.cost() + room.getAmenityCost()));

            //after colony has checked in, check if there is still available rooms
            int count = 0;
            for(Room key : RM_map.keySet()) {
                if(!RM_map.get(key)) {
                    count++;
                }
            }

            if(count == RM_map.size()) {
                noVacancy();
            }
        }
    }

    /**
     * Check out method
     * @param colony - Takes the particular roach colony
     * @param days - Takes the amount of days the roach colony has stayed in the motel
     */
    public void checkOut(RoachColony colony, int days){

        System.out.println(colony + " is checking out:");

        //Retrieves the particular and saves it as vacant
        Room colonyRoom = colony.getRoom();
        RM_map.put(colonyRoom, true);

        //Calculates the the cost of the room and amenities times the number of days
        double cost = (colonyRoom.cost() + colonyRoom.getAmenityCost()) * days;

        System.out.println("The total price for the room is: (room cost " + colonyRoom.cost() + " + amenities cost " + colonyRoom.getAmenityCost() + ") * days " + days + " = $" + cost + ". \nThe Colony has been checked out now. ");

        if(vacancy == false) {
            vacancy();
            notifyObserver();
            waitList.clear();
            System.out.println("The wait list has been cleared.");
        }




    }


    public void sprayParty(RoachColony colony) {
        System.out.println("Hotel sprays with insecticide");

        //get amenities from the room of the colony
        Set<AmenityDecorator> amenities = colony.getRoom().getAmenities();

        //loop through amenities
        for(AmenityDecorator a : amenities) {
            //if amenities contains an instance of Spray Resistant Shower
            if(a instanceof SprayResistantShowerAmenity) {
                System.out.println("Room has Spray Resistant Shower - colony is reduced by 25%");

                //reduce population by 25%, round up because roaches lives even if they are in pieces
                colony.setPopulation((int) Math.ceil(colony.getPopulation() * 0.75));

                return;
            }
        }

        System.out.println("No Spray Resistant Shower - colony is reduced by 50%");
        //if there is no Spray Resistant Shower - reduce colony by 50%
        colony.setPopulation((int) Math.ceil(colony.getPopulation() * 0.5));
    }


    @Override
    public String toString() {
        String str = "Welcome to the roach motel!";

        if(vacancy) {
            str += "\nVacancy! The following rooms are available: \n";
            for(Room room : RM_map.keySet()) {
                if (RM_map.get(room) == true){

                    str += room + "\n";
                }
            }
            str += "Room changes are available at check-in";
        } else {
            str += "\nNo Vacancy! The waitlist for a room is: " + waitList;
        }
        return str;
    }
}
