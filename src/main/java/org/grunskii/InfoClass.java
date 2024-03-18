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
    private static final String PACKAGE_IMPORT = "import org.grunskii";
    private static final List<String> imports = new ArrayList<>();
    private static final Map<String, String> map = new HashMap<>();
    private static final List<String> regexes = new ArrayList<>();
    public static final LinkedHashMap<String, NonTerminal> nonTerminals = new LinkedHashMap<>();
    public static final List<String> orderNonTerminals = new ArrayList<>();

    static {
        addImport(PACKAGE_IMPORT + ".model.*;");
    }

    public static void addImport(String str) {
        imports.add(str);
    }

    public static void addToken(String key, String value, boolean isRegex) {
        if (!isRegex) {
            map.put(value, key);
        } else {
            map.put(value, key);
            regexes.add(value);
        }
    }

    public static void addRule(String name, NonTerminal nonTerminal) {
        nonTerminals.put(name, nonTerminal);
    }

    public static void addSubRuleToRule(String name, Rule rule) {
        nonTerminals.get(name).rules().add(rule);
    }

    public static String getKeyToken(String value) {
        for (String regex : regexes) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if (matcher.find()) {
                return map.get(regex);
            }
        }

        if (map.containsKey(value)) {
            return map.get(value);
        }

        throw new IllegalArgumentException("Can't find token");
    }
}