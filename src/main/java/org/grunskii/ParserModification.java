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

public class ParserModification {
    private LexicalAnalyzerModification lex;

    public Long parse(String is) throws ParseException {
        lex = new LexicalAnalyzerModification(is);
        lex.nextToken();
        return expr();
    }

    static long factorial(long n) {
        if (n <= 0) {
            return 1L;
        }
        return n * factorial(n - 1);
    }

    static long two_factorial(long n) {
        if (n <= 0) {
            return 1L;
        }
        return n * two_factorial(n - 2);
    }


    public Long atom() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // LP
                if (lex.getToken() != TokenModification.LP) {
                    throw new ParseException("Expected 'LP', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // expr
                Long value_1974255220 = expr();
                // RP
                if (lex.getToken() != TokenModification.RP) {
                    throw new ParseException("Expected 'RP', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                return value_1974255220;
            case VAR:
                // VAR
                String nVar_1373602856 = lex.getBuffer();
                lex.nextToken();
                return Long.parseLong(nVar_1373602856);
            default:
                throw new ParseException("Incorrect token atom at position", lex.getPos());
        }
    }
    public Long unary_cont(Long acc) throws ParseException {
        switch (lex.getToken()) {
            case TWO_FACTORIAL:
                // TWO_FACTORIAL
                if (lex.getToken() != TokenModification.TWO_FACTORIAL) {
                    throw new ParseException("Expected 'TWO_FACTORIAL', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // unary_cont
                Long cont_686795121 = unary_cont(two_factorial(acc));
                return cont_686795121;
            case FACTORIAL:
                // FACTORIAL
                if (lex.getToken() != TokenModification.FACTORIAL) {
                    throw new ParseException("Expected 'FACTORIAL', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // unary_cont
                Long cont_816544350 = unary_cont(factorial(acc));
                return cont_816544350;
            case EPSILON_Bf11o3bo1V:
                return acc;
            case POW:
                return acc;
            case MULTIPLY:
                return acc;
            case DIVISION:
                return acc;
            case RP:
                return acc;
            case PLUS:
                return acc;
            case MINUS:
                return acc;
            default:
                throw new ParseException("Incorrect token unary_cont at position", lex.getPos());
        }
    }
    public Long unary() throws ParseException {
        switch (lex.getToken()) {
            case LP:
                // atom
                Long atom_1839018628 = atom();
                // unary_cont
                Long cont_1757352272 = unary_cont(atom_1839018628);
                return cont_1757352272;
            case VAR:
                // atom
                Long atom_1218074149 = atom();
                // unary_cont
                Long cont_5639276 = unary_cont(atom_1218074149);
                return cont_5639276;
            case MINUS:
                // MINUS
                if (lex.getToken() != TokenModification.MINUS) {
                    throw new ParseException("Expected 'MINUS', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // unary
                Long unary_765501913 = unary();
                return - unary_765501913;
            default:
                throw new ParseException("Incorrect token unary at position", lex.getPos());
        }
    }
    public Long pow_cont() throws ParseException {
        switch (lex.getToken()) {
            case POW:
                // POW
                if (lex.getToken() != TokenModification.POW) {
                    throw new ParseException("Expected 'POW', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // unary
                Long expr_207528734 = unary();
                // pow_cont
                Long cont_1216590251 = pow_cont();
                return Math.round(Math.pow(expr_207528734, cont_1216590251));
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
                // unary
                Long expr_419347366 = unary();
                // pow_cont
                Long cont_1644457111 = pow_cont();
                return Math.round(Math.pow(expr_419347366, cont_1644457111));
            case VAR:
                // unary
                Long expr_726589116 = unary();
                // pow_cont
                Long cont_1652171106 = pow_cont();
                return Math.round(Math.pow(expr_726589116, cont_1652171106));
            case MINUS:
                // unary
                Long expr_726673713 = unary();
                // pow_cont
                Long cont_653319565 = pow_cont();
                return Math.round(Math.pow(expr_726673713, cont_653319565));
            default:
                throw new ParseException("Incorrect token pow at position", lex.getPos());
        }
    }
    public Long prod_cont(Long acc) throws ParseException {
        switch (lex.getToken()) {
            case MULTIPLY:
                // MULTIPLY
                if (lex.getToken() != TokenModification.MULTIPLY) {
                    throw new ParseException("Expected 'MULTIPLY', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // pow
                Long expr_589284358 = pow();
                // prod_cont
                Long cont_1118416414 = prod_cont(acc * expr_589284358);
                return cont_1118416414;
            case DIVISION:
                // DIVISION
                if (lex.getToken() != TokenModification.DIVISION) {
                    throw new ParseException("Expected 'DIVISION', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // pow
                Long expr_1372797460 = pow();
                // prod_cont
                Long cont_1726384846 = prod_cont(acc / expr_1372797460);
                return cont_1726384846;
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
                Long expr_1239773653 = pow();
                // prod_cont
                Long cont_613584679 = prod_cont(expr_1239773653);
                return cont_613584679;
            case VAR:
                // pow
                Long expr_2010322052 = pow();
                // prod_cont
                Long cont_1547603589 = prod_cont(expr_2010322052);
                return cont_1547603589;
            case MINUS:
                // pow
                Long expr_1769493062 = pow();
                // prod_cont
                Long cont_1043827100 = prod_cont(expr_1769493062);
                return cont_1043827100;
            default:
                throw new ParseException("Incorrect token prod at position", lex.getPos());
        }
    }
    public Long expr_cont(Long acc) throws ParseException {
        switch (lex.getToken()) {
            case PLUS:
                // PLUS
                if (lex.getToken() != TokenModification.PLUS) {
                    throw new ParseException("Expected 'PLUS', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // prod
                Long expr_108748238 = prod();
                // expr_cont
                Long cont_784836906 = expr_cont(acc + expr_108748238);
                return cont_784836906;
            case MINUS:
                // MINUS
                if (lex.getToken() != TokenModification.MINUS) {
                    throw new ParseException("Expected 'MINUS', but found '" + lex.getToken() + "' on position: ", lex.getPos());
                }
                lex.nextToken();
                // prod
                Long expr_1895873982 = prod();
                // expr_cont
                Long cont_314876398 = expr_cont(acc - expr_1895873982);
                return cont_314876398;
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
                Long expr_1953011504 = prod();
                // expr_cont
                Long cont_758647224 = expr_cont(expr_1953011504);
                return cont_758647224;
            case VAR:
                // prod
                Long expr_424689503 = prod();
                // expr_cont
                Long cont_1610641720 = expr_cont(expr_424689503);
                return cont_1610641720;
            case MINUS:
                // prod
                Long expr_1931779779 = prod();
                // expr_cont
                Long cont_651649498 = expr_cont(expr_1931779779);
                return cont_651649498;
            default:
                throw new ParseException("Incorrect token expr at position", lex.getPos());
        }
    }
}