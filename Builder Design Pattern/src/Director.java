public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if (studentBuilder instanceof EngineerStudentBuilder) return createEngineerStudent();
        else if (studentBuilder instanceof MBAStudentBuilder) return createMBAStudent();
        return null;
    }

    private Student createEngineerStudent() {
        return studentBuilder.setRollNo(1).setName("Engineer").setAge(22).setSubjects().build();
    }

    private Student createMBAStudent() {
        return studentBuilder.setRollNo(2).setName("MBA").setAge(22).setFatherName("MBA Father").setMotherName("MBA Mother").setSubjects().build();
    }
}
