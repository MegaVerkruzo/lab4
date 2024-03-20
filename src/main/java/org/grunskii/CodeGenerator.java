package org.grunskii;

import org.grunskii.model.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CodeGenerator {
    private static final Random random = new Random();

    public static void generateClass(String fileName) throws IOException {
        Path path = Paths.get("..", "java", "org", "grunskii");

        createParserClass(path, fileName);
        createTokenClass(path, fileName);
        createLexicalAnalyzer(path, fileName);
    }

    private static void createParserClass(Path path, String fileName) throws IOException {
        try (final BufferedWriter writer = clearCreateFile(path, "Parser" + fileName + ".java")) {
            writePackage(writer);
            writeImports(writer);
            writeFieldAndConstructor(fileName, writer);
            for (NonTerminal nonTerminal : InfoClass.nonTerminals.values()) {
                writeFunction(writer, nonTerminal, fileName);
            }
            writer.write("}");
        }
    }

    private static void createTokenClass(Path path, String fileName) throws IOException {
        try (final BufferedWriter writer = clearCreateFile(path, "Token" + fileName + ".java")) {
            writePackage(writer);
            writer.write("public enum Token" + fileName + " {\n");
            writer.write("\t" + String.join(", ", InfoClass.tokens.values()));
            writer.newLine();
            writer.write("}");
        }
    }

    private static void createLexicalAnalyzer(Path path, String fileName) throws IOException {
        try (final BufferedWriter writer = clearCreateFile(path, "LexicalAnalyzer" + fileName + ".java")) {
            writePackage(writer);
            writeImports(writer);
            writer.write(String.format("""
                                                
                            public class LexicalAnalyzer%s {
                                private final String is;
                                private int curChar;
                                private int curPos;
                                private Token%s curToken;
                                private String buffer = "";
                                private static final List<String> regexes = List.of(%s);
                                private static final Map<String, String> tokens = new LinkedHashMap<>();
                                                
                                static {
                                    %s
                                }
                                                
                                public LexicalAnalyzer%s(String is) throws ParseException {
                                    this.is = is;
                                    this.curPos = 0;
                                    this.curChar = is.charAt(curPos);
                                }
                                
                                public void nextToken() throws ParseException {
                                    while (curChar != -1 && isBlank(curChar)) {
                                        nextChar();
                                    }
                                    
                                    if (curChar == -1) {
                                        curToken = Token%s.%s;
                                        return;
                                    };
                                    
                                    String chStr = Character.toString(curChar);
                                    String regex = InfoClass.isRegex(regexes, chStr);
                                    if (regex != null) {
                                        curToken = Token%s.valueOf(tokens.get(regex));
                                        skipWord();
                                        return;
                                    } else {
                                        buffer = "" + chStr;
                                    }
                                    
                                    boolean find = false;
                                    while (!buffer.isBlank() && !find) {
                                        for (Map.Entry<String, String> entry : tokens.entrySet()) {
                                            while (entry.getKey().startsWith(buffer) && !entry.getKey().equals(buffer)) {
                                                curPos++;
                                                if (curPos == is.length()) {
                                                    curPos--;
                                                    break;
                                                }
                                                curChar = is.charAt(curPos);
                                                buffer += Character.toString(curChar);
                                            } 
                                            
                                            if (entry.getKey().equals(buffer)) {
                                                curToken = Token%s.valueOf(entry.getValue());
                                                curPos++;
                                                if (curPos < is.length()) {
                                                    curChar = is.charAt(curPos);
                                                } else {
                                                    curChar = -1;
                                                }
                                                find = true;
                                                break;
                                            } else {
                                                if (buffer.length() > 1) {
                                                    curPos -= buffer.length() - 1;
                                                    buffer = buffer.substring(0, 1);
                                                    curChar = is.charAt(curPos);
                                                }
                                            }
                                        }
                                        if (!find) {
                                            throw new ParseException("Illegal character " + (char) curChar, curPos);
                                        }
                                    }
                                } 
                                
                                public Token%s getToken() {
                                    return curToken;
                                }
                                
                                public int getPos() {
                                    return curPos;
                                }
                                
                                public String getBuffer() {
                                    return buffer;
                                }
                                
                                private void skipWord() throws ParseException {
                                    buffer = "";
                                    while (curChar != -1 && InfoClass.isRegex(regexes, Character.toString(curChar)) != null) {
                                        buffer += Character.toString(curChar);
                                        nextChar();
                                    }
                                }
                                
                                private void nextChar() throws ParseException {
                                    curPos++;
                                    curChar = curPos == is.length() ? -1 : is.charAt(curPos);
                                }
                                
                                private boolean isBlank(int c) {
                                    return Character.isWhitespace(c);
                                }
                            }
                            """,
                    fileName, fileName,
                    InfoClass.regexes.stream().map(str -> "\"" + str + "\"").collect(Collectors.joining(", ")),
                    InfoClass.tokens.entrySet().stream().map(entry -> "tokens.put(\"" + entry.getKey() + "\", \"" + entry.getValue() + "\")").collect(Collectors.joining(";\n")) + ";",
                    fileName,
                    fileName, FirstFollow.EPSILON,
                    fileName, fileName, fileName));
//            writer.write(String.join(", ", InfoClass.tokens.values()));
//            writer.newLine();
//            writer.write("}");
        }
    }

    private static BufferedWriter clearCreateFile(Path path, String javaFileName) throws IOException {
        Path resultPath = path.resolve(javaFileName);
        Files.deleteIfExists(resultPath);
        return Files.newBufferedWriter(resultPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
    }

    private static void writeFieldAndConstructor(String fileName, BufferedWriter writer) throws IOException {
        NonTerminal startNode = InfoClass.nonTerminals.get(InfoClass.orderNonTerminals.get(0));
        writer.write(String.format("""
                                            
                                            
                        public class Parser%s {
                            private LexicalAnalyzer%s lex;
                            
                            public %s parse(String is) throws ParseException {
                                lex = new LexicalAnalyzer%s(is);
                                lex.nextToken();
                                return %s();
                            }
                            
                            %s
                            
                            
                        """,
                fileName,
                fileName,
                startNode.resultType(),
                fileName,
                startNode.name(),
                InfoClass.inClass
        ));

    }

    private static void writeFunction(BufferedWriter writer, NonTerminal nonTerminal, String fileName) throws IOException {
        writer.write(String.format("""
                    public %s %s(%s) throws ParseException {
                        switch (lex.getToken()) {
                """, nonTerminal.resultType(), nonTerminal.name(), getStringArgumentsForRead(nonTerminal)));

        boolean hasEpsilon = false;
        for (String token : FirstFollow.first.get(nonTerminal.name())) {
            if (token.equals(FirstFollow.EPSILON)) {
                hasEpsilon = true;
            } else {
                writeSwitchCaseToken(writer, nonTerminal, token, fileName, false);
            }
        }

        if (hasEpsilon) {
            for (String token : FirstFollow.follow.get(nonTerminal.name())) {
                writeSwitchCaseToken(writer, nonTerminal, token, fileName, true);
            }
        }

        writer.write(String.format("""
                            default:
                                throw new ParseException("Incorrect token %s at position", lex.getPos());
                        }
                    }
                """, nonTerminal.name()));
    }

    private static void writeSwitchCaseToken(BufferedWriter writer, NonTerminal nonTerminal, String token, String fileName, boolean isEpsilon) throws IOException {
        Rule rule = (isEpsilon ? Util.findEmpty(nonTerminal) :
                token.equals(FirstFollow.EPSILON)
                        ? Util.findEmpty(nonTerminal)
                        : Util.findRule(nonTerminal, token)
        ).orElseThrow(() -> new IllegalArgumentException("Incorrect rule"));

        writer.write(String.format("""
                            case %s:
                """, token));

        Map<String, String> varToEncodedVar = new HashMap<>();
        for (RuleArgument argument : rule.arguments()) {
            if (argument.isToken() && argument.inherits().isEmpty()) {
                writer.write(String.format("""
                                        // %s
                                        if (lex.getToken() != Token%s.%s) {
                                            throw new ParseException("Expected '%s', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                                        }
                                        lex.nextToken();
                        """, argument.type(), fileName, argument.type(), argument.type()));
            } else if (argument.isToken()) {
                int hash = Objects.hash(argument.name(), argument.type(), random.nextLong());
                hash = (hash == Integer.MIN_VALUE) ? Integer.MAX_VALUE : (hash < 0 ? -1 : 1) * hash;
                String resultVarName = argument.name() + "_" + hash;
                varToEncodedVar.put(argument.name(), resultVarName);

                writer.write(String.format("""
                                        // %s
                                        String %s = lex.getBuffer();
                                        lex.nextToken();
                        """, argument.type(), resultVarName));
            } else {
                NonTerminal result = Util.getNonTerminalByToken(argument.type());
                int hash = Objects.hash(argument.name(), argument.type(), random.nextLong());
                hash = (hash == Integer.MIN_VALUE) ? Integer.MAX_VALUE : (hash < 0 ? -1 : 1) * hash;
                String resultVarName = argument.name() + "_" + hash;
                varToEncodedVar.put(argument.name(), resultVarName);

                writer.write(String.format("""
                                                // %s
                                                %s %s = %s(%s);
                                """,
                        argument.type(),
                        result.resultType(),
                        resultVarName,
                        argument.type(),
                        getStringArgumentsForPaste(varToEncodedVar, argument.inherits())));
            }
        }

        String result = rule.result();
        for (Map.Entry<String, String> entry : varToEncodedVar.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }

        writer.write(String.format("""
                                return %s;
                """, result));
    }

    private static String getStringArgumentsForRead(NonTerminal nonTerminal) {
        return nonTerminal
                .attributes()
                .stream()
                .map(attribute -> attribute.type() + " " + attribute.name())
                .collect(Collectors.joining(", "));
    }

    private static String getStringArgumentsForPaste(Map<String, String> mapKeyToEncodedKey, List<String> inherits) {
        return inherits
                .stream()
                .map(ruleArgument -> {
                    for (Map.Entry<String, String> entry : mapKeyToEncodedKey.entrySet()) {
                        ruleArgument = ruleArgument.replace(entry.getKey(), entry.getValue());
                    }
                    return ruleArgument;
                })
                .collect(Collectors.joining(", "));
    }

    private static void writePackage(BufferedWriter writer) throws IOException {
        writer.write("package " + InfoClass.PACKAGE + ";");
        writer.newLine();
        writer.newLine();
    }

    private static void writeImports(BufferedWriter writer) throws IOException {
        writer.write(String.join("\n", InfoClass.imports));
    }
}
