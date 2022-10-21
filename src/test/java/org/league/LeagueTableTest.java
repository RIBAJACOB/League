package org.league;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableTest {

    @Test
    void arrayLengthTest(){
        var leagueTable = new LeagueTable();
        String input = "Lions 3, Snakes 3";
        String[] resultsArray = leagueTable.splitMatchResults(input);

        assertEquals(2,resultsArray.length);
    }
    
    @Test
    void arrayContentsTest(){
        var leagueTable = new LeagueTable();
        String input = "Lions 3, Snakes 3";
        String[] resultsArray = leagueTable.splitMatchResults(input);

        assertEquals("Lions 3",resultsArray[0]);
        assertEquals(" Snakes 3",resultsArray[1]);
        
    }

    @Test
    void sharedPointsTest(){
        var leagueTable = new LeagueTable();
        String[] matchResults = {"Lions 3"," Snakes 3"};
        Map<String, Integer> teamPoints = new HashMap<>();

        teamPoints = leagueTable.calculateTeamScores(matchResults);

        assertEquals(1,teamPoints.get("Lions"));
        assertEquals(1,teamPoints.get("Snakes"));

    }

    @Test
    void loserPointsTest(){
        var leagueTable = new LeagueTable();
        String[] matchResults = {"Lions 1"," Snakes 3"};
        Map<String, Integer> teamPoints = new HashMap<>();

        teamPoints = leagueTable.calculateTeamScores(matchResults);

        assertEquals(0,teamPoints.get("Lions"));
    }
    @Test
    void winnerPointsTest(){
        var leagueTable = new LeagueTable();
        String[] matchResults = {"Lions 1"," Snakes 3"};
        Map<String, Integer> teamPoints = new HashMap<>();

        teamPoints = leagueTable.calculateTeamScores(matchResults);

        assertEquals(3,teamPoints.get("Snakes"));
    }

    @Test
    void emptyLeagueTableTest(){
        var leagueTable = new LeagueTable();
        Map<String, Integer> teamPoints = new HashMap<>();
        teamPoints.put("Lions",3);
        teamPoints.put("Snakes",0);
        teamPoints.put("Tigers",1);
        List<Team>  teamList = leagueTable.updateLeagueTable(teamPoints);
        assertFalse(teamList.isEmpty());

    }

}