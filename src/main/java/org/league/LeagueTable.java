package org.league;

import java.util.Scanner;

public class LeagueTable {

    public String[] splitMatchResults(String results){
        String[] matchResults = results.split(",");
        return matchResults;
    }


    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        Scanner in = new Scanner(System.in);
        String matchScores = in.nextLine();
        String[] matchResults = leagueTable.splitMatchResults(matchScores);

        System.out.println(matchResults[0]);

        in.close();
    }
}