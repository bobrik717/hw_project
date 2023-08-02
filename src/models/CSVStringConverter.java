package models;

import enums.Gender;
import interfaces.StringConverter;

public class CSVStringConverter implements StringConverter {
    private static final String PROPERTY_SEPARATOR = ";";
    @Override
    public String toStringRepresentation(Student student) {
        return student.getName()
                + CSVStringConverter.PROPERTY_SEPARATOR
                + student.getLastName()
                + CSVStringConverter.PROPERTY_SEPARATOR
                + student.getGender()
                + CSVStringConverter.PROPERTY_SEPARATOR
                + student.getId()
                + CSVStringConverter.PROPERTY_SEPARATOR
                + student.getGroupName();
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] arr = str.split(CSVStringConverter.PROPERTY_SEPARATOR);
        return new Student(arr[0], arr[1], Enum.valueOf(Gender.class, arr[2]), Integer.parseInt(arr[3]), arr[4]);
    }
}
