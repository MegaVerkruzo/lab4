import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.grunskii.LatexLexer;
import org.grunskii.LatexParser;
import org.grunskii.MyLatexListener;
import org.junit.Assert;
import org.junit.Test;

public class MyLatexListenerTest {
    private static String transformLatex(String latex) {
        LatexLexer lexer = new LatexLexer(CharStreams.fromString(latex));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LatexParser logParser = new LatexParser(tokens);

        ParseTree tree = logParser.entry();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyLatexListener latexListener = new MyLatexListener();
        walker.walk(latexListener, tree);

        return latexListener.getResult();
    }

    @Test
    public void FormulaTest() {
        String latexLine ="$a_i = b_i + x^2$";
        String expectedHtml = "<i>a</i><sub><i>i</i></sub> = <i>b</i><sub><i>i</i></sub> + <i>x</i><sup>2</sup>";
        // instantiate the lexer, the parser, and the walker

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void NoFormulaTest() {
        String latexLine = "$fwefweh";
        String expectedHtml = "$fwefweh";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void EmptyTest() {
        String latexLine = "";
        String expectedHtml = "";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void TestUpperLowerTest() {
        String latexLine = "a_b_c_d^4";
        String expectedHtml = "a_b_c_d^4";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void TestEmptyFormula() {
        String latexLine = "asgwg$$enrogo4b3go_wf24^42";
        String expectedHtml = "asgwgenrogo4b3go_wf24^42";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void TestManyLowers() {
        String latexLine = "_______";
        String expectedHtml = "_______";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void TestManyLowersAndUppersInFormula() {
        String latexLine = "$a_^_^^_1$";
        String expectedHtml = "<i>a</i><sub><sup><sub><sup><sup><sub>1</sub></sup></sup></sub></sup></sub>";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void ManyFormulas() {
        String latexLine = "$abc1414abc$ $a_535$";
        String expectedHtml = "<i>abc</i>1414<i>abc</i> <i>a</i><sub>5</sub>35";

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void smth() {
        String latexLine = "$x_i^2$";
        String expectedHtml = "<i>abc</i>1414<i>abc</i> <i>a</i><sub>5</sub>35";
        System.out.println(transformLatex(latexLine));

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void getResultLower() {
        String latexLine = "$x_{4242}$";
        String expectedHtml = "<i>x</i><sub>4242</sub>";
        System.out.println(transformLatex(latexLine));

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }

    @Test
    public void getResultLowerAndInnerLower() {
        String latexLine = "$x^{42_44^2}$";
        String expectedHtml = "<i>x</i><sup>42<sub>4<sub>2</sup>";
        System.out.println(transformLatex(latexLine));

        Assert.assertEquals(expectedHtml, transformLatex(latexLine));
    }
}
