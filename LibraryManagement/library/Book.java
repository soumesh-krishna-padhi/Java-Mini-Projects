package library;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;

    // Default constructor
    public Book() {
        this.bookId = "N/A";
        this.title = "Unknown";
        this.author = "Unknown";
        this.isIssued = false;
    }

    // Parameterized constructor (Constructor Overloading)
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Getters & Setters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void setIssued(boolean issued) { this.isIssued = issued; }

    public void display() {
        System.out.println("ID: " + bookId + " | Title: " + title +
                           " | Author: " + author +
                           " | Status: " + (isIssued ? "Issued" : "Available"));
    }
}