package comparators;

import models.Student;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        return s1.getLastName().compareTo(s2.getLastName());
    }
}
