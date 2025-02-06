import java.util.List;

public class Student {
    int rollNo;
    String name;
    int age;
    String fatherName;
    String motherName;
    List<String> subjects;

    public Student(StudentBuilder builder) {
        rollNo = builder.rollNo;
        name = builder.name;
        age = builder.age;
        fatherName = builder.fatherName;
        motherName = builder.motherName;
        subjects = builder.subjects;
    }

    public String toString() {
        return " roll number: " + this.rollNo +
                " age: " + this.age +
                " name: " + this.name +
                " father name: " + this.fatherName +
                " mother name: " + this.motherName +
                " subjects: " + subjects.get(0) + "," + subjects.get(1) + "," + subjects.get(2);
    }
}
