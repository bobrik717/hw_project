package models;

import enums.Gender;

import java.util.Scanner;

public class ConsoleReader {
    private String[] consoleData = new String[5];
    public ConsoleReader() {
    }

    public String[] getConsoleData() {
        return consoleData;
    }

    public void setConsoleData(String[] consoleData) {
        this.consoleData = consoleData;
    }

    public void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Name?");
        consoleData[0] = sc.nextLine();
        System.out.println();

        System.out.println("Student Last Name?");
        consoleData[1] = sc.nextLine();
        System.out.println();

        System.out.println("Student Gender(MALE, FEMALE)?");
        consoleData[2] = sc.nextLine();
        System.out.println();

        System.out.println("Student ID?");
        consoleData[3] = sc.nextLine();
        System.out.println();

        System.out.println("Student Group Name?");
        consoleData[4] = sc.nextLine();
        System.out.println();
    }

    public Student createStudent() {
        getData();
        Student student = new Student();
        student.setName(consoleData[0]);
        student.setLastName(consoleData[1]);
        student.setGender(Gender.valueOf(Gender.class, consoleData[2]));
        student.setId(Integer.parseInt(consoleData[3]));
        student.setGroupName(consoleData[4]);

        return student;
    }
}
