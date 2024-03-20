package org.grunskii;

import org.grunskii.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoClass {
    public static final String PACKAGE = "org.grunskii";
    public static final List<String> imports = new ArrayList<>();
    public static String inClass = "";
    public static final Map<String, String> tokens = new LinkedHashMap<>();
    public static final List<String> regexes = new ArrayList<>();
    public static final LinkedHashMap<String, NonTerminal> nonTerminals = new LinkedHashMap<>();
    public static final List<String> orderNonTerminals = new ArrayList<>();

    static {
        addImport("import " + PACKAGE + ".model.*;");
        addImport("import java.io.InputStream;");
        addImport("import java.text.ParseException;");
        addImport("import java.io.IOException;");
        addImport("import java.util.Map;");
        addImport("import java.util.List;");
        addImport("import java.util.LinkedHashMap;");

        addToken(FirstFollow.EPSILON, "", false);
    }

    public static void addImport(String str) {
        imports.add(str);
    }

    public static void addToken(String key, String value, boolean isRegex) {
        if (!isRegex) {
            tokens.put(value, key);
        } else {
            tokens.put(value, key);
            regexes.add(value);
        }
    }

    public static void addRule(String name, NonTerminal nonTerminal) {
        nonTerminals.put(name, nonTerminal);
    }

    public static void addSubRuleToRule(String name, Rule rule) {
        nonTerminals.get(name).rules().add(rule);
    }

    public static String isRegex(List<String> regexes, String value) {
        for (String regex : regexes) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return regex;
            }
        }
        return null;
    }

    public static String getKeyToken(String value) {
        for (String regex : regexes) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return tokens.get(regex);
            }
        }

        if (tokens.containsKey(value)) {
            return tokens.get(value);
        }

        throw new IllegalArgumentException("Can't find token");
    }
}
