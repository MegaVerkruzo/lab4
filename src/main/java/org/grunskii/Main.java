package org.grunskii;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    private static final String fileName = "Modification.txt";

//    public static void main(String[] args) throws IOException {
//        Path path = Paths.get(fileName);
//
//        ParserLexer lexer = new ParserLexer(CharStreams.fromPath(path));
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ParserParser logParser = new ParserParser(tokens);
//
//        ParseTree tree = logParser.entry();
//        ParseTreeWalker walker = new ParseTreeWalker();
//        ParserBaseListener latexListener = new ImportListener();
//        walker.walk(latexListener, tree);
//        FirstFollow.makeFirstFollow();
//
//        if (FirstFollow.checkLL1()) {
//            CodeGenerator.generateClass(fileName.replace(".txt", ""));
//        } else {
//            throw new IllegalArgumentException("Can't generate class because it's not LL1");
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final ParserModification parser = new ParserModification();
        while (true) {
            String s = scanner.nextLine();
            try {
                System.out.println(parser.parse(s));
            } catch (ParseException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}