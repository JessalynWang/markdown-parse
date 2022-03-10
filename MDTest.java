// importing junit libraries
import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.*;



public class MDTest {

    // javac -cp ".;lib\junit-4.12.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
    // java -cp ".;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
    @Test
    public void TestOne() throws IOException, NoSuchFileException {
        //passes if running Markdown parse returns the correct text for "test-file.md"
        List<String> correctOutput = List.of("https://ucsd-cse15l-w22.github.io/");
        Path fileName = Path.of("lab_8_t3.md");
        // read the file contents into a string
	    String contents = Files.readString(fileName);
        // run getLinks on the contents of the file
        ArrayList<String> links = MD.getLinks(contents);
        assertEquals(correctOutput,links);
    }

}



