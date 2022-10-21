package org.league;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeagueTable {

    Map<String, Integer> teamPoints = new HashMap<>();
    Map<String, Team> teams = new HashMap<>();

    public String[] splitMatchResults(String results){
        String[] matchResults = results.split(",");
        return matchResults;
    }

    public Map<String, Integer> calculateTeamScores(String[] matchResults){
        String firstTeamName = matchResults[0].substring(0, matchResults[0].length() - 2);
        int firstTeamScore = Integer.parseInt(matchResults[0].substring(matchResults[0].length() - 1));
        int firstTeamPoints = 0;

        String secondTeamName = matchResults[1].substring(1, matchResults[1].length() - 2);
        int secondTeamScore = Integer.parseInt(matchResults[1].substring(matchResults[1].length() - 1));
        int secondTeamPoints = 0;

        if (firstTeamScore > secondTeamScore) {
            firstTeamPoints = 3;
            secondTeamPoints = 0;
        } else if (firstTeamScore == secondTeamScore) {
            firstTeamPoints = 1;
            secondTeamPoints = 1;
        } else {
            firstTeamPoints = 0;
            secondTeamPoints = 3;
        }

        teamPoints.put(firstTeamName,firstTeamPoints);
        teamPoints.put(secondTeamName, secondTeamPoints);

        return teamPoints;
    }

    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        Scanner in = new Scanner(System.in);
        String matchScores = in.nextLine();
        //app while loop
        String[] matchResults = leagueTable.splitMatchResults(matchScores);

        System.out.println(matchResults[0]);




        in.close();
    }
}