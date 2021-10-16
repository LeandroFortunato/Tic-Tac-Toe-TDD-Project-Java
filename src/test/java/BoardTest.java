import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BoardTest {
    private String[] input;
    private String[] expectedOutput;


    public BoardTest(Object[] pInput, Object[] pExpectedOutput) {
        this.input = Arrays.asList(pInput).toArray(new String[pInput.length]);
        this.expectedOutput = Arrays.asList(pExpectedOutput).toArray(new String[pExpectedOutput.length]);;
    }


    @Parameterized.Parameters
    public static Collection DifferentGamesWithExpectedResults() {

        return Arrays.asList(new Object[][][] {

                {new Object [] {"O", "O", "O",
                                "X", "X", "O",    //  <---- strike
                                "X", " ", " "},
                        new Object[] {"Winner player: O - Strike: Horizontal 0"}},

                {new Object [] {"X", "O", "O",
                                "X", "X", "O",    //  <---- strike
                                "O", "O", "X"},
                        new Object[] {"Winner player: X - Strike: Diagonal 0"}},

                {new Object [] {"X", " ", " ",
                                "X", "X", "O",    //  <---- strike
                                "O", "O", "O"},
                        new Object[] {"Winner player: O - Strike: Horizontal 2"}},

                {new Object [] {"O", "O", "X",
                                "O", "X", "X",    //  <---- strike
                                "X", "O", "X"},
                        new Object[] {"Winner player: X - Strike: Vertical 2"}},

                {new Object [] {"O", "X", "X",
                                "O", "O", "O",    //  <---- strike
                                "X", "O", "X"},
                        new Object[] {"Winner player: O - Strike: Horizontal 1"}},

                {new Object [] {"X", " ", " ",
                                "X", " ", "O",    //  <---- strike
                                "X", "O", "O"},
                        new Object[] {"Winner player: X - Strike: Vertical 0"}},
                {new Object [] {"O", " ", "X",
                                "O", "X", "O",    //  <---- strike
                                "X", "O", "X"},
                        new Object[] {"Winner player: X - Strike: Diagonal 1"}},
        });
    }

    @Test
    public void CheckIfExpectedResultsAreCorrect() {

        Board game = new Board();

        System.out.println("------------------------------------------------");
        System.out.println("End of Game");

        for (int i = 0; i < this.input.length; i=i+3) {
            System.out.println(this.input[i]+ "  "+
                                this.input[i+1]+ "  "+
                                this.input[i+2]);
        }
        System.out.println("Expected: " +  this.expectedOutput[0]);

        String[] result  = game.CheckIfAnybodyWon(this.input);
        System.out.println("Got.....: " +  result[0]);
        assertEquals(true,(this.expectedOutput[0].equals(result[0])));
    }
}

