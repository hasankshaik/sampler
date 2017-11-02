import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Immutable {
    public static void main(String[] args) {
        ImmutableObj immutableObj = new ImmutableObj("SomeName", Arrays.asList("SubjectOne", "SubjectTwo"));
        System.out.println(immutableObj.getName());
        immutableObj.getSubjects().forEach(System.out::print);
        //Will throw Exception
        immutableObj.getSubjects().add("newSubject");
    }
}

final class ImmutableObj {

    private final String name;
    private final List<String> subjects;

    public ImmutableObj(String name, List<String> subjects) {
        this.name = name;
        this.subjects = Collections.unmodifiableList(subjects);
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects ;
    }
}
