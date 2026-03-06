

class Bus {

    private String serviceNumber;
    private String busName;
    private String source;
    private String destination;
    private double price;
    private int totalSeats;
    private int availableSeats;

    public Bus(String serviceNumber, String busName,
               String source, String destination,
               double price, int totalSeats, int availableSeats) {

        this.serviceNumber = serviceNumber;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getBusName() {
        return busName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int seats) {
        this.availableSeats = seats;
    }

    public void displayBus() {

        System.out.println("--------------------------------------");
        System.out.println("Service Number : " + serviceNumber);
        System.out.println("Bus Name       : " + busName);
        System.out.println("Source         : " + source);
        System.out.println("Destination    : " + destination);
        System.out.println("Price          : " + price);
        System.out.println("Total Seats    : " + totalSeats);
        System.out.println("AvailableSeats : " + availableSeats);
    }

}