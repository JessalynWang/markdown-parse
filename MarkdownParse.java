// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class MarkdownParse {
    public static String getLink() {
        return "";
    }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        
        int currentIndex = 0;
        Stack<Character> bracketTracker = new Stack<>();
        boolean findLink = false;
        int start = 0;
        int end = 0;
        while (currentIndex < markdown.length()) {
            char curr = markdown.charAt(currentIndex);
            if (curr == '\\') {
                currentIndex += 2;
                continue;
            }

            if (findLink) {
                if (bracketTracker.isEmpty()) {
                    if (curr == '(') {
                        bracketTracker.push(curr);
                        start = currentIndex;
                    } else {
                        findLink = false;
                    }
                } else {
                    if (curr == ')') {
                        end = currentIndex;
                        toReturn.add(markdown.substring(start + 1, end));
                        bracketTracker.pop();
                        findLink = false;
                    }
                }
            } else {
                if (curr == '[') {
                    bracketTracker.push(curr);
                } else if (curr == ']') {
                    if (!bracketTracker.isEmpty()) {
                        bracketTracker.pop();
                        findLink = true;
                    }
                }
            }

            currentIndex++;
        }

        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}