import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FileReadWriteTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private FileReadWrite fileReadWrite;
    private String fileName;
    private String emptyFileName;

    @Before
    public void setUp() throws IOException {
        fileReadWrite = new FileReadWrite();
        fileName = "/home/hasan/lines.txt";
        if (Files.notExists(Paths.get(fileName)))
            Files.createFile(Paths.get(fileName));

        emptyFileName = "/home/hasan/empty.txt";
        if (Files.notExists(Paths.get(emptyFileName)))
            Files.createFile(Paths.get(emptyFileName));
    }


    @Test
    public void shouldWriteToFileTest() throws IOException {
        //Given there some Text
        String someString = "The content to be written";
        //Then we should be able to write the content to a file
        fileReadWrite.writeToFile(fileName, someString);
        String fileContent = fileReadWrite.readFromFile(fileName);
        assertThat(someString, is(fileContent));

    }


    @Test
    public void shouldThrowExceptionTest() throws IOException {
        //Given the file does not  exsist
        expectedException.expect(NoSuchFileException.class);
        //then we should throw exception
        fileReadWrite.readFromFile("RandomFileName");
        fail("Should  never reach here.");

    }

    public void tearDown() {

    }

}
