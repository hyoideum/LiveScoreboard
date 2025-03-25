package com.example;

public class Main {
    public static void main(String[] args) {
        LiveScoreboard scoreboard = new LiveScoreboard();

        Match match1 = new Match("Italy", "Germany");
        Match match2 = new Match("Argentina", "Japan");
        Match match3 = new Match("Egypt", "Canada");
        Match match4 = new Match("Greece", "Senegal");
        Match match5 = new Match("South Africa", "Australia");

        scoreboard.startMatch(match1);
        scoreboard.startMatch(match2);
        scoreboard.startMatch(match3);
        scoreboard.startMatch(match4);
        scoreboard.startMatch(match5);

        scoreboard.setScore(match1,1, 2);
        scoreboard.setScore(match2,1, 1);
        scoreboard.setScore(match3, 2, 1);
        scoreboard.setScore(match4,3, 1);
        scoreboard.setScore(match5, 2, 2);

        scoreboard.finishMatch(match1);

        Match match6 = new Match("Croatia", "Paraguay");
        scoreboard.startMatch(match6);
        match6.setScore(2,0);

        scoreboard.finishMatch(match1);

        scoreboard.getMatchSummary();
    }
}