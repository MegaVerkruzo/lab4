package org.grunskii;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.grunskii.model.NonTerminal;
import org.grunskii.model.Rule;
import org.grunskii.model.RuleArgument;

import java.util.Optional;
import java.util.stream.Collectors;

public class Util {
    public static <T extends ParserRuleContext> String getStrFromContext(T ctx) {
        return ctx.children.stream().map(ParseTree::getText).collect(Collectors.joining()).trim();
    }

    public static Optional<Rule> findEmpty(NonTerminal nonTerminal) {
        return nonTerminal
                .rules()
                .stream()
                .filter(rule -> rule.arguments().isEmpty())
                .findAny();
    }

    public static Optional<Rule> findRule(NonTerminal nonTerminal, String token) {
        return nonTerminal
                .rules()
                .stream()
                .filter(rule -> !rule.arguments().isEmpty())
                .filter(rule -> {
                    RuleArgument argument = rule.arguments().get(0);
                    return argument.isToken() && argument.type().equals(token) ||
                            !argument.isToken() && FirstFollow.first.get(argument.type()).contains(token);
                } )
                .findAny();
    }

    public static NonTerminal getNonTerminalByToken(String token) {
        return InfoClass.nonTerminals.get(token);
    }
}
