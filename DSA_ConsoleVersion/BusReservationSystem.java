

import java.util.*;

public class BusReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Bus> busList = FileManager.loadBuses();
    static LinkedList<Booking> bookingList = new LinkedList<>();

    static WaitingList waitingList = new WaitingList();

    static int bookingCounter = 1;

    public static void main(String[] args) {

        while(true){

            System.out.println("\n===== BUS RESERVATION SYSTEM =====");
            System.out.println("1 Admin Login");
            System.out.println("2 Passenger Login");
            System.out.println("3 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    adminLogin();
                    break;

                case 2:
                    passengerMenu();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }

        }

    }

    // ADMIN LOGIN
    static void adminLogin(){

        System.out.print("Enter admin username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(user.equals("admin") && pass.equals("admin123")){
            adminMenu();
        }
        else{
            System.out.println("Invalid admin credentials.");
        }

    }

    // ADMIN MENU
    static void adminMenu(){

        while(true){

            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1 Add Bus");
            System.out.println("2 View Buses");
            System.out.println("3 View Waiting List");
            System.out.println("4 Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    addBus();
                    break;

                case 2:
                    viewBuses();
                    break;

                case 3:
                    waitingList.viewWaitingList();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid option");

            }

        }

    }

    // PASSENGER MENU
    static void passengerMenu(){

        while(true){

            System.out.println("\n----- PASSENGER MENU -----");
            System.out.println("1 View Buses");
            System.out.println("2 Book Ticket");
            System.out.println("3 Cancel Ticket");
            System.out.println("4 Track Bus");
            System.out.println("5 Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    viewBuses();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelTicket();
                    break;

                case 4:
                    trackBus();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid option");

            }

        }

    }

    // ADD BUS
    static void addBus(){

        System.out.print("Service Number: ");
        String serviceNumber = sc.nextLine();

        System.out.print("Bus Name: ");
        String name = sc.nextLine();

        System.out.print("Source: ");
        String source = sc.nextLine();

        System.out.print("Destination: ");
        String destination = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Total Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        Bus bus = new Bus(serviceNumber,name,source,destination,price,seats,seats);

        busList.add(bus);

        FileManager.saveBuses(busList);

        System.out.println("Bus added successfully!");

    }

    // VIEW BUSES
    static void viewBuses(){

        if(busList.isEmpty()){
            System.out.println("No buses available.");
            return;
        }

        for(Bus bus : busList){
            bus.displayBus();
        }

    }

    // BOOK TICKET
    static void bookTicket(){

        viewBuses();

        System.out.print("Enter Service Number: ");
        String service = sc.nextLine();

        Bus selectedBus = null;

        for(Bus bus : busList){
            if(bus.getServiceNumber().equals(service)){
                selectedBus = bus;
                break;
            }
        }

        if(selectedBus == null){
            System.out.println("Bus not found.");
            return;
        }

        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Number of seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        if(seats > selectedBus.getAvailableSeats()){

            System.out.println("Seats full! Added to waiting list.");
            waitingList.addPassenger(name);
            return;

        }

        selectedBus.setAvailableSeats(selectedBus.getAvailableSeats() - seats);

        String bookingId = "B" + bookingCounter++;

        double totalPrice = seats * selectedBus.getPrice();

        Booking booking = new Booking(bookingId,name,service,seats,totalPrice);

        bookingList.add(booking);

        FileManager.saveBooking(booking);
        FileManager.saveBuses(busList);

        System.out.println("Ticket booked successfully!");
        booking.displayBooking();

    }

    // CANCEL TICKET
    static void cancelTicket(){

        System.out.print("Enter Booking ID: ");
        String id = sc.nextLine();

        Booking found = null;

        for(Booking b : bookingList){
            if(b.getBookingId().equals(id)){
                found = b;
                break;
            }
        }

        if(found == null){
            System.out.println("Booking not found.");
            return;
        }

        for(Bus bus : busList){
            if(bus.getServiceNumber().equals(found.getServiceNumber())){
                bus.setAvailableSeats(
                        bus.getAvailableSeats() + found.getSeatsBooked()
                );
            }
        }

        bookingList.remove(found);

        System.out.println("Ticket cancelled.");

    }

    // TRACK BUS
    static void trackBus(){

        System.out.println("Bus is currently travelling...");
        System.out.println("Estimated arrival: 2 hours");

    }

}