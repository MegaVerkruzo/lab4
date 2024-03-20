import org.grunskii.ParserModification;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class ModificationTest {
    private final ParserModification parser = new ParserModification();

    @Test
    public void check2Plus2() throws ParseException {
        Assert.assertEquals(4L, (long) parser.parse("(  ((2)+2))"));
        Assert.assertEquals(4L, (long) parser.parse("   2+2   "));
        Assert.assertEquals(4L, (long) parser.parse("2 + 2"));
        Assert.assertEquals(4L, (long) parser.parse("2+2"));
        Assert.assertEquals(4L, (long) parser.parse("(2)+2"));
        Assert.assertEquals(4L, (long) parser.parse("   (   2+2)  "));
        Assert.assertEquals(4L, (long) parser.parse("2         \n" +
                " +2"));
    }

    @Test
    public void checkMinus() throws ParseException {
        Assert.assertEquals(53L, (long) parser.parse("55 -2"));
        Assert.assertEquals(50L, (long) parser.parse("55 -2-1-1-1"));
        Assert.assertEquals(52L, (long) parser.parse("(55 -2)-(1-1)-1"));
        Assert.assertEquals(52L, (long) parser.parse("(55 -2)-(1-1)-1"));
    }

    @Test
    public void checkVar() throws ParseException {
        Assert.assertEquals(0L, (long) parser.parse("0"));
        Assert.assertEquals(0L, (long) parser.parse("  0 "));
    }

    @Test
    public void checkPlusMinus() throws ParseException {
        Assert.assertEquals(16L, (long) parser.parse("10+4 -1 +(1- 1) + (4-1)"));
        Assert.assertEquals(-251690L, (long) parser.parse("532 - 252222"));
    }

    @Test
    public void checkFormulas() throws ParseException {
        Assert.assertEquals(-84L, (long) parser.parse("42 * 2 - 4 * 42"));
        Assert.assertEquals(10L, (long) parser.parse("20 / 2"));
        Assert.assertEquals(15L, (long) parser.parse("20 / 2 * 3 / 2"));
    }

    @Test
    public void checkPow() throws ParseException {
        Assert.assertEquals(16L, (long) parser.parse("2 ** 4"));
        Assert.assertEquals(64L, (long) parser.parse("2 ** 4 * 4"));
        Assert.assertEquals(65536L, (long) parser.parse("2 ** (4 * 4)"));
    }

    @Test
    public void testFactorial() throws ParseException {
        Assert.assertEquals(1L, (long) parser.parse("(-1)!"));
        Assert.assertEquals(1L, (long) parser.parse("0!"));
        Assert.assertEquals(1L, (long) parser.parse("1!"));
        Assert.assertEquals(2L, (long) parser.parse("2!"));
        Assert.assertEquals(6L, (long) parser.parse("3!"));
        Assert.assertEquals(3628800L, (long) parser.parse("10!"));
        Assert.assertEquals(24L, (long) parser.parse("(((4)) !)"));
    }

    @Test
    public void testFactorial2() throws ParseException {
        Assert.assertEquals(1L, (long) parser.parse("1!!"));
        Assert.assertEquals(2L, (long) parser.parse("2!!"));
        Assert.assertEquals(3L, (long) parser.parse("3!!"));
        Assert.assertEquals(8L, (long) parser.parse("4!!"));
        Assert.assertEquals(15L, (long) parser.parse("5!!"));
    }

    @Test
    public void testUnaryMinus() throws ParseException {
        Assert.assertEquals(-1, (long) parser.parse("-1"));
        Assert.assertEquals(-1, (long) parser.parse("   -1"));
        Assert.assertEquals(-1, (long) parser.parse("   -   1   "));
        Assert.assertEquals(-554, (long) parser.parse("-552 +42-44"));
        Assert.assertEquals(-65, (long) parser.parse("   - 23 -   42"));
    }

    @Test
    public void testMultiFactorials() throws ParseException {
        Assert.assertEquals(-6L, (long) parser.parse("- 3 !!!"));
        Assert.assertEquals(-3L, (long) parser.parse("- 3 !!!!!!"));
        Assert.assertEquals(-6L, (long) parser.parse("- 3 !"));
    }

    @Test
    public void testAddition() throws ParseException {
        Assert.assertEquals(5L, (long) parser.parse("2 + 3"));
        Assert.assertEquals(10L, (long) parser.parse("5 + 5"));
        Assert.assertEquals(-8L, (long) parser.parse("-10 + 2"));
    }

    @Test
    public void testSubtraction() throws ParseException {
        Assert.assertEquals(3L, (long) parser.parse("5 - 2"));
        Assert.assertEquals(-7L, (long) parser.parse("-5 - 2"));
        Assert.assertEquals(15L, (long) parser.parse("20 - 5"));
    }

    @Test
    public void testMultiplication() throws ParseException {
        Assert.assertEquals(6L, (long) parser.parse("2 * 3"));
        Assert.assertEquals(-12L, (long) parser.parse("-4 * 3"));
        Assert.assertEquals(0L, (long) parser.parse("0 * 100"));
    }

    @Test
    public void testDivision() throws ParseException {
        Assert.assertEquals(4L, (long) parser.parse("12 / 3"));
        Assert.assertEquals(-2L, (long) parser.parse("-8 / 4"));
        Assert.assertEquals(5L, (long) parser.parse("25 / 5"));
    }

    @Test
    public void testParentheses() throws ParseException {
        Assert.assertEquals(10L, (long) parser.parse("(2 + 3) * 2"));
        Assert.assertEquals(13L, (long) parser.parse("2 * (3 + 4) - 1"));
        Assert.assertEquals(4L, (long) parser.parse("-2 * (3 - 5)"));
    }

    @Test
    public void testFactorial22() throws ParseException {
        Assert.assertEquals(120L, (long) parser.parse("5!"));
        Assert.assertEquals(720L, (long) parser.parse("6!"));
        Assert.assertEquals(1L, (long) parser.parse("0!"));
    }

    @Test
    public void testDivisionAndUnaryMinus() throws ParseException {
        Assert.assertEquals(-3L, (long) parser.parse("-6 / 2"));
        Assert.assertEquals(4L, (long) parser.parse("-8 / -2"));
    }

    @Test
    public void testComplexExpression() throws ParseException {
        Assert.assertEquals(15L, (long) parser.parse("(5 + 3) * 2 - 1"));
        Assert.assertEquals(10L, (long) parser.parse("10! / 9!"));
    }

    @Test
    public void strangeTests() throws ParseException {
        Assert.assertEquals(-10L, (long) parser.parse("10! / ( - 9!)"));
        Assert.assertEquals(-8L, (long) parser.parse("(10 - 2)! / ( - 7!)"));
        Assert.assertEquals(8L, (long) parser.parse(" - - - (10 - 2)! / ( - 7!)"));
    }
}

