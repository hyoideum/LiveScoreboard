package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Match {
    private static List<Match> matchList = new ArrayList<>();

    private String homeTeam;
    private String awayTeam;
    private int scoreHome;
    private int scoreAway;
    private LocalDateTime matchStart;

    public Match(String home, String away) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.scoreHome = 0;
        this.scoreAway = 0;
        this.matchStart = LocalDateTime.now();
        matchList.add(this);
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return scoreHome;
    }

    public int getAwayScore() {
        return scoreAway;
    }

    public LocalDateTime getStart() {
        return matchStart;
    }

    private int getTotalScore() {
        return scoreHome + scoreAway;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setScore(int scoreHome, int scoreAway) {
        if(scoreHome < 0 || scoreHome > 99 || scoreAway < 0 || scoreAway > 99) {
            throw new IllegalArgumentException("Invalid score!");
        }
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        SortList();
    }

    public void finishMatch() {
        matchList.remove(this);
    }

    private void SortList() {
        matchList.sort(Comparator
                .comparing(Match::getTotalScore)
                .thenComparing(Match::getStart)
                .reversed());
    }

    public void PrintMatch() {
        System.out.println(homeTeam + " " + scoreHome + " - " + scoreAway + " " + awayTeam);
    }

    public void PrintMatches() {
        for(Match m : matchList) {
            m.PrintMatch();
        }
    }
}
