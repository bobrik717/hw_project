package main;

import Exceptions.GroupOverflowException;
import Exceptions.StudentNotFoundException;
import enums.Gender;
import models.ConsoleReader;
import models.Group;
import models.Student;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("IT");
        String[] lastNames = {
            "Aadas",
            "Badas",
            "Cadas",
            "Ladas",
            "Gadas",
            "Madas",
            "Sadas",
            "Padas",
            "Nadas",
            "Tadas"
        };
        for (int i = 0; i < 10; i++) {
            int id = i + 1;
            Gender gender = i % 2 == 0 ? Gender.MALE: Gender.FEMALE;
            Student s = new Student("Jon_" + id, lastNames[9 - i], gender, id, group.getGroupName());
            try {
                group.addStudent(s);
            } catch (GroupOverflowException e) {
                System.out.println("Group is full");
            }
        }

        System.out.println(group);

        String stLastName = "Nadas";
        try {
            System.out.println(group.searchStudentByLastName(stLastName));
        } catch (StudentNotFoundException e) {
            System.out.println("Student with last name " + stLastName + " don't exists");
        }

        System.out.println(group.removeStudentByID(2));
        System.out.println(group.removeStudentByID(5));
        System.out.println(group.removeStudentByID(6));
        System.out.println(group.removeStudentByID(7));
        System.out.println(group);

        try {
            group.addStudent(new Student("Jon_11", "Dou_11", Gender.FEMALE, 11, group.getGroupName()));
        } catch (GroupOverflowException e) {
            System.out.println("Group is full");
        }

        System.out.println(group);

        try {
            group.addStudent((new ConsoleReader()).createStudent());
        } catch (GroupOverflowException e) {
            System.out.println("Group is full");
        }

        System.out.println(group);
    }
}