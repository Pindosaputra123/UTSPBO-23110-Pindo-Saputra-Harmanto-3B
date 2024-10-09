package uts;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (roomNumber == room.getRoomNumber()) {
                return room;
            }
        }
        return null;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void displayAllRooms() {
        boolean allRoomsReserved = true;  // Anggap semua kamar sudah dipesan
        
        // Iterasi semua kamar
        for (Room room : rooms) {
            room.displayRoomDetails();  // Tampilkan detail kamar
            
            // Jika ada kamar yang masih tersedia, set allRoomsReserved menjadi false
            if (room.isAvailable()) {
                allRoomsReserved = false;
            }
        }
        
        // Jika semua kamar sudah terisi
        if (allRoomsReserved) {
            System.out.println("Tidak Ada Kamar Yang Kosong Saat Ini");
        }
    }
    

    public void generateReport() {
        double totalRevenue = 0;
        System.out.println("\nLaporan Pemesanan : ");
        for (Reservation reservation : reservations) {
            reservation.displayReservationDetails();
            totalRevenue += reservation.getRoomPrice();
        }
        System.out.println("Total Pendapatan : Rp." + totalRevenue);
    }

    public void cancelReservation(Customer customer) {
        int reservedRoomNumber = customer.getReservedRoomNumber();
        if (reservedRoomNumber != -1) {
            Room room = getRoomByNumber(reservedRoomNumber);
            if (room != null) {
                room.cancelReservation();
                customer.cancelReservation();
            }
        } else {
            System.out.println("Maaf, Saat Ini Anda Belom Melakukan Pemesanan Kamar.");
        }
    }
}
