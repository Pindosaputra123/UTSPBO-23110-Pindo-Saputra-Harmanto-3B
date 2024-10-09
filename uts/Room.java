package uts;

public class Room implements Reservable {
    private int roomNumber;
    private boolean isAvailable;
    private double price;
    private String roomType;

    public Room(int roomNumber, double price, String roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void reserve() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Kamar " + roomNumber + " Berhasil Dipesan");
        } else {
            System.out.println("Kamar " + roomNumber + " Sudah Dipesan");
        }
    }

    @Override
    public void cancelReservation() {
        isAvailable = true;
        System.out.println("Kamar " + roomNumber + " Sekarang Tersedia");
    }

    public void displayRoomDetails() {
        System.out.println("No Kamar : " + roomNumber + ", Tipe : " + roomType + ", Harga : Rp" + price + ", Tersedia : " + isAvailable);
    }

    // Tambahkan getter untuk roomNumber
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }
}
