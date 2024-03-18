package org.grunskii;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/alexey/00university/05semester/01translation_methods/_real03lab/src/main/resources/incorrect.txt");

        ParserLexer lexer = new ParserLexer(CharStreams.fromPath(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserParser logParser = new ParserParser(tokens);

        ParseTree tree = logParser.entry();
        ParseTreeWalker walker = new ParseTreeWalker();
        ParserBaseListener latexListener = new ImportListener();
        walker.walk(latexListener, tree);
        FirstFollow.makeFirstFollow();
        int a = 5;
        System.out.println(FirstFollow.checkLL1());
    }
}