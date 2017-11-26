import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileReadService {
    public static void main(String[] args) {
        createFile();
    }
    public static  void createFile() {
        System.out.println(Arrays.asList(1,2,3,4,5).stream().mapToInt(i->i).sum());
    }

    public long readFiles(String one) throws IOException {
        return Files.list(Paths.get(one)).filter(Files::isRegularFile).count();

    }

    public long readFilesRec(String one) throws IOException {
        Files.list(Paths.get(one)).forEach(System.out::print);
        return Files.list(Paths.get(one)).map(f-> {
         if(Files.isDirectory(f)) {
             try {
                 return readFilesRec(f.toString());
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return 1l;
         } else {
             return 1l;
         }
        }).count();

    }
}
