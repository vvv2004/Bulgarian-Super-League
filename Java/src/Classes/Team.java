package Classes;
import ProjectUtils.*;
import ReaderWriter.*;

import java.io.IOException;

public class Team {
    private String name;
    private String nickname;
    private String city;
    private Player[] players = new Player[16];
    private Coach[] coaches;
    private Stadium stadium;
    private String pathToTeamData;

    private int attackOverall;
    private int midfieldOverall;
    private int defenceOverall;

    public Team(String name, String nickname, Player[] players, Coach[] coaches, Stadium stadium, String city) {
        this.name = name;
        this.nickname = nickname;
        this.players = players;
        this.coaches = coaches;
        this.stadium = stadium;
        this.city = city;

        attackOverall = calculateAvgOverall(players, Position.FORWARD);
        midfieldOverall = calculateAvgOverall(players, Position.MIDFIELDER);
        defenceOverall = calculateAvgOverall(players, Position.DEFENDER);
    }

    public Team(){
        name = null;
        nickname = null;
        players = null;
        coaches = null;
        stadium = null;
    }

    public String getPathToTeamData() {
        return pathToTeamData;
    }

    public void setPathToTeamData(String pathToTeamData) {
        this.pathToTeamData = pathToTeamData;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Coach[] getCoaches() {
        return coaches;
    }

    public void setCoaches(Coach[] coaches) {
        this.coaches = coaches;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public int getAttackOverall() {
        return attackOverall;
    }

    public void setAttackOverall(int attackOverall) {
        this.attackOverall = attackOverall;
    }

    public int getMidfieldOverall() {
        return midfieldOverall;
    }

    public void setMidfieldOverall(int midfieldOverall) {
        this.midfieldOverall = midfieldOverall;
    }

    public int getDefenceOverall() {
        return defenceOverall;
    }

    public void setDefenceOverall(int defenceOverall) {
        this.defenceOverall = defenceOverall;
    }

    public int calculateAvgOverall(Player[] players, Position position){
        int avg = 0;
        int counter = 0;

        for (Player player : players) {
            if(player.getPosition() == position) {
                avg += player.getOverall();
                counter++;
            }
        }

        return avg / counter;
    }

    public String teamInfo() {
        return "\n"+
                "Име: " + name +
                "\nГрад: " + city +
                "\nСтадион: " + stadium.getName() +
                "\nПрозвище: " + nickname +
                "\nГлавен Треньор: " + coaches[0].getName() +
                "\nАсистент Треньор: " + coaches[1].getName();
    }


    public String toString(){
        return "name=" + name +
                "\ncity=" + city +
                "\nnickname=" + nickname +
                "\npoints=0" +
                "\ngoalsScored=0" +
                "\ngoalDifference=0";

    }

    public static Team loadTeamFromDatabase(String pathToData) throws IOException {
        Reader reader = new Reader();
        Team output = new Team();
        String teamInfo = reader.getTeamInfo(pathToData);
        Player[] players = reader.loadPlayersFromTeam(pathToData);
        Coach[] coaches = reader.loadCoachesFromTeam(pathToData);
        Stadium stadium = new Stadium("Test", 20000);

        output.setName(reader.getSpecificInfo(teamInfo, "name"));
        output.setCity(reader.getSpecificInfo(teamInfo, "city"));
        output.setNickname(reader.getSpecificInfo(teamInfo, "nickname"));
        output.setPlayers(players);
        output.setCoaches(coaches);
        output.setAttackOverall(output.calculateAvgOverall(players, Position.FORWARD));
        output.setMidfieldOverall(output.calculateAvgOverall(players, Position.MIDFIELDER));
        output.setDefenceOverall(output.calculateAvgOverall(players, Position.DEFENDER));
        output.setStadium(stadium);

        return output;
    }
}
