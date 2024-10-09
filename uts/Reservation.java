package uts;

public class Reservation implements Reservable {
    private Customer customer;
    private Room room;
    private String checkInDate;
    private int numberOfGuests;

    public Reservation(Customer customer, Room room, String checkInDate, int numberOfGuests) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.numberOfGuests = numberOfGuests;
        reserve();
    }

    @Override
    public void reserve() {
        room.reserve();
        customer.reserve(room.getRoomNumber()); // Tidak error lagi
    }

    @Override
    public void cancelReservation() {
        room.cancelReservation();
        customer.cancelReservation();
    }

    public void displayReservationDetails() {
        System.out.println("Kustomer : " + customer.getName());
        System.out.println("Kamar : " + room.getRoomNumber() + ", Tipe : " + room.getRoomType());
        System.out.println("Tanggal Check-In : " + checkInDate);
        System.out.println("Jumlah Orang : " + numberOfGuests);
    }

    public double getRoomPrice() {
        return room.getPrice();
    }
}
