package authorvsbook.run;

import authorvsbook.ra.entity.Book;
import authorvsbook.ra.feature.IBook;
import authorvsbook.ra.feature.impl.BookImpl;
import authorvsbook.ra.utils.Color;

import java.util.Scanner;

public class BookMenu {
    public static final IBook bookFeature = new BookImpl();
    public static void bookMenu(Scanner scanner){
        boolean quit = true;
        do {
            String borderColor = Color.GREEN;
            String bottomColor = borderColor + "╚═══════════════════════════════════════════════════════════╝" + Color.RESET;
            String rowColor = borderColor + "║" + Color.RESET;
            String topColor = borderColor + "╔════════════════════════ MENU BOOK ════════════════════════╗" + Color.RESET;

            System.out.println(topColor);
            System.out.println(rowColor + "" + borderColor + "     1.Hiển thị danh sách quyển sách\t\t\t\t\t    " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     2.Thêm mới thông tin sách\t\t\t\t\t\t\t    " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     3.Cập nhật thông tin sách\t\t\t\t\t\t\t    " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     4.Tìm kiếm thông tin sách theo tên sách\t\t\t    " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     5.Tìm kiểm thông tin sách theo giá từ khoảng a -> b   " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     6.Xóa thông tin sách\t\t\t\t\t\t\t\t    " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     6.Thoát\t\t\t\t\t\t\t\t\t\t\t    " + rowColor);
            System.out.println(bottomColor);
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayBook();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    searchBookByName(scanner);
                    break;
                case 5:
                    searchBookByPrice(scanner);
                    break;
                case 6:
                    deleteBook(scanner);
                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    System.err.println("1 -> 7");
            }
        }while (quit);
    }

    private static void updateBook(Scanner scanner) {
        System.out.println("nhap id book can cap nhap");
        String idBook = scanner.nextLine();
        int index  = bookFeature.findIndexById(idBook);
        if(index >=0){
            Book updateBook = BookImpl.books.get(index);
            boolean quit = true;
            do {
                System.out.println("1.cap nhap ten book");
                System.out.println("2.cap nhap gia book");
                System.out.println("3.cap nhap tac gia");
                System.out.println("4.cap nhap status");
                System.out.println("5.thoat");
                System.out.println("lua chon cua ban");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("ten");
                        updateBook.setBookName(updateBook.inputBookName(scanner));
                        break;
                    case 2:
                        System.out.println("gia");
                        updateBook.setPrice(updateBook.inputPrice(scanner));
                        break;
                    case 3:
                        System.out.println("tac gia");
                        updateBook.setAuthor(updateBook.inputAuthor(scanner));
                        break;
                    case 4:
                        System.out.println("status");
                        updateBook.setStatus(updateBook.inputStatus(scanner));
                        break;
                    case 5:
                       quit = false;
                       break;
                    default:
                        System.err.println("1 -> 5");
                }
            }while (quit);
        }else {
            System.err.println("ko ton tai Id nay");
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.println("nhap Id Book muon xoa");
        String idDelete = scanner.nextLine();
        bookFeature.delete(idDelete);
    }

    private static void searchBookByPrice(Scanner scanner) {
        System.out.println("start price:");
        int price = Integer.parseInt(scanner.nextLine());

        System.out.println("end price:");
        int price2 = Integer.parseInt(scanner.nextLine());
        boolean quit = false;
        for(Book b:bookFeature.findAll()){
            if(b.getPrice() >= price && b.getPrice() <= price2){
                b.displayBook();
                quit = true;
            }
        }
        if(!quit){
            System.err.println("ko tim thay sach co price nhu vay");
        }
    }

    private static void searchBookByName(Scanner scanner) {
        System.out.println("nhap ten book can tim:");
        String bookName = scanner.nextLine();
        boolean quit = false;
        for(Book b:bookFeature.findAll()){
            if(b.getBookName().toLowerCase().contains(bookName.toLowerCase())){
                b.displayBook();
                quit = true;
            }
        }
        if(!quit){
            System.err.println("ko tim thay book" +bookName);
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("nhap so luong book muon them");
        int number = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < number; i++){
            Book newbook = new Book();
            newbook.inputBook(scanner);
            bookFeature.addOrUpdate(newbook);
        }
    }

    private static void displayBook() {
        if(bookFeature.findAll().isEmpty()){
            System.err.println("rong");
        }
        for(Book b:bookFeature.findAll()){
            b.displayBook();
        }
    }
}
