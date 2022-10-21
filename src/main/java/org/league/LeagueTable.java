package org.league;

import java.util.*;

public class LeagueTable {

    Map<String, Integer> teamPoints = new HashMap<>();
    Map<String, Team> teams = new HashMap<>();
    List<Team> tableLog;

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

    public List<Team> updateLeagueTable(Map<String,Integer> teamScores){
        for(Map.Entry<String, Integer> teamScore : teamScores.entrySet()){

            if (!teams.containsKey(teamScore.getKey())) {
                teams.put(teamScore.getKey(), new Team(teamScore.getKey(), teamScore.getValue()));
            } else {
                int points = teams.get(teamScore.getKey()).getPoints();
                points = points + teamScore.getValue();
                teams.get(teamScore.getKey()).setPoints(points);
            }
        }


        Map<String, Team> sortedMap= new TreeMap<>(teams);

        tableLog = new ArrayList<>(sortedMap.values());
        Collections.sort(tableLog,Collections.reverseOrder());

        return tableLog;
    }

    public void printTable(){
        int counter = 1;
        for (int i=0; i < tableLog.size() ; i++) {
            tableLog.get(i).setPosition(counter);
            if (i != 0 && tableLog.get(i).getPoints() == tableLog.get(i - 1).getPoints()) {
                tableLog.get(i).setPosition(tableLog.get(i - 1).getPosition());
            }
            System.out.println(tableLog.get(i).getPosition()+ ". " + tableLog.get(i).getName() + ", " + tableLog.get(i).getPoints() + "  pts");
            counter++;
        }
    }

    public void clearMatchResults(){
        teamPoints.clear();
    }

    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        Scanner in = new Scanner(System.in);
        String matchScores = in.nextLine();

        while(!matchScores.equals("table")) {

            String[] matchResults = leagueTable.splitMatchResults(matchScores);
            Map<String, Integer> points = leagueTable.calculateTeamScores(matchResults);
            List<Team> table =  leagueTable.updateLeagueTable(points);
            leagueTable.clearMatchResults();
            System.out.println("Enter match results or  type 'table' to display league table");
            matchScores = in.nextLine();

        }

        leagueTable.printTable();
        in.close();
    }
}

/*Lions 3, Snakes 3
Tarantulas 1, FC Awesome 0
Lions 1, FC Awesome 1
Tarantulas 3, Snakes 1
Lions 4, Grouches 0
Expected output:
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts

 */