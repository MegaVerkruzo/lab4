package org.grunskii;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.stream.Collectors;

public class Util {
    public static <T extends ParserRuleContext> String getStrFromContext(T ctx) {
        return ctx.children.stream().map(ParseTree::getText).collect(Collectors.joining());
    }
}
