

class Booking {

    private String bookingId;
    private String passengerName;
    private String serviceNumber;
    private int seatsBooked;
    private double totalPrice;

    public Booking(String bookingId, String passengerName,
                   String serviceNumber, int seatsBooked, double totalPrice) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.serviceNumber = serviceNumber;
        this.seatsBooked = seatsBooked;
        this.totalPrice = totalPrice;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void displayBooking() {

        System.out.println("=====================================");
        System.out.println("Booking ID      : " + bookingId);
        System.out.println("Passenger Name  : " + passengerName);
        System.out.println("Service Number  : " + serviceNumber);
        System.out.println("Seats Booked    : " + seatsBooked);
        System.out.println("Total Price     : " + totalPrice);
        System.out.println("=====================================");

    }

}