// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);

        LinkVisitor v = new LinkVisitor();
        node.accept(v);
        return v.links;
    }
    public static void main(String[] args) throws IOException {
        // take in the first command line arg as the file name to be searched for links.
		Path fileName = Path.of(args[0]);
        // read the file contents into a string
	    String contents = Files.readString(fileName);
        // run getLinks on the contents of the file
        ArrayList<String> links = getLinks(contents);
        // print out the links that we found
        System.out.println(links);
    }
}

class LinkVisitor extends AbstractVisitor {
    ArrayList<String> links = new ArrayList<>();
    
    @Override
    public void visit(Link link) {
        String l = link.getDestination();
        

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        links.add(l);
    }
}