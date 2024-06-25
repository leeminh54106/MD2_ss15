package student.ra.run;

import student.ra.entity.StudentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClassManagement {
    public static List<StudentClass> listClass = new ArrayList<>();

    public static void menuClass(Scanner sc) {
        boolean isExit = true;
        do {
            System.out.println("========= quan ly class =============");
            System.out.println("1. them moi class");
            System.out.println("2. update class");
            System.out.println("3. hien thi class");
            System.out.println("4. thong ke lop hoc dang hoat dong (classStudent = true");
            System.out.println("5. seach by name class");
            System.out.println("6. thoat");
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputListClass(sc);
                    break;
                case 2:
                    updateClass(sc);
                    break;
                case 3:
                    displayClass();
                    break;
                case 4:
                    statisticalClass(sc);
                    break;
                case 5:
                    searchClassByName(sc);
                    break;
                case 6:
                   isExit = false;
                   break;
                default:
                    System.err.println("1 -> 6");
            }
        } while (isExit);
    }

    private static void searchClassByName(Scanner sc) {
        System.out.println("nhap ten class:");
        String className = sc.nextLine();
        boolean isExit = false;
        for(StudentClass s: listClass) {
            if(s.getClassName().toLowerCase().contains(className.toLowerCase())) {
                s.displayData();
                isExit = true;
                break;
            }
        }
        if(!isExit) {
            System.err.println("ko tim thay class");
        }
    }

    private static void statisticalClass(Scanner sc) {
        System.out.println("danh sach cac class dang hoat dong:");
        int count = 0;
        for(StudentClass s: listClass) {
            if(s.getClassStatus() == 0){
                s.displayData();
                count++;
            }
        }
        System.out.printf("co %d Class dang hoat dong \n", count);
    }

    private static void displayClass() {
        System.out.println("danh sach class:");
        for(StudentClass s: listClass) {
            s.displayData();
        }
    }

    private static void updateClass(Scanner sc) {
        System.out.println("nhap vao Id Class can update:");
        String classId = sc.nextLine();
        boolean isExit = false;
        for(StudentClass studentClass : listClass) {
            if(studentClass.getClassName().equals(classId)) {
                System.out.println("cap nhap ten class:");
                studentClass.setClassName(sc.nextLine());
                System.out.println("cap nhap mo ta:");
                studentClass.setDescriptions(sc.nextLine());
                System.out.println("cap nhap trang thai:");
                studentClass.setClassStatus(Integer.parseInt(sc.nextLine()));
                isExit = true;
                break;
            }
        }
        if(!isExit) {
            System.err.println("ko ton tai Id class");
        }
    }

    private static void inputListClass(Scanner sc) {
        System.out.println("nhap so luong class muon them:");
        int number = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < number; i++){
            StudentClass newClass = new StudentClass();
            newClass.inputData(sc);
            listClass.add(newClass);
        }

    }
}
