package org.grunskii;

import org.grunskii.model.*;
import java.io.InputStream;
import java.text.ParseException;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.lang.Long;
import java.lang.Math;
public class LexicalAnalyzerModification {
    private final String is;
    private int curChar;
    private int curPos;
    private TokenModification curToken;
    private String buffer = "";
    private static final List<String> regexes = List.of("[0-9]+");
    private static final Map<String, String> tokens = new LinkedHashMap<>();

    static {
        tokens.put("", "EPSILON_Bf11o3bo1V");
tokens.put("(", "LP");
tokens.put(")", "RP");
tokens.put("**", "POW");
tokens.put("??", "TWO_FACTORIAL");
tokens.put("?", "FACTORIAL");
tokens.put("*", "MULTIPLY");
tokens.put("/", "DIVISION");
tokens.put("+", "PLUS");
tokens.put("-", "MINUS");
tokens.put("[0-9]+", "VAR");
    }

    public LexicalAnalyzerModification(String is) throws ParseException {
        this.is = is;
        this.curPos = 0;
        this.curChar = is.charAt(curPos);
    }

    public void nextToken() throws ParseException {
        while (curChar != -1 && isBlank(curChar)) {
            nextChar();
        }

        if (curChar == -1) {
            curToken = TokenModification.EPSILON_Bf11o3bo1V;
            return;
        };

        String chStr = Character.toString(curChar);
        String regex = InfoClass.isRegex(regexes, chStr);
        if (regex != null) {
            curToken = TokenModification.valueOf(tokens.get(regex));
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
                    curToken = TokenModification.valueOf(entry.getValue());
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

    public TokenModification getToken() {
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
