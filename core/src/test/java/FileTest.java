import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FileTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    //    @Mock
    private FileReadService fileReadService;

    @Before
    public void setUp() {
        fileReadService = new FileReadService();
    }

    @Test
    public void shouldReadFileInDirectory() throws IOException {
        //Given
        String folderName = "/home/hasan/github/sampler/core/src/main/resources/one/";
        //when
        long numberOfFiles = fileReadService.readFiles(folderName);
        //then
        assertThat(numberOfFiles, is(2l));
    }

    @Test
    public void shouldReadFileInDirectoryRecursive() throws IOException {
        //Given
        String folderName = "/home/hasan/github/sampler/core/src/main/resources/two/";
        //when
        long numberOfFiles = fileReadService.readFilesRec(folderName);
        //then
        assertThat(numberOfFiles, is(3l));
    }



    @Test
    public void shouldThrowExceptionForWrongDirectory() throws IOException {
        //Given
        String folderName = "dummy";
        expectedException.expect(NoSuchFileException.class);
        //Then
        long numberOfFiles = fileReadService.readFiles(folderName);
    }

    @Test
    public void shouldThrowExceptionForFilePaths() throws IOException {
        //Given
        String folderName = "/home/hasan/github/sampler/core/src/main/resources/one/a.txt";
        expectedException.expect(NotDirectoryException.class);
        //Then
        long numberOfFiles = fileReadService.readFiles(folderName);
    }


}
