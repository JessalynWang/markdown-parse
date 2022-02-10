test: MarkDownParse.class MarkDownParseTest.class

MarkDownParse.class: MarkDownParse.java
	javac MarkDownParse.java

MarkDownParseTest.class: MarkDownParseTest.java
	javac lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:. MarkDownParseTest.java