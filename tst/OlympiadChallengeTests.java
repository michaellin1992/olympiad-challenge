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
        // System.setOut(new PrintStream(outContent));
        // System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUp() {
        //    System.setOut(null);
        //System.setErr(null);
    }

    @Test
    public void testOneBlock() {
        System.out.println("Running OneBlock test");
        System.out.println("Expecting this picture:");
        System.out.println("..+---+\n./   /|\n+---+ |\n|   | +\n|   |/.\n+---+..");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(3, 4, "2,2,1,2:2,2,1,1:3,2,1,2");
        //olympiadChallenge.generateArt(2, 2, "2,2:2,2");
        System.err.println("test err");
        //Assert.assertEquals("Hi world!\n", outContent.toString());
    }
}