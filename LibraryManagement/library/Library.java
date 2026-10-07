package library;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private FineCalculator fineCalculator = new SimpleFineCalculator();

    // Static member
    private static int totalBooksAdded = 0;

    // Inner Class
    class Transaction {
        String bookId;
        String memberId;
        int daysLate;

        Transaction(String bookId, String memberId, int daysLate) {
            this.bookId = bookId;
            this.memberId = memberId;
            this.daysLate = daysLate;
        }

        void showFine() {
            double fine = fineCalculator.calculateFine(daysLate);
            System.out.println("Fine for Book " + bookId + " (Member " + memberId + "): ₹" + fine);
        }
    }

    // ========== FEATURES ==========

    public void addBook(Book book) {
        books.add(book);
        totalBooksAdded++;
        System.out.println("Book added successfully!");
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully!");
    }

    public void issueBook(String bookId, String memberId) {
        for (Book b : books) {
            if (b.getBookId().equals(bookId)) {
                if (!b.isIssued()) {
                    b.setIssued(true);
                    System.out.println("Book issued to Member " + memberId);
                    return;
                } else {
                    System.out.println("Book is already issued!");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(String bookId, String memberId, int daysLate) {
        for (Book b : books) {
            if (b.getBookId().equals(bookId) && b.isIssued()) {
                b.setIssued(false);
                System.out.println("Book returned successfully.");

                // Using Inner Class
                Transaction t = new Transaction(bookId, memberId, daysLate);
                t.showFine();
                return;
            }
        }
        System.out.println("Book not found or not issued!");
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("No book found with that title.");
    }

    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean any = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                b.display();
                any = true;
            }
        }
        if (!any) System.out.println("No available books.");
    }

    public static void showTotalBooks() {
        System.out.println("Total books ever added: " + totalBooksAdded);
    }
}