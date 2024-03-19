import org.grunskii.ParserCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class CalculatorTest {
    private final ParserCalculator parser = new ParserCalculator();

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
        Assert.assertEquals(-82L, (long) parser.parse("42 * 2 - 4 * 42"));
    }
}
