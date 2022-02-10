test: MarkdownParse.class MarkdownParseTest.class

MarkdownParse.class: MarkdownParse.java
	javac MarkDownParse.java

MarkdownParseTest.class: MarkdownParseTest.java
	javac lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:. MarkdownParseTest.java