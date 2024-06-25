package student.ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classID;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classID, String className, int classStatus, String descriptions) {
        this.classID = classID;
        this.className = className;
        this.classStatus = classStatus;
        this.descriptions = descriptions;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void inputData(Scanner sc) {
        this.classID = inputClassId(sc);
        this.className = inputClassName(sc);
        this.descriptions = inputDescriptions(sc);
        this.classStatus = inputStatus(sc);
    }

    private int inputStatus(Scanner sc) {
        System.out.println("nhap trang thai:");
        return Integer.parseInt(sc.nextLine());
    }

    private String inputDescriptions(Scanner sc) {
        System.out.println("nhap mo ta:");
        return sc.nextLine();
    }

    private String inputClassName(Scanner sc) {
        System.out.println("nhap vao ten class");
        do {
            String className = sc.nextLine();
            if (className.trim().length() > 0 && className.trim().length() <= 10) {
                return className;
            } else {
                System.err.println(">0 && <= 10 ki tu");
            }
        } while (true);
    }

    private String inputClassId(Scanner sc) {
        System.out.println("nhap ID class:");
        do {
            String classId = sc.nextLine();
            if (classId.trim().length() == 5) {
                if (classId.trim().charAt(0) == 'J') {
                    return classId;
                }
            } else {
                System.err.println(" gom 5 ky tu");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Id: %s - Name: %s - descriptions: %s - status: %d\n",
                this.classID, this.className, this.descriptions, this.classStatus);
    }

}
