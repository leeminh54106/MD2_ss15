package authorvsbook.ra.entity;

import authorvsbook.ra.feature.impl.AuthorImpl;
import authorvsbook.ra.utils.Color;

import java.util.Scanner;

public class Author {
    private int authorId;
    private String authorName;
    private String description;
    private int age;
    private boolean status;

    public Author() {
    }

    public Author(int age, int authorId, String authorName, String description, boolean status) {
        this.age = age;
        this.authorId = authorId;
        this.authorName = authorName;
        this.description = description;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputAuthor(Scanner scanner) {
        this.authorId = inputAuthorId();
        this.authorName = inputAuthorName(scanner);
        this.description = inputDescription(scanner);
        this.age = inputAge(scanner);
        this.status = inputStatus(scanner);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("1.con xuat ban/2.ko con xuat ban");
        do {
            int status = Integer.parseInt(scanner.nextLine());
            if (status == 1 || status == 2) {
                if (status == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.err.println(" 1 or 2");
            }
        } while (true);
    }

    public int inputAge(Scanner scanner) {
        System.out.println("nhap tuoi:");
        do {
            String age = scanner.nextLine();
            if (age.trim().isEmpty()) {
                System.err.println("ko duoc de trong");
            } else if (Integer.parseInt(age) < 18) {
                System.err.println(" > 18");
            } else {
                return Integer.parseInt(age);
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("nhap mo ta:");
        return scanner.nextLine();
    }

    public String inputAuthorName(Scanner scanner) {
        System.out.println("nhap ten tac gia: ");
        do {
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.err.println("ko duoc de trong");
            } else {
                return name;
            }
        } while (true);
    }

    public int inputAuthorId() {
        int max = 0;
        for (Author a : AuthorImpl.authors) {
            if (a.getAuthorId() > max) {
                max = a.getAuthorId();

            }
        }
        return max + 1;
    }

    public void displayAuthor() {
        System.out.printf(Color.CYAN+"Id: %d, Name: %s, Description: %s, Age: %d, Status: %s\n",
                this.authorId, this.authorName, this.description, this.age, this.status ? "con xuat ban" : "khong xuat ban");
    }
}
