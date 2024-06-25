package student.ra.run;

import student.ra.entity.Student;
import student.ra.entity.StudentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static student.ra.run.ClassManagement.listClass;

public class StudentManagament {
    public static List<Student> listStudent = new ArrayList<>();

    public static void menuStudent(Scanner sc) {
        boolean isExit = true;
        do {
            System.out.println("========= quan ly class =============");
            System.out.println("1. them moi student");
            System.out.println("2. update class");
            System.out.println("3. hien thi class");
            System.out.println("4. tinh dem trung binh");
            System.out.println("5. xep loai student");
            System.out.println("6. sap xep theo diem trung binh tang dan");
            System.out.println("7. seach by name");
            System.out.println("8. thong ke sinh vien theo gioi, kha, yeu");
            System.out.println("9. thong ke sinh vien pass qua mon hoc");
            System.out.println("10. thoat");
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputStudent(sc);
                    break;
                case 2:
                    updateStudent(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    isExit = false;
                default:
                    System.err.println("1 -> 10");
            }
        } while (isExit);
    }

    private static void updateStudent(Scanner sc) {
        System.out.println("nhap ID can update");
        String idUpdate = sc.nextLine();

        for (Student s : listStudent) {
            if (s.getStudentId().equals(idUpdate)) {
                System.out.println("cap nhap ten:");
                s.setStudentName(sc.nextLine());
                System.out.println("cap nhap tuoi:");
                s.setAge(Integer.parseInt(sc.nextLine()));
                System.out.println("cap nhap sex:");
                s.setSex(!s.isSex());

                int count = 1;
                for (StudentClass c : listClass) {
                    System.out.printf("%d.%s \n", count, c.getClassName());
                    count++;
                }
                System.out.printf("%d. khong cap nhap class\n", count);
                System.out.println("su lua chon cua ban: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice != count) {
                    s.setStudentClass(listClass.get(choice - 1));
                }
                //cap nhap diem
                System.out.println("cap nhap diem javascrip cho student");
                System.out.println("1. nhap lai diem cho student");
                System.out.println("2. them moi diem cho student");
                System.out.println("lua chon cua ban");
                int choiceJS = Integer.parseInt(sc.nextLine());
                switch (choiceJS){
                    case 1:
                        List<Float> listJS = new ArrayList<>();

                        break;
                    case 2:
                        break;
                }
            }
        }

    }

    private static void inputStudent(Scanner sc) {
        System.out.println("nhap so luong student can them:");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            Student newStudent = new Student();
            newStudent.inputData(sc);
            int index = 1;
            for (StudentClass s : listClass) {
                System.out.printf("%d.%s \n", index, s.getClassName());
                index++;
            }
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(sc.nextLine());
            newStudent.setStudentClass(listClass.get(choice - 1));
            listStudent.add(newStudent);
        }
    }
}
