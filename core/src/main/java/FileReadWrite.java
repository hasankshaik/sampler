import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReadWrite {

    public void writeToFile(String fileName, String someContent) throws IOException {

//        Files.write(Paths.get(fileName), (Iterable<String>) Stream.of(someContent)::iterator);
        Files.write(Paths.get(fileName), someContent.getBytes());
    }

    public String readFromFile(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        Files.lines(path).forEach(s -> stringBuilder.append(s));
        return stringBuilder.toString();

    }
}
