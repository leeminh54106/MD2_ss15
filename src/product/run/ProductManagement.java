package product.run;

import product.entity.Product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static List<Product> listProduct = new ArrayList<>();
    public static void productMenu(Scanner scanner) throws ParseException {
        boolean quit = true;
        do{
            System.out.println("---------------PRODUCT MANAGEMENT----------------\n" +
                    "\n" +
                    "1.Nhập thông tin các sản phẩm\n" +
                    "2.Hiển thị thông tin các sản phẩm\n" +
                    "3.Sắp xếp các sản phẩm theo giá\n" +
                    "4.Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5.Xóa sản phẩm theo mã sản phẩm\n" +
                    "6.Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7.Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)\n" +
                    "8.Thoát (lưu ý: Khi chọn 8, quay lại menu SHOP MANAGEMENT)\n");
            System.out.println("nhap lua chon cua ban");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputProduct(scanner);
                    break;
                case 2:
                    displayProduct(scanner);
                    break;
                case 3:
                    sortByPrice(scanner);
                    break;
                case 4:
                    updateProduct(scanner);
                    break;
                case 5:
                    deleteProduct(scanner);
                    break;
                case 6:
                    searchByName(scanner);
                    break;
                case 7:
                    SearchByPrice(scanner);
                    break;
                case 8:
                    quit = false;
                    break;
                default:
                    System.err.println("1 -> 8");
            }
        }while (quit);
    }

    private static void SearchByPrice(Scanner scanner) {
        System.out.println("start price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("end price");
        int price2 = Integer.parseInt(scanner.nextLine());
        for (Product product : listProduct) {
            if (product.getPrice() >= price && product.getPrice() <= price2) {
                product.displayProduct();
            }
        }
    }

    private static void searchByName(Scanner scanner) {
        System.out.println("nhap ten san pham");
        String name = scanner.nextLine();
        boolean quit = false;
        for (Product p : listProduct) {
            if(p.getProductName().toLowerCase().contains(name.toLowerCase())) {
                p.displayProduct();
                quit = true;
                break;
            }
        }
        if(!quit) {
            System.err.println("ko tim thay ten san pham");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.println("nhap vao ma san pham muon xoa");
        String productId = scanner.nextLine();
        boolean quit = false;
        for (Product p : listProduct) {
            if(p.getProductid().equals(productId)){
                listProduct.remove(p);
                quit = true;
                break;
            }
        }
        if(!quit){
            System.err.println("id ko dung");
        }
    }

    private static void updateProduct(Scanner scanner) throws ParseException {
        System.out.println("nhap id can cap nhap");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        boolean quit = false;
        for(Product p : listProduct) {
            if(p.getProductid().equals(idUpdate)){
                p.updateProduct(scanner);
                quit = true;
                break;
            }
        }
        if(!quit){
            System.err.println("id ko dung");
        }

    }

    private static void sortByPrice(Scanner scanner) {
        //nho ham sap xep
        List<Product> sortProduct = listProduct.stream().sorted(Comparator.comparing(Product::getPrice)).toList();
        for (Product product : sortProduct) {
            product.displayProduct();
        }
    }

    private static void displayProduct(Scanner scanner) {
        System.out.println("tat ca san pham");
        for(Product product : listProduct) {
            product.displayProduct();
        }
    }

    public static void inputProduct(Scanner scanner) throws ParseException {
        System.out.println("nhap so luong product can them");
        int number = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < number; i++) {
            Product newProduct = new Product();
            newProduct.inputProduct(scanner);
            listProduct.add(newProduct);
        }
    }
}
