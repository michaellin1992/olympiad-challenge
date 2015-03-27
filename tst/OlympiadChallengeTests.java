import OlympiadChallenge.OlympiadChallenge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OlympiadChallengeTests {

    private final OlympiadChallenge olympiadChallenge = new OlympiadChallenge();

    @Test
    public void testFigure1() {
        System.out.println("Running Figure 1 Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(1, 1, "1");
    }

    @Test
    public void testFigure2() {
        System.out.println("Running Figure 2 Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(1, 2, "1,1");
    }

    @Test
    public void testFigure3() {
        System.out.println("Running Figure 3 Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(1, 1, "2");
    }

    @Test
    public void testFigure4() {
        System.out.println("Running Figure 4 Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(2, 1, "1:1");
    }

    @Test
    public void testFigure5() {
        System.out.println("Running Figure 5 Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(3, 4, "2,2,1,2:2,2,1,1:3,2,1,2");
    }

    @Test
    public void testPyramid() {
        System.out.println("Running Pyramid Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(5, 5, "1,1,1,1,1:1,2,2,2,1:1,2,3,2,1:1,2,2,2,1:1,1,1,1,1");
    }
    
    
    @Test
    public void testHoles() {
        System.out.println("Running Holes Test");
        System.out.println("Program printed this picture:");
        olympiadChallenge.generateArt(5, 5, "1,1,1,1,0:1,2,2,2,1:1,2,3,2,0:1,2,2,2,1:1,1,0,1,1");
    }
}