/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class represents a Roach Colony with a name, population, growth rate, and can check in to a Motel. Roach Colony is an Observer to Subject (Motel)
 * Inputs: Name of colony, initial population, growthrate, and a motel as a Subject
 * Output: Name, population, and growthrate, and which room in motel is has checked in to
 */
public class RoachColony implements Observer {

    private String name; //name of colony
    private int population; //population count
    private double growthRate; //rate of growth
    private Subject motel; //motel as a Subject for the Observer
    private Room room; //room currently checked in to

    /**
     * Default constructor - sets instance variables to parameter variables
     * @param name
     * @param population
     * @param growthRate
     * @param motel
     */
    public RoachColony(String name, int population, double growthRate, Subject motel){
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
        this.motel = motel;
    }

    //GETTERS

    /**
     * @return name of colony
     */
    public String getName() { return name; }

    /**
     * @return current population
     */
    public int getPopulation() { return population; }

    /**
     * @return the growth rate
     */
    public double getGrowthRate() { return growthRate; }

    /**
     * @return current room checked in to
     */
    public Room getRoom() { return room; }


    //SETTERS

    /**
     * @param population - change the population count
     */
    public void setPopulation(int population) { this.population = population; }

    /**
     * @param room sets the current room
     */
    public void setRoom(Room room) { this.room = room; }

    /**
     * When a colony throws a party the population increases
     * The Motel then sprays the party reducing the population based on whether the room has a Spray Resistant Shower
     */
    public void throwParty() {
        System.out.println(name + " throws a PARTY!!!!");
        System.out.println("Population increases:"); //print out current population count

        System.out.print("population " + population + " * growth rate " + growthRate + " = ");
        population = (int) Math.ceil(population * growthRate); //increase population by growth factor
        System.out.println(population);
        System.out.println("Result is rounded up, because roaches lives even if they are in pieces");

        ((RoachMotel) motel).sprayParty(this); //call sprayParty method in RoachMotel class

        System.out.println("After being sprayed, population is reduced to " + population); //print current population
    }

    /**
     * Update the Observer (this) by calling display method
     */
    @Override
    public void update() {
        display();
    }

    /**
     * Print that colony has received notification
     */
    public void display(){
        System.out.println("The Roach Colony " + name + " has received a notification of vacancy.");
    }

    /**
     * @return A string representation of the current state of the colony
     */
    @Override
    public String toString() {
        return "Roach Colony " + name + ", with a population of " + population + " and a growth rate of " + growthRate;
    }
}

