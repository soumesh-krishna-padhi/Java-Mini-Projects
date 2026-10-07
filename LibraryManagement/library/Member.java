package library;

public class Member {
    private String memberId;
    private String name;
    private String phone;

    // Default constructor
    public Member() {
        this.memberId = "N/A";
        this.name = "Guest";
        this.phone = "0000000000";
    }

    // Parameterized constructor (Constructor Overloading)
    public Member(String memberId, String name, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    public void display() {
        System.out.println("Member ID: " + memberId + " | Name: " + name + " | Phone: " + phone);
    }
}