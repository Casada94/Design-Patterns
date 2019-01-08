/**
 * Bryan, Clayton, Josephine & Oliver
 * December 5, 2018
 * Purpose: This class represents a Subject, that has references to Observers and notifies them
 * Inputs: An object of type Observer
 * Output:
 */

public interface Subject {

    /**
     * @param o - an Observer that gets registered to the Subject
     */
    void registerObserver(Observer o);

    /**
     * @param o - an Observer that gets removed from the Subject
     */
    void removeObserver(Observer o);

    /**
     * Notifies all the Observers bound to this Subject
     */
    void notifyObserver();
}
