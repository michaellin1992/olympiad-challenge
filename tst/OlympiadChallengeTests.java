import OlympiadChallenge.OlympiadChallenge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OlympiadChallengeTests {

    private final OlympiadChallenge olympiadChallenge = new OlympiadChallenge();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testHi() {
        olympiadChallenge.printHi();
        Assert.assertEquals("Hi world!\n", outContent.toString());
    }
}