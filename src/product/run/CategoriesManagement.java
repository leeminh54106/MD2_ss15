package product.run;

import product.entity.Categories;
import product.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    public static List<Categories> listCategories = new ArrayList<>();

    public static void categoriesMenu(Scanner sc) {
        boolean isExist = true;
        do {
            System.out.println("----------------CATEGORIES MENU------------------\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Thoát");
            System.out.println("lua chon cua ban:");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputCategories(sc);
                    break;
                case 2:
                    displayCategories();
                    break;
                case 3:
                    updateCategories(sc);
                    break;
                case 4:
                    deleteCategories(sc);
                    break;
                case 5:
                    statusCategories(sc);
                    break;
                case 6:
                    isExist = false;
                    break;
            }
        } while (isExist);

    }

    private static void updateCategories(Scanner sc) {
        System.out.println("nhap vao ID can cap nhap");
        int idUpdate = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        for(Categories c: listCategories) {
            if(c.getCatalogId() == idUpdate) {
                c.updateCategories(sc);
                isExist = true;
                break;
            }
        }
        if(!isExist) {
            System.err.println("id khong dung");
        }
    }

    private static void deleteCategories(Scanner sc) {
        System.out.println("nhap vao Id danh muc muon xoa:");
        int idCategory = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        Categories categoriesDelete = null;
        for (Categories c : listCategories) {
            if (c.getCatalogId() == idCategory) {
                categoriesDelete = c;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            boolean quit = false;
            for (Product p : ProductManagement.listProduct) {
                if (p.getCatalogId() == idCategory) {
                    quit = true;
                    break;
                }
            }
            if (quit) {
                System.err.println("co ton tai sach");
            } else {
                listCategories.remove(categoriesDelete);
            }
        } else {
            System.err.println("id khong dung");
        }
    }

    private static void statusCategories(Scanner sc) {
        System.out.println("nhap vao id danh muc muon thay doi trang thai:");
        int idCategory = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        for (Categories c : listCategories) {
            if (c.getCatalogId() == idCategory) {
                isExist = true;
                c.setCatalogStatus(!c.getCatalogStatus());
                break;
            }
        }
        if (!isExist) {
            System.err.println("id khong dung");
        }
    }

    private static void displayCategories() {
        if (listCategories.isEmpty()) {
            System.err.println("danh muc trong");
            return;
        }
        System.out.println("tat ca danh muc:");
        for (Categories c : listCategories) {
            c.displayCategories();
        }
    }

    private static void inputCategories(Scanner sc) {
        System.out.println("nhap so luong danh muc muon them");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            Categories newCategory = new Categories();
            newCategory.inputCategories(sc);
            listCategories.add(newCategory);
        }
        System.out.println("them moi thanh cong");
    }

}
