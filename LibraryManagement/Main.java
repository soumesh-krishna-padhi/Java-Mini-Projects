import library.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        // Pre-add some sample data
        lib.addBook(new Book("B101", "Java Basics", "James Gosling"));
        lib.addBook(new Book("B102", "OOP Concepts", "Herbert Schildt"));
        lib.addBook(new Book("B103", "Data Structures", "Mark Allen"));

        lib.registerMember(new Member("M001", "Rahul Sharma", "9876543210"));
        lib.registerMember(new Member("M002", "Priya Patel", "9123456789"));

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Display Available Books");
            System.out.println("7. Show Total Books Added");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    lib.registerMember(new Member(mid, name, phone));
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    String bid = sc.nextLine();
                    System.out.print("Member ID: ");
                    String memId = sc.nextLine();
                    lib.issueBook(bid, memId);
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    String rbid = sc.nextLine();
                    System.out.print("Member ID: ");
                    String rmem = sc.nextLine();
                    System.out.print("Days Late: ");
                    int days = sc.nextInt();
                    lib.returnBook(rbid, rmem, days);
                    break;

                case 5:
                    System.out.print("Enter title to search: ");
                    String search = sc.nextLine();
                    lib.searchBook(search);
                    break;

                case 6:
                    lib.displayAvailableBooks();
                    break;

                case 7:
                    Library.showTotalBooks();
                    break;

                case 8:
                    System.out.println("Thank you! Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}