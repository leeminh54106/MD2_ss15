package student.ra.run;

import java.util.Scanner;

public class Categories {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=========== quan ly hoc vien ==========");
            System.out.println("1. quan ly class");
            System.out.println("2. quan ly student");
            System.out.println("3. thoat");
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ClassManagement.menuClass(sc);
                    break;
                case 2:
                    StudentManagament.menuStudent(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("1 -> 3");
            }
        }while (true);
    }
}
