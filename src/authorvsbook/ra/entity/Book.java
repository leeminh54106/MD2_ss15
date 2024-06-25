package authorvsbook.ra.entity;

import authorvsbook.ra.feature.impl.AuthorImpl;
import authorvsbook.ra.feature.impl.BookImpl;
import authorvsbook.ra.utils.Color;

import java.util.Date;
import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double price;
    private Date created;
    private Author author;
    private byte status;

    public Book() {
    }

    public Book(Author author, String bookId, String bookName, Date created, double price, byte status) {
        this.author = author;
        this.bookId = bookId;
        this.bookName = bookName;
        this.created = created;
        this.price = price;
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte isStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public void inputBook(Scanner scanner) {
        this.bookId = autoBookId();
        this.bookName = inputBookName(scanner);
        this.price = inputPrice(scanner);
        this.created = new Date();
        this.author = inputAuthor(scanner);
        this.status = inputStatus(scanner);
    }

    public byte inputStatus(Scanner scanner) {
        System.out.println("1.dang ban/2.het hang/3.ko ban");
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice < 4) {
                return Byte.parseByte(String.valueOf(choice));
            } else {
                System.err.println("1 -> 3");
            }
        } while (true);
    }

    public Author inputAuthor(Scanner scanner) {
        for (Author a : AuthorImpl.authors) {
            System.out.printf("ID: %d, Name: %s \n", a.getAuthorId(), a.getAuthorName());
        }
        System.out.println("nhap Id tac gia:");
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            int authorId = findAuthorIndexById(choice);
            if (authorId >= 0) {
                return AuthorImpl.authors.get(authorId);
            } else {
                System.err.println("ID ko dung");
            }
        } while (true);
    }

    public int findAuthorIndexById(int authorId) {
        for (int i = 0; i < AuthorImpl.authors.size(); i++) {
            if (AuthorImpl.authors.get(i).getAuthorId() == authorId) {
                return i;
            }
        }
        return -1;
    }

    public double inputPrice(Scanner scanner) {
        System.out.println("gia sach:");
        do {
            String price = scanner.nextLine();
            if (price.trim().isEmpty()) {
                System.err.println("ko duoc de trong");
            } else if (Integer.parseInt(price) < 0) {
                System.err.println(" > 0");
            } else {
                return Double.parseDouble(price);
            }
        } while (true);
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("nhap ten sach:");
        do {
            String bookName = scanner.nextLine();
            if (bookName.trim().isEmpty()) {
                System.err.println("ko duoc de trong");
            } else {
                boolean isExit = true;
                for (Book b : BookImpl.books) {
                    if (b.getBookName().equals(bookName)) {
                        isExit = false;
                    }
                }
                if (!isExit) {
                    System.err.println("da ton tai");
                } else {
                    return bookName;
                }

            }
        } while (true);
    }

    public String autoBookId() {
        String result = "B";
        int max = 0;
        for (Book b : BookImpl.books) {
            String bookId = b.getBookId();
            int number = Integer.parseInt(bookId.replaceAll("B", "0"));
            if (number > max) {
                max = number;
            }
        }
        result += String.format("%03d", max + 1);
        return result;
    }

    public void displayBook() {
        System.out.printf(Color.BLUE + "Id: %s, Name: %s, Price: %.2f, Date: %s, Author: %s, Status: %b \n",
                this.bookId, this.bookName, this.price, this.created, this.author.getAuthorName(),
                this.status == 0 ? "dang ban" : this.status == 1 ? "het hang" : "ko ban");
    }
}
