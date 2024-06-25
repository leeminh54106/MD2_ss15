package product.run;

import java.text.ParseException;
import java.util.Scanner;

public class ShopManagement {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------SHOP MENU-----------\n" +
                    "\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát");
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    CategoriesManagement.categoriesMenu(sc);
                    break;
                case 2:
                    ProductManagement.productMenu(sc);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("1 -> 3");
            }
        }while (true);
    }
}
