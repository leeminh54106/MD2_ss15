package authorvsbook.run;

import authorvsbook.ra.utils.Color;

import java.util.Scanner;

public class Categories {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            String borderColor = Color.BLUE;
            String bottomColor = borderColor + "╚══════════════════════════════════════════════════╝" + Color.RESET;
            String rowColor = borderColor + "║" + Color.RESET;
            String topColor = borderColor + "╔═════════════════ MENU LIBRARIES ═════════════════╗" + Color.RESET;

            System.out.println(topColor);
            System.out.println(rowColor + "" + borderColor + "     1.Quản lý tác giả\t\t\t\t\t\t\t   " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     2.Quản lý quyển sách\t\t\t\t\t\t   " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     3.Thoát\t\t\t\t\t\t\t\t\t   " + rowColor);
            System.out.println(bottomColor);

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    AuthorMenu.authorMenu(scanner);
                    break;
                case 2:
                    BookMenu.bookMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("1->3");
            }
        } while (true);
    }
}
