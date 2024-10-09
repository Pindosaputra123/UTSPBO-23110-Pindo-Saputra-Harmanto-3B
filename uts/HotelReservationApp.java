package uts;

import java.util.Scanner;

public class HotelReservationApp {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi admin
        Admin admin = new Admin("Pindo", "Pindo123", "123456789");

        // Inisialisasi data kamar

        // Loop utama untuk kembali ke menu login setelah exit
        while (true) {
            // Pilihan login sebagai admin atau customer
            System.out.println("\n|===========================================|");
            System.out.println("|    Selamat Datang Di Hotel Unsika Jaya    |");
            System.out.println("|===========================================|");
            System.out.println("| 1 | Login Sebagai Admin                   |");
            System.out.println("| 2 | Login Sebagai Customer                |");
            System.out.println("| 3 | Keluar Dari Program                   |");
            System.out.println("|===========================================|");
            System.out.println("Masukkan Pilihan Anda : ");
            int loginChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (loginChoice == 3) {
                // Keluar dari program secara keseluruhan
                System.out.println("Terima Kasih Telah Tidur Di Hotel Unsika Jaya");
                break;  // Menghentikan loop utama
            }

            User currentUser;
            if (loginChoice == 1) {
                currentUser = admin;  // Login sebagai admin
                displayAdminMenu(scanner, hotel, admin);  // Panggil menu admin
            } else if (loginChoice == 2) {
                // Login sebagai customer
                System.out.print("\nMasukkan Nama    : ");
                String customerName = scanner.nextLine();
                System.out.print("Masukkan Alamat  : ");
                String customerAddress = scanner.nextLine();
                System.out.print("Masukkan No Telp : ");
                String customerPhone = scanner.nextLine();
                Customer customer = new Customer(customerName, customerAddress, customerPhone);
                hotel.addCustomer(customer);
                displayCustomerMenu(scanner, hotel, customer);  // Panggil menu customer
            } else {
                System.out.println("Pilihan Tidak Valid. Tolong Masukkan Pilihan 1 - 3");
            }
        }
        scanner.close();
    }

    // Menampilkan menu untuk Admin
    public static void displayAdminMenu(Scanner scanner, Hotel hotel, Admin admin) {
        while (true) {
            System.out.println("\n|===========================================|");
            System.out.println("|                Menu Admin                 |");
            System.out.println("|===========================================|");
            System.out.println("| 1 | Tambah Kamar                          |");
            System.out.println("| 2 | Cari Kustomer                         |");
            System.out.println("| 3 | Lihat Seluruh Kustomer                |");
            System.out.println("| 4 | Buat Laporan                          |");
            System.out.println("| 5 | Kembali Ke Menu Login                 |");
            System.out.println("|===========================================|");
            System.out.print("Masukkan Pilihan Anda : ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("\nMasukkan Nomor Kamar : ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Masukkan Harga Kamar : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Masukkan Tipe Kamar (Single, Double, Suite) : ");
                    String roomType = scanner.nextLine();

                    Room newRoom = new Room(roomNumber, price, roomType);
                    admin.addRoom(hotel, newRoom);
                    System.out.println("Kamar Berhasil Ditambahkan");
                    break;

                case 2:
                    System.out.print("\nMasukkan Nama Kustomer Untuk Dicari : ");
                    String searchName = scanner.nextLine();
                    for (Customer c : hotel.getCustomers()) {
                        if (c.getName().equalsIgnoreCase(searchName)) {
                            c.displayUserInfo();
                        }
                    }
                    break;

                case 3:
                    admin.viewAllCustomers(hotel);
                    break;

                case 4:
                    admin.generateHotelReport(hotel);
                    break;

                case 5:
                    System.out.println("Kembali Ke Manu Login...");
                    return;  // Kembali ke menu login

                default:
                    System.out.println("Pilihan Tidak Valid. Tolong Masukkan Pilihan 1 - 5");
                    break;
            }
        }
    }

    // Menampilkan menu untuk Customer
    public static void displayCustomerMenu(Scanner scanner, Hotel hotel, Customer customer) {
        while (true) {
            System.out.println("\n|===========================================|");
            System.out.println("|               Menu Kustomer               |");
            System.out.println("|===========================================|");
            System.out.println("| 1 | Memesan Kamar                         |");
            System.out.println("| 2 | Lihat Ketersediaan Kamar              |");
            System.out.println("| 3 | Batalkan Pesanan Kamar                |");
            System.out.println("| 4 | Kembali Ke Menu Login                 |");
            System.out.println("|===========================================|");
            System.out.print("Masukkan Pilihan Anda : ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("\nMasukkan Nomor Kamar : ");
                    int roomNumber = scanner.nextInt();
                    Room room = hotel.getRoomByNumber(roomNumber);
                    if (room != null && room.isAvailable()) {
                        System.out.print("Masukkan Tanggal Check-In (YYYY-MM-DD) : ");
                        scanner.nextLine(); // Consume newline
                        String checkInDate = scanner.nextLine();

                        System.out.print("Masukkan Jumlah Orang : ");
                        int guests = scanner.nextInt();

                        Reservation reservation = new Reservation(customer, room, checkInDate, guests);
                        hotel.addReservation(reservation);
                        reservation.displayReservationDetails();
                    } else {
                        System.out.println("Mohon Maaf Saat Ini Kamar Tidak Tersedia.");
                    }
                    break;

                case 2:
                    hotel.displayAllRooms();
                    break;

                case 3:
                    hotel.cancelReservation(customer);
                    break;

                case 4:
                    System.out.println("Kembali Ke Menu Login...");
                    return;  // Kembali ke menu login

                default:
                    System.out.println("Pilihan Tidak Valid. Tolong Masukkan Pilihan 1 - 4");
                    break;
            }
        }
    }
}
