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

public class ParserCalculator {
    private LexicalAnalyzerCalculator lex;

    public Long parse(String is) throws ParseException {
        lex = new LexicalAnalyzerCalculator(is);
        lex.nextToken();
        return expr();
    }

    public Long atom() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // LP
                if (lex.getToken() != TokenCalculator.LP) {
                    throw new ParseException("Expected 'LP', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // expr
                Long value_676420499 = expr();
                // RP
                if (lex.getToken() != TokenCalculator.RP) {
                    throw new ParseException("Expected 'RP', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                return value_676420499;
            case VAR:
                // VAR
                String nVar_995410520 = lex.getBuffer();
                lex.nextToken();
                return Long.parseLong(nVar_995410520);
            default:
                throw new ParseException("Incorrect token atom at position", lex.getPos());
        }
    }
    public Long pow_cont() throws ParseException {
        switch (lex.getToken()) {
            case POW:
                // POW
                if (lex.getToken() != TokenCalculator.POW) {
                    throw new ParseException("Expected 'POW', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // atom
                Long expr_308031486 = atom();
                // pow_cont
                Long cont_43516404 = pow_cont();
                return Math.round(Math.pow(expr_308031486, cont_43516404));
            case EPSILON_Bf11o3bo1V:
                return 1L;
            case MULTIPLY:
                return 1L;
            case DIVISION:
                return 1L;
            case RP:
                return 1L;
            case PLUS:
                return 1L;
            case MINUS:
                return 1L;
            default:
                throw new ParseException("Incorrect token pow_cont at position", lex.getPos());
        }
    }
    public Long pow() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // atom
                Long expr_1934772315 = atom();
                // pow_cont
                Long cont_1319313652 = pow_cont();
                return Math.round(Math.pow(expr_1934772315, cont_1319313652));
            case VAR:
                // atom
                Long expr_1352455684 = atom();
                // pow_cont
                Long cont_582618068 = pow_cont();
                return Math.round(Math.pow(expr_1352455684, cont_582618068));
            default:
                throw new ParseException("Incorrect token pow at position", lex.getPos());
        }
    }
    public Long prod_cont(Long acc) throws ParseException {
        switch (lex.getToken()) {
            case MULTIPLY:
                // MULTIPLY
                if (lex.getToken() != TokenCalculator.MULTIPLY) {
                    throw new ParseException("Expected 'MULTIPLY', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // pow
                Long expr_816570366 = pow();
                // prod_cont
                Long cont_1621789996 = prod_cont(acc * expr_816570366);
                return cont_1621789996;
            case DIVISION:
                // DIVISION
                if (lex.getToken() != TokenCalculator.DIVISION) {
                    throw new ParseException("Expected 'DIVISION', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // pow
                Long expr_761162651 = pow();
                // prod_cont
                Long cont_896684272 = prod_cont(acc / expr_761162651);
                return cont_896684272;
            case EPSILON_Bf11o3bo1V:
                return acc;
            case RP:
                return acc;
            case PLUS:
                return acc;
            case MINUS:
                return acc;
            default:
                throw new ParseException("Incorrect token prod_cont at position", lex.getPos());
        }
    }
    public Long prod() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // pow
                Long expr_1500362598 = pow();
                // prod_cont
                Long cont_456991174 = prod_cont(expr_1500362598);
                return cont_456991174;
            case VAR:
                // pow
                Long expr_925941356 = pow();
                // prod_cont
                Long cont_2097868932 = prod_cont(expr_925941356);
                return cont_2097868932;
            default:
                throw new ParseException("Incorrect token prod at position", lex.getPos());
        }
    }
    public Long expr_cont(Long acc) throws ParseException {
        switch (lex.getToken()) {
            case PLUS:
                // PLUS
                if (lex.getToken() != TokenCalculator.PLUS) {
                    throw new ParseException("Expected 'PLUS', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // prod
                Long expr_1414273927 = prod();
                // expr_cont
                Long cont_1083939804 = expr_cont(acc + expr_1414273927);
                return cont_1083939804;
            case MINUS:
                // MINUS
                if (lex.getToken() != TokenCalculator.MINUS) {
                    throw new ParseException("Expected 'MINUS', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // prod
                Long expr_1083298321 = prod();
                // expr_cont
                Long cont_2079587998 = expr_cont(acc - expr_1083298321);
                return cont_2079587998;
            case EPSILON_Bf11o3bo1V:
                return acc;
            case RP:
                return acc;
            default:
                throw new ParseException("Incorrect token expr_cont at position", lex.getPos());
        }
    }
    public Long expr() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // prod
                Long expr_82025352 = prod();
                // expr_cont
                Long cont_1034590163 = expr_cont(expr_82025352);
                return cont_1034590163;
            case VAR:
                // prod
                Long expr_1091141868 = prod();
                // expr_cont
                Long cont_1687825473 = expr_cont(expr_1091141868);
                return cont_1687825473;
            default:
                throw new ParseException("Incorrect token expr at position", lex.getPos());
        }
    }
}