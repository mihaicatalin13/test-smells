package file;

import service.FileService;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {
    private final FileService fileService = new FileService();

    // NOT DETECTED - MYSTERY GUEST
    // instead tsDetect finds magic number ??
    @Test
    public void testReadFile() throws IOException {
        String content = fileService.readFile("src\\test\\java\\file\\testfile.txt");
        assertEquals("Hello, world!", content);
    }
}
