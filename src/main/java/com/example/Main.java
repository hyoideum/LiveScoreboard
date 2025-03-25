package com.example;

public class Main {
    public static void main(String[] args) {
        Match match1 = new Match("Italy", "Germany");
        Match match2 = new Match("Argentina", "Japan");
        Match match3 = new Match("Egypt", "Canada");

        match1.setScore(1, 2);
        match2.setScore(1, 1);
        match3.setScore(2, 1);

        match1.PrintMatches();
    }
}