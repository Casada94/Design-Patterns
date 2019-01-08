/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: Handle the instantiation of different types of Rooms
 * Inputs: String representing the roomtype
 * Output: A concrete instance of Room
 */

public class RoomFactory {

    /**
     * Based on the input roomtype, it returns a concrete Room
     * @param type - the type of Room as a string
     * @return an instance of a concrete Room
     */
    public static Room createRoom(String type){

        Room room = null;

        if(type.equals("regular")) {       room = new RegularRoom();
        } else if(type.equals("deluxe")) { room = new DeluxeRoom();
        } else if(type.equals("suite")) {  room = new SuiteRoom();
        }
        return room;
    }
}
