package student.ra.entity;

import java.util.Scanner;

public interface IStudentManagement {
    static final float MARK_PASS = 5;
    void inputData(Scanner sc);
    void displayData();
}
