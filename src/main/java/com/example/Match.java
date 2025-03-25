package com.example;

import java.time.LocalDateTime;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int scoreHome;
    private int scoreAway;
    private final LocalDateTime matchStart;
    private final int num;

    private static int counter;

    public Match(String homeTeam, String awayTeam) {
        if(homeTeam == null || homeTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Home team name cannot be empty");
        }

        if(awayTeam == null || awayTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Away team name cannot be empty");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.scoreHome = 0;
        this.scoreAway = 0;
        this.matchStart = LocalDateTime.now();
        this.num = counter++;
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

    public int getTotalScore() {
        return scoreHome + scoreAway;
    }

    public int getNum() {
        return num;
    }

    public void setScore(int scoreHome, int scoreAway) {
        if(scoreHome < 0 || scoreHome > 99 || scoreAway < 0 || scoreAway > 99) {
            throw new IllegalArgumentException("Invalid score!");
        }
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
    }
}