package org.grunskii;

import org.antlr.v4.runtime.ParserRuleContext;
import org.grunskii.model.Attribute;
import org.grunskii.model.NonTerminal;
import org.grunskii.model.Rule;
import org.grunskii.model.RuleArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImportListener extends ParserBaseListener {
    @Override
    public void enterImportList(ParserParser.ImportListContext ctx) {
        String packageClass = Util.getStrFromContext(ctx.string());
        InfoClass.addImport("import " + packageClass + ";");
    }

    @Override
    public void enterTokenList(ParserParser.TokenListContext ctx) {
        String tokenKey = Util.getStrFromContext(ctx.tokenName().string());
        String value;
        boolean isRegex = false;
        if (ctx.symbols() != null) {
            value = Util.getStrFromContext(ctx.symbols());
        } else if (ctx.regexp() != null) {
            isRegex = true;
            value = Util.getStrFromContext(ctx.regexp().symbols());
        } else {
            throw new IllegalArgumentException("tokenValue is null");
        }

        InfoClass.addToken(tokenKey, value, isRegex);
    }

    @Override
    public void enterRuleList(ParserParser.RuleListContext ctx) {
        String key = Util.getStrFromContext(ctx.string());

        List<Attribute> attributes = new ArrayList<>();
        ParserParser.ArgumentListContext argumentsContext = ctx.argumentList();
        while (argumentsContext.resultArgument() == null) {
            attributes.add(new Attribute(
                    Util.getStrFromContext(argumentsContext.argument().string(0)),
                    Util.getStrFromContext(argumentsContext.argument().string(1))
            ));
            argumentsContext = argumentsContext.argumentList();
        }
        String resultType = Util.getStrFromContext(argumentsContext.resultArgument().string());

        NonTerminal nonTerminal = new NonTerminal(
                key, attributes, resultType, new ArrayList<>()
        );

        InfoClass.addRule(key, nonTerminal);
    }

    @Override
    public void enterSubRuleList(ParserParser.SubRuleListContext ctx) {
        ParserRuleContext needContext = ctx;
        while (needContext instanceof ParserParser.SubRuleListContext) {
            if (ctx.parent instanceof ParserParser.RuleListContext) {
                needContext = (ParserParser.RuleListContext) ctx.parent;
            } else {
                needContext = (ParserRuleContext) needContext.parent;
            }
        }

        String getRuleName = Util.getStrFromContext(((ParserParser.RuleListContext) needContext).string());

        List<RuleArgument> arguments = new ArrayList<>();
        ParserParser.SubRuleArgumentListContext subRuleArgumentListContext = ctx.subRuleArgumentList();
        while (subRuleArgumentListContext != null) {
            if (subRuleArgumentListContext.tokenName() != null) {
                arguments.add(new RuleArgument(
                        true,
                        null,
                        Util.getStrFromContext(subRuleArgumentListContext.tokenName().string()),
                        List.of()
                ));
            } else if (subRuleArgumentListContext.string() != null && subRuleArgumentListContext.type() != null) {
                arguments.add(getRuleArgumentWithAttributes(subRuleArgumentListContext));
            } else {
                throw new IllegalArgumentException("Incorrect parser.file in rule");
            }
            subRuleArgumentListContext = subRuleArgumentListContext.subRuleArgumentList();
        }

        InfoClass.addSubRuleToRule(getRuleName, new Rule(arguments, Util.getStrFromContext(ctx.symbols())));
    }

    @Override
    public void exitEntry(ParserParser.EntryContext ctx) {
        List<String> list = InfoClass.orderNonTerminals;
        list.addAll(InfoClass.nonTerminals.keySet());
        Collections.reverse(list);
    }

    private RuleArgument getRuleArgumentWithAttributes(ParserParser.SubRuleArgumentListContext ctx) {
        String nameRule = Util.getStrFromContext(ctx.string());

        if (ctx.type().tokenName() != null) {
            return new RuleArgument(true, nameRule,
                    Util.getStrFromContext(ctx.type().tokenName().string()), List.of()
            );
        } else if (ctx.type().string() != null && ctx.type().functionArguments() == null) {
            return new RuleArgument(false, nameRule,
                    Util.getStrFromContext(ctx.type().string()), List.of()
            );
        } else if (ctx.type().string() != null && ctx.type().functionArguments() != null) {
            List<String> attributes = new ArrayList<>();
            ParserParser.FunctionArgumentsContext functionArgumentsContext = ctx.type().functionArguments();

            while (functionArgumentsContext != null) {
                attributes.add(Util.getStrFromContext(functionArgumentsContext.symbols()));
                functionArgumentsContext = functionArgumentsContext.functionArguments();
            }

            return new RuleArgument(false, nameRule, Util.getStrFromContext(ctx.type().string()), attributes);
        } else {
            throw new IllegalArgumentException("Can't parse rule attribute arguments");
        }
    }
}
