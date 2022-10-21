package org.league;

public class Team  implements Comparable<Team> {
    String name;
    int score;
    int points;

    public Team(String name, int points, int score) {
        this.name = name;
        this.points = points;
        this.score = score;
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
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Team team) {
        return (int) (this.points - team.getPoints());
    }

}
