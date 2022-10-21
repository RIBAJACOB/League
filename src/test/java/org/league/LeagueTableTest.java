package org.league;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableTest {
    @Test
    void arrayLengthTest(){

        var leagueTable = new LeagueTable();
        String input = "Lions 3, Snakes 3";
        String[] resultsArray = leagueTable.splitMatchResults(input);

        assertEquals(2,resultsArray.length);
    }

}