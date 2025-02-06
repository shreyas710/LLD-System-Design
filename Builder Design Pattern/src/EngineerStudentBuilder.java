import java.util.ArrayList;
import java.util.List;

public class EngineerStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("DSA");
        subjects.add("OS");
        subjects.add("Computer Architecture");
        this.subjects = subjects;
        return this;
    }
}
