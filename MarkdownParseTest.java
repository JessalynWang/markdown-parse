// importing junit libraries
import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;



public class MarkdownParseTest {
    @Test 
    public void addition() {
        // Passes if 2 equals 1 + 1, fails if they are not equal
        assertEquals(2, 1 + 1);
    }

    @Test
    public void TestOne() throws IOException, NoSuchFileException {
        //passes if running Markdown parse returns the correct text for "test-file.md"
        List<String> correctOutput = List.of("https://something.com","some-page.html");
        Path fileName = Path.of("test-file.md");
        // read the file contents into a string
	    String contents = Files.readString(fileName);
        // run getLinks on the contents of the file
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(correctOutput,links);
    }
}



