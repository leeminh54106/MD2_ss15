package student.ra.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass studentClass;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new LinkedList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(int age, float avgMark, String gpa, List<Float> listMarkJavaCore, List<Float> listMarkJavaScript, List<Float> listMarkJavaWeb, boolean sex, StudentClass studentClass, String studentId, String studentName, boolean studentStatus) {
        this.age = age;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.sex = sex;
        this.studentClass = studentClass;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentStatus = studentStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        this.studentId = inputStudentId(sc);
        this.studentName = inputStudentName(sc);
        this.age = inputAge(sc);
        this.sex = inputSex(sc);
        this.listMarkJavaScript = inputScript(sc);
        this.listMarkJavaCore = inputJavaCore(sc);
        this.listMarkJavaWeb = inputJavaWeb(sc);
        this.studentStatus = inputStudentStauts(sc);
    }

    private boolean inputStudentStauts(Scanner sc) {
        System.out.println("nhap vao trang thai sinh vien:");
        do {
            String status = sc.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("true/false");
            }
        } while (true);
    }

    private List<Float> inputJavaWeb(Scanner sc) {
        System.out.println("nhap diem thi mon javaWeb:");
        int count = 1;
        do {
            System.out.printf("nhap diem thu lan %d \n", count);
            float number = Float.parseFloat(sc.nextLine());
            this.listMarkJavaWeb.add(number);
            System.out.printf("ban co muon nhap lan %d khong? \n", count + 1);
            System.out.println("1.co");
            System.out.println("2.khong");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                return this.listMarkJavaWeb;
            }
            count++;
        } while (true);
    }

    private List<Float> inputJavaCore(Scanner sc) {
        System.out.println("nhap diem thi mon javaCore:");
        int count = 1;
        do {
            System.out.printf("nhap diem thu lan %d \n", count);
            float number = Float.parseFloat(sc.nextLine());
            this.listMarkJavaCore.add(number);
            System.out.printf("ban co muon nhap lan %d khong? \n", count + 1);
            System.out.println("1.co");
            System.out.println("2.khong");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                return this.listMarkJavaCore;
            }
            count++;
        } while (true);
    }

    private List<Float> inputScript(Scanner sc) {
        System.out.println("nhap diem thi mon javaScript:");
        int count = 1;
        do {
            System.out.printf("nhap diem thu lan %d \n", count);
            float number = Float.parseFloat(sc.nextLine());
            this.listMarkJavaScript.add(number);
            System.out.printf("ban co muon nhap lan %d khong? \n", count + 1);
            System.out.println("1.co");
            System.out.println("2.khong");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice != 1) {
                break;
            }
            count++;
        } while (true);
        return this.listMarkJavaScript;
    }

    private boolean inputSex(Scanner sc) {
        System.out.println("gioi tinh sinh vien");
        do {
            String sex = sc.nextLine();
            if (sex.equals("true") || sex.equals("false")) {
                return Boolean.parseBoolean(sex);
            } else {
                System.err.println("true or false");
            }
        } while (true);
    }

    private int inputAge(Scanner sc) {
        System.out.println("tuoi sinh vien:");
        do {
            int age = Integer.parseInt(sc.nextLine());
            if (age >= 18) {
                return age;
            } else {
                System.err.println(" >= 18 tuoi");
            }
        } while (true);
    }

    private String inputStudentName(Scanner sc) {
        System.out.println("ten sinh vien:");
        do {
            String studentName = sc.nextLine();
            if (studentName.trim().length() >= 20 && studentName.trim().length() <= 50) {
                return studentName;
            }
        } while (true);
    }

    private String inputStudentId(Scanner sc) {
        System.out.println("nhap Id sinh vien:");
        do {
            String idStudent = sc.nextLine();
            if (idStudent.trim().length() == 6) {
                if (idStudent.trim().charAt(0) == 'S') {
                    return idStudent;
                }
            } else {
                System.out.println("6 ki ty");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Id: %s - Name: %s - Age: %d - Sex: %s - Class: %s \n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "nu", this.studentClass.getClassName());

        System.out.println("diem javascript:");
        for (float markJs : this.listMarkJavaScript) {
            System.out.printf("%.2f \t" + markJs);
        }
        System.out.println("\n");

        System.out.println("diem javacore:");
        for (float markCore : this.listMarkJavaCore) {
            System.out.printf("%.2f \t" + markCore);
        }
        System.out.println("\n");

        System.out.println("diem javaweb:");
        for (float markWeb : this.listMarkJavaWeb) {
            System.out.printf("%.2f \t" + markWeb);
        }
        System.out.println("\n");

        System.out.printf("diem TB %f - xep loai %s - trang thai %s \n",
                this.avgMark, this.gpa, this.studentStatus ? "con" : "tot nghiep");
    }

    public void calAvgMark() {
        this.avgMark = (listMarkJavaScript.get(listMarkJavaScript.size() - 1) +
                listMarkJavaCore.get(listMarkJavaCore.size() - 1)
                + listMarkJavaWeb.get(listMarkJavaWeb.size() - 1)) / 3;
    }
    public void getGPA(){
        if(this.avgMark < 5){
            this.gpa = "yeu";
        }else if (this.avgMark <7) {
            this.gpa = "trung binh";
        } else if (this.avgMark <9) {
            this.gpa = "kha";
        }else {
            this.gpa = "gioi";
        }
    }
}
