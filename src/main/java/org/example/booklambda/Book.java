package org.example.booklambda;

public class Book {
    private int bookId;
    private String bname;
    private double price;

    public int getBookId() {
        return bookId;
    }

    public String getBname() {
        return bname;
    }

    public double getPrice() {
        return price;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Book(int bookId, String bname, double price) {
        this.bookId = bookId;
        this.bname = bname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                '}';
    }
}

