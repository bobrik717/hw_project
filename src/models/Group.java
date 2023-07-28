package models;

import Exceptions.GroupOverflowException;
import Exceptions.StudentNotFoundException;

import java.util.Arrays;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) throws GroupOverflowException {
        if(students.length > 10) {
            throw new GroupOverflowException();
        }
        if(students.length < 10) {
            Student[] stArr = new Student[10];
            System.arraycopy(students, 0, stArr, 0, students.length);
            this.students = stArr;
        } else {
            this.students = students;
        }
    }

    @Override
    public String toString() {
        sortByName();
        return "Group{groupName='" + groupName + "', students=" + Arrays.toString(students) + '}';
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public void sortByName() {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j] == null) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
                if (students[j] == null || students[j + 1] == null) {
                    continue;
                }
                if (students[j].getLastName().compareTo(students[j + 1].getLastName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}
