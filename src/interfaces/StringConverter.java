package interfaces;

import models.Student;

public interface StringConverter {
    public String toStringRepresentation (Student student);
    public Student fromStringRepresentation (String str);
}
