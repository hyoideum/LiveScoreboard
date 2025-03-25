import com.example.Match;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MatchTest {

    private Match match;

    @Before
    public void setUp() {
        match = new Match("Home Team", "Away Team");
    }

    @Test
    public void testMatchInitialization() {
        assertNotNull("Match should be initialized", match);
        assertEquals("Home team should be 'Home Team'", "Home Team", match.getHomeTeam());
        assertEquals("Away team should be 'Away Team'", "Away Team", match.getAwayTeam());
        assertEquals("Initial home score should be 0", 0, match.getHomeScore());
        assertEquals("Initial away score should be 0", 0, match.getAwayScore());
    }

    @Test
    public void testInvalidTeamNames() {
        try{
            new Match(null, "Away Team");
        } catch (IllegalArgumentException e) {
            assertEquals("Home team name cannot be empty", e.getMessage());
        }

        try{
            new Match("Home Team", null);
        } catch (IllegalArgumentException e) {
            assertEquals("Away team name cannot be empty", e.getMessage());
        }

        try{
            new Match("", "Away Team");
        } catch (IllegalArgumentException e) {
            assertEquals("Home team name cannot be empty", e.getMessage());
        }

        try{
            new Match("Home Team", "");
        } catch (IllegalArgumentException e) {
            assertEquals("Away team name cannot be empty", e.getMessage());
        }
    }

    @Test
    public void testSetScore() {
        match.setScore(1, 2);

        assertEquals("Home score should be 1", 1, match.getHomeScore());
        assertEquals("Away score should be 2", 2, match.getAwayScore());
    }

    @Test
    public void testSetInvalidScore() {
        try {
            match.setScore(-1, 2);
            fail("Score cannot be negative");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid score!", e.getMessage());
        }

        try {
            match.setScore(102, 2);
            fail("Score cannot be over 99");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid score!", e.getMessage());
        }

        try {
            match.setScore(1, -2);
            fail("Score cannot be negative");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid score!", e.getMessage());
        }

        try {
            match.setScore(1, 202);
            fail("Score cannot be over 99");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid score!", e.getMessage());
        }
    }

    @Test
    public void testGetTotalScore() {
        match.setScore(1,2);
        assertEquals("Total score should be 3", 3, match.getTotalScore());
    }

    @Test
    public void testGetNum() {
        Match match2 = new Match("Home Team 2", "Away Team 2");
        assertNotEquals("Match number should not be the same", match.getNum(), match2.getNum());
    }
}
