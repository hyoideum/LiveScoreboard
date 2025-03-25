package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LiveScoreboard {
    private final List<Match> matchList;

    public LiveScoreboard() {
        matchList = new ArrayList<>();
    }

    //start a new match, setting initial score to 0 – 0 and adding it the scoreboard
    public void startMatch(Match match) {
        if(match == null) {
            throw new IllegalArgumentException("Match cannot be null");
        }
        matchList.add(match);
    }

    //update match score
    public void setScore(Match match, int homeScore, int awayScore) {
        if(match == null) {
            throw new IllegalArgumentException("Match cannot be null");
        }
        match.setScore(homeScore, awayScore);
    }

    //finish match in progress and remove it from the scoreboard
    public void finishMatch(Match match) {
        if(match == null) {
            throw new IllegalArgumentException("Match cannot be null");
        }
        matchList.remove(match);
    }

    //get summary of matches ordered by score, in case of same scores ordered by the most recently started match in the scoreboard
    public void getMatchSummary() {
        matchList.sort(Comparator
                .comparing(Match::getTotalScore)
                .thenComparing(Match::getNum)
                .reversed());

        for(Match m : matchList) {
            System.out.println(m.getHomeTeam() + " " + m.getHomeScore() + " - " + m.getAwayScore() + " " + m.getAwayTeam());
        }
    }
}
