package uts;

public class Customer extends User {
    private int reservedRoomNumber;

    public Customer(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
        this.reservedRoomNumber = -1;
    }

    public int getReservedRoomNumber() {
        return reservedRoomNumber;
    }

    public void reserve(int roomNumber) {
        this.reservedRoomNumber = roomNumber;
        System.out.println("");
        System.out.println(getName() + " Memesan Kamar " + roomNumber);
    }

    public void cancelReservation() {
        reservedRoomNumber = -1;
        System.out.println(getName() + " Pemesanan Dibatalkan.");
    }
}
