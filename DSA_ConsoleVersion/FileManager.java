

import java.io.*;
import java.util.*;

class FileManager {

    // Load buses from buses.txt
    public static ArrayList<Bus> loadBuses(){

        ArrayList<Bus> busList = new ArrayList<>();

        try{

            File file = new File("buses.txt");

            if(!file.exists()){
                file.createNewFile();
            }

            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){

                String line = sc.nextLine();

                String[] data = line.split(",");

                String serviceNumber = data[0];
                String busName = data[1];
                String source = data[2];
                String destination = data[3];
                double price = Double.parseDouble(data[4]);
                int totalSeats = Integer.parseInt(data[5]);
                int availableSeats = Integer.parseInt(data[6]);

                Bus bus = new Bus(serviceNumber, busName,
                        source, destination, price,
                        totalSeats, availableSeats);

                busList.add(bus);

            }

            sc.close();

        }
        catch(Exception e){
            System.out.println("Error loading buses.");
        }

        return busList;
    }


    // Save buses to buses.txt
    public static void saveBuses(ArrayList<Bus> busList){

        try{

            PrintWriter writer = new PrintWriter("buses.txt");

            for(Bus bus : busList){

                writer.println(
                        bus.getServiceNumber() + "," +
                        bus.getBusName() + "," +
                        bus.getSource() + "," +
                        bus.getDestination() + "," +
                        bus.getPrice() + "," +
                        bus.getTotalSeats() + "," +
                        bus.getAvailableSeats()
                );

            }

            writer.close();

        }
        catch(Exception e){
            System.out.println("Error saving buses.");
        }

    }


    // Save booking to bookings.txt
    public static void saveBooking(Booking booking){

        try{

            FileWriter fw = new FileWriter("bookings.txt", true);

            fw.write(
                    booking.getBookingId() + "," +
                    booking.getPassengerName() + "," +
                    booking.getServiceNumber() + "," +
                    booking.getSeatsBooked() + "," +
                    booking.getTotalPrice() + "\n"
            );

            fw.close();

        }
        catch(Exception e){
            System.out.println("Error saving booking.");
        }

    }

}