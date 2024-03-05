package org.grunskii;

public class MyLatexListener extends LatexBaseListener {
    private StringBuilder sb = new StringBuilder();

    public String getResult() {
        return sb.toString();
    }

    @Override
    public void enterEntry(LatexParser.EntryContext ctx) {
        System.out.println("enterEntry");
        sb = new StringBuilder();
    }

    @Override
    public void exitEntry(LatexParser.EntryContext ctx) {
        System.out.println("exitEntry");
        System.out.println(sb.toString());
    }

    @Override
    public void enterLower(LatexParser.LowerContext ctx) {
        System.out.println("enterLower");
        sb.append("<sub>");
    }

    @Override
    public void exitLower(LatexParser.LowerContext ctx) {
        System.out.println("exitLower");
        sb.append("</sub>");
    }

    @Override
    public void enterUpper(LatexParser.UpperContext ctx) {
        System.out.println("enterUpper");
        sb.append("<sup>");
    }

    @Override
    public void exitUpper(LatexParser.UpperContext ctx) {
        System.out.println("exitUpper");
        sb.append("</sup>");
    }

    @Override
    public void enterISymbol(LatexParser.ISymbolContext ctx) {
        System.out.println("enterISymbol");
        sb.append("<i>" + ctx.getText());
    }

    @Override
    public void exitISymbol(LatexParser.ISymbolContext ctx) {
        System.out.println("exitISymbol");
        sb.append("</i>");
    }

    @Override
    public void enterIText(LatexParser.ITextContext ctx) {
        System.out.println("enterIText");
        sb.append("<i>" + ctx.getText());
    }

    @Override
    public void exitIText(LatexParser.ITextContext ctx) {
        System.out.println("exitIText");
        sb.append("</i>");
    }

    @Override
    public void enterText(LatexParser.TextContext ctx) {
        System.out.println("enterText");
        sb.append(ctx.getText());
    }

    @Override
    public void enterSymbol(LatexParser.SymbolContext ctx) {
        System.out.println("enterSymbol");
        sb.append(ctx.getText());
    }
}
