import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        // Node document = parser.parse("This is *Sparta*");
        // HtmlRenderer renderer = HtmlRenderer.builder().build();
        // System.out.println(renderer.render(document));  // "<p>This is <em>Sparta</em></p>\n"
        Node node = parser.parse("[a [nested link](a.com)](b.com)");
        // WordCountVisitor visitor = new WordCountVisitor();
        LinkVisitor v = new LinkVisitor();
        node.accept(v);
        System.out.println(v.links.size());  // 4
    }
}

class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
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