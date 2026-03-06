

import java.util.*;

class WaitingList {

    private Queue<String> waitingQueue = new LinkedList<>();

    // Add passenger to waiting list
    public void addPassenger(String passengerName){

        waitingQueue.add(passengerName);
        System.out.println(passengerName + " added to waiting list.");

    }

    // Remove passenger when seat becomes available
    public String getNextPassenger(){

        if(waitingQueue.isEmpty()){
            return null;
        }

        return waitingQueue.poll();
    }

    // View waiting list
    public void viewWaitingList(){

        if(waitingQueue.isEmpty()){
            System.out.println("Waiting list is empty.");
            return;
        }

        System.out.println("----- Waiting List -----");

        for(String passenger : waitingQueue){
            System.out.println(passenger);
        }

    }

}