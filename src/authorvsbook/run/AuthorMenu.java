package authorvsbook.run;

import authorvsbook.ra.entity.Author;
import authorvsbook.ra.feature.IAuthor;
import authorvsbook.ra.feature.impl.AuthorImpl;
import authorvsbook.ra.feature.impl.BookImpl;
import authorvsbook.ra.utils.Color;

import java.util.Scanner;

public class AuthorMenu {
    private static final IAuthor authorFeature = new AuthorImpl();

    public static void authorMenu(Scanner scanner) {
        boolean quit = true;
        do {
            String borderColor = Color.YELLOW;
            String bottomColor = borderColor + "╚═════════════════════════════════════════════════════════════════════╝" + Color.RESET;
            String rowColor = borderColor + "║" + Color.RESET;
            String topColor = borderColor + "╔════════════════════════════ MENU AUTHOR ════════════════════════════╗" + Color.RESET;

            System.out.println(topColor);
            System.out.println(rowColor + "" + borderColor + "     1.Hiển thị danh sách tác giả\t\t\t\t\t\t\t\t      " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     2.Thêm mới thông tin tác giả\t\t\t\t\t\t\t\t\t  " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     3.Cập nhật thông tin tác giả\t\t\t\t\t\t\t\t\t  " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     4.Tìm kiểm thông tin tác giả theo tên\t\t\t\t\t\t      " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     5.Thống kê các tác giả có bao nhiêu quyển sách (sử dụng Map)\t  " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     6.Xóa tác giả\t\t\t\t\t\t\t\t\t\t\t\t      " + rowColor);
            System.out.println(rowColor + "" + borderColor + "     6.Thoát\t\t\t\t\t\t\t\t\t\t\t\t\t\t  " + rowColor);
            System.out.println(bottomColor);
//
            System.out.println(borderColor+"Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addAuthor(scanner);
                    break;
                case 3:
                    updateAuthor(scanner);
                    break;
                case 4:
                    searchAuthor(scanner);
                    break;
                case 5:
                    staticalAuthorBook(scanner);
                    break;
                case 6:
                    deleteAuthor(scanner);
                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    System.err.println("1 -> 7");

            }
        } while (quit);

    }

    private static void deleteAuthor(Scanner scanner) {
        System.out.println("nhap id can xoa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        authorFeature.delete(idDelete);
    }

    private static void staticalAuthorBook(Scanner scanner) {
        for(Author a:authorFeature.findAll()){
            long count = BookImpl.books.stream().filter(b -> b.getAuthor().getAuthorId() == a.getAuthorId()).count();
            a.displayAuthor();
            System.out.println("so luong sach la" +count);
        }
    }

    private static void searchAuthor(Scanner scanner) {
       if(authorFeature.findAll().isEmpty()){
           System.err.println("trong");
           return;
       }
        System.out.println("nhap ten tac gia");
       String name = scanner.nextLine();
       boolean hasAuthor = false;
       for(Author author : authorFeature.findAll()){
           if(author.getAuthorName().toLowerCase().contains(name.toLowerCase())){
               hasAuthor = true;
               author.displayAuthor();
           }
       }
       if(!hasAuthor){
           System.err.println("khong tim thay tac gia " +name);
       }

    }

    private static void updateAuthor(Scanner scanner) {
        System.out.println("nhap Id ten tac gia:");
        int id = Integer.parseInt(scanner.nextLine());
        int indexUpdate = authorFeature.findIndexById(id);
        if (indexUpdate >= 0) {
            Author authorUpdate = AuthorImpl.authors.get(indexUpdate);
            boolean isExit = true;
            do {
                System.out.println("1.ten");
                System.out.println("2.mo ta");
                System.out.println("3.tuoi");
                System.out.println("4.status");
                System.out.println("5.exit");
                System.out.println("lua chon cua ban :");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("nhap ten:");
                        authorUpdate.setAuthorName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("nhap mo ta");
                        authorUpdate.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("nhap tuoi");
                        authorUpdate.setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("status");
                        authorUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 5:
                        isExit = false;
                    default:
                        System.err.println(" 1 -> 5");
                }
            } while (isExit);
        } else {
            System.err.println("ko tim thay");
        }
    }

    private static void addAuthor(Scanner scanner) {
        System.out.println("nhap so luong tac gia muon them");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            Author author = new Author();
            author.inputAuthor(scanner);
            authorFeature.addOrUpdate(author);
        }
    }

    private static void showAll() {
        if (authorFeature.findAll().isEmpty()) {
            System.err.println("rong");
            return;
        }
        for (Author a : authorFeature.findAll()) {
            a.displayAuthor();
        }
    }
}
