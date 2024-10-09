package uts;

public class Admin extends User {
    public Admin(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    // Admin bisa menambah kamar
    public void addRoom(Hotel hotel, Room room) {
        hotel.addRoom(room);
    }

    // Admin bisa melihat semua pelanggan
    public void viewAllCustomers(Hotel hotel) {
        for (Customer customer : hotel.getCustomers()) {
            customer.displayUserInfo();
        }
    }

    public void generateHotelReport(Hotel hotel) {
        hotel.generateReport();
    }
}
