package uts;

public class User {
    private String name;
    private String address;
    private String phoneNumber;

    public User(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void displayUserInfo() {
        System.out.println("\nNama : " + name);
        System.out.println("Alamat : " + address);
        System.out.println("No Telp : " + phoneNumber);
    }
}
