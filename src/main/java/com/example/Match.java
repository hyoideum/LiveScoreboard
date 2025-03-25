package com.example;

import java.time.LocalDateTime;

public class Match {
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
    }

    public String getHome() {
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

    public void setScore(int scoreHome, int scoreAway) {
        if(scoreHome < 0 || scoreHome > 99 || scoreAway < 0 || scoreAway > 99) {
            throw new IllegalArgumentException("Invalid score!");
        }
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
    }

    public void PrintMatch() {
        System.out.print(homeTeam + " " + scoreHome + " - " + scoreAway + " " + awayTeam);
    }
}
