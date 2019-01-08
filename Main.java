/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: It's our main class and tester to test functionality of all our classes. Everything
 * hard coded and is a simulation of our Roach-Motel.
 * Inputs: N/A 
 * Output: Sample output to show functionaility of our Roach-Motel named "The Roach 911"
*/

public class Main {
    public static void main(String[] args){

        System.out.println("Create a new Roach Motel with 5 rooms");
        System.out.println();

        RoachMotel TheRoach911 = RoachMotel.getInstance();

        TheRoach911.createRooms(5);
        System.out.println(TheRoach911);
        System.out.println();

        System.out.println();
        System.out.println("Create 6 roach colonies and try to check them in");
        System.out.println();

        RoachColony r1 = new RoachColony("Nielsen",2,1.0,TheRoach911);
        RoachColony r2 = new RoachColony("Hansen",3,1.2,TheRoach911);
        RoachColony r3 = new RoachColony("Skywalker",4,1.3,TheRoach911);
        RoachColony r4 = new RoachColony("Gremlins",2,2.0,TheRoach911);
        RoachColony r5 = new RoachColony("Jensen",10,0.8,TheRoach911);
        RoachColony r6 = new RoachColony("Vader",5,1.0,TheRoach911);

        TheRoach911.notifyObserver();

        TheRoach911.checkIn(r1,"deluxe", true, false, true, true);
        System.out.println();
        TheRoach911.checkIn(r2,"regular", false, false, false, false);
        System.out.println();
        TheRoach911.checkIn(r3,"suite", true, true, false, false);
        System.out.println();
        TheRoach911.checkIn(r4,"deluxe", false, true, true, true);
        System.out.println();
        TheRoach911.checkIn(r5,"suite", false, false, false, true);
        System.out.println();
        TheRoach911.checkIn(r6,"regular", true, true, true, true);

        System.out.println();
        
        System.out.println(TheRoach911);

        System.out.println();
        System.out.println("Time to check out!");
        TheRoach911.checkOut(r1, 3);

        System.out.println();
        System.out.println(TheRoach911);
        System.out.println();

        TheRoach911.checkIn(r6, "suite", true, false, true, false);
        System.out.println();

        System.out.println(TheRoach911);
        System.out.println();

        RoachColony r7 = new RoachColony("Andersen", 2, 4.0, TheRoach911);
        System.out.println(r7);
        TheRoach911.checkIn(r7, "deluxe", true, true, false, false);
        System.out.println();

        RoachColony r8 = new RoachColony("The Olympic Roach Team", 15, 3.6, TheRoach911);
        System.out.println(r8);
        TheRoach911.checkIn(r8, "suite", true, true, true, true);
        System.out.println();

        RoachColony r9 = new RoachColony("Rock'n'Roach Punk Band", 5, 0.2, TheRoach911);
        System.out.println(r9);
        TheRoach911.checkIn(r9, "suite", true, false, true, false);
        System.out.println();

        System.out.println(TheRoach911);
        System.out.println();

        TheRoach911.checkOut(r6, 9);
        System.out.println();

        r2.throwParty();
        System.out.println();
        r5.throwParty();
        System.out.println();
    }
}
