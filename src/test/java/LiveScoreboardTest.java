import static org.junit.Assert.*;

import com.example.LiveScoreboard;
import com.example.Match;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class LiveScoreboardTest {
    private LiveScoreboard liveScoreboard;
    private Match match;

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalStream = System.out;

    @Before
    public void setUp() {
        liveScoreboard = new LiveScoreboard();
        match = new Match("Team home", "Team away");

        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void testLiveScoreboardInitialization() {
        assertNotNull("LiveScoreboard should be initialized", liveScoreboard);
        assertTrue("Match list should be empty", liveScoreboard.getMatchList().isEmpty());
    }

    @Test
    public void testStartMatch() {
        liveScoreboard.startMatch(match);
        assertTrue(liveScoreboard.getMatchList().contains(match));

        try {
            liveScoreboard.startMatch(null);
        } catch(IllegalArgumentException e) {
            assertEquals("Match cannot be null", e.getMessage());
        }
    }

    @Test
    public void testSetScore() {
        liveScoreboard.setScore(match, 3, 1);
        assertEquals("Home score should be 3", 3, match.getHomeScore());
        assertEquals("Away score should be 1", 1, match.getAwayScore());

        try {
            liveScoreboard.setScore(null, 1, 2);
        } catch(IllegalArgumentException e) {
            assertEquals("Match cannot be null", e.getMessage());
        }
    }

    @Test
    public void testFinishMatch() {
        liveScoreboard.startMatch(match);
        assertTrue(liveScoreboard.getMatchList().contains(match));

        liveScoreboard.finishMatch(match);
        assertFalse(liveScoreboard.getMatchList().contains(match));

        try {
            liveScoreboard.finishMatch(null);
        } catch(IllegalArgumentException e) {
            assertEquals("Match cannot be null", e.getMessage());
        }

        liveScoreboard.finishMatch(match);
        String expectedOutput = "Match already finished" + System.lineSeparator();

        assertEquals(expectedOutput, outputContent.toString());
    }

    @Test
    public void testGetMatchSummary() {
        Match match1 = new Match("England", "Portugal");
        Match match2 = new Match("Italy", "Spain");
        Match match3 = new Match("Germany", "France");
        Match match4 = new Match("Argentina", "South Africa");
        Match match5 = new Match("Brazil", "Uruguay");

        liveScoreboard.startMatch(match1);
        liveScoreboard.startMatch(match2);
        liveScoreboard.startMatch(match3);
        liveScoreboard.startMatch(match4);
        liveScoreboard.startMatch(match5);

        liveScoreboard.setScore(match1, 1, 2);
        liveScoreboard.setScore(match2, 2, 0);
        liveScoreboard.setScore(match3, 2, 1);
        liveScoreboard.setScore(match4, 2, 1);
        liveScoreboard.setScore(match5, 1, 2);


        List<Match> sortedList = liveScoreboard.getMatchSummary();

        assertEquals("Match list is not sorted correctly", match5, sortedList.get(0));
        assertEquals("Match list is not sorted correctly", match4, sortedList.get(1));
        assertEquals("Match list is not sorted correctly", match3, sortedList.get(2));
        assertEquals("Match list is not sorted correctly", match1, sortedList.get(3));
        assertEquals("Match list is not sorted correctly", match2, sortedList.get(4));

        String expectedOutput = "Brazil 1 - 2 Uruguay" + System.lineSeparator() +
                "Argentina 2 - 1 South Africa" + System.lineSeparator() +
                "Germany 2 - 1 France" + System.lineSeparator() +
                "England 1 - 2 Portugal" + System.lineSeparator() +
                "Italy 2 - 0 Spain" + System.lineSeparator();

        assertEquals(expectedOutput, outputContent.toString());
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }
}