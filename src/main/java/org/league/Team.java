package org.league;

public class Team  implements Comparable<Team> {
    String name;
    int points;

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Team team) {
        return (int) (this.points - team.getPoints());
    }

}
