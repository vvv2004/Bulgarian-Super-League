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
    private int coachesOverall;
    private int points;
    private int goalsScored;
    private int goalAllowed;
    private int goalDifference;

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
        coachesOverall = calculateCoachesAvgOverall();
    }

    public Team(String pathToTeamData){
        this.pathToTeamData = pathToTeamData;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalAllowed() {
        return goalAllowed;
    }

    public void setGoalAllowed(int goalAllowed) {
        this.goalAllowed = goalAllowed;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
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

    public int calculateCoachesAvgOverall(){
        int output = 0;

        for(Coach coach : coaches) {
            if(coach.getRole().toString().equals("GENERAL") || coach.getRole().toString().equals("ASSISTANT")){
                output += coach.getOverall();
            }
        }

        return output / 2;
    }

    public double calculateAttackingPotential(){
        double attackingPlayersContribute = attackOverall * 0.6;
        double midfieldPlayersContribute = midfieldOverall * 0.3;
        double defensivePlayersContribute = defenceOverall * 0.1;
        double coachesContribute = 0;

        if(coachesOverall >= 80){
            coachesContribute = 0.3;
        }else if(coachesOverall >= 70 && coachesOverall < 80){
            coachesContribute = 0.15;
        }else if(coachesOverall >= 50 && coachesOverall < 60){
            coachesContribute = -0.15;
        }else if(coachesOverall < 50){
            coachesContribute = -0.3;
        }

        return (attackingPlayersContribute + midfieldPlayersContribute
                + defensivePlayersContribute + coachesContribute) / 3;
    }

    public double calculateDefensivePotential(){
        double defensivePlayersContribute = defenceOverall * 0.6;
        double midfieldPlayersContribute = midfieldOverall * 0.3;
        double attackingPlayersContribute = attackOverall * 0.1;
        double coachesContribute = 0;

        if(coachesOverall >= 80){
            coachesContribute = 0.3;
        }else if(coachesOverall >= 70 && coachesOverall < 80){
            coachesContribute = 0.15;
        }else if(coachesOverall >= 50 && coachesOverall < 60){
            coachesContribute = -0.15;
        }else if(coachesOverall < 50){
            coachesContribute = -0.3;
        }

        return (attackingPlayersContribute + midfieldPlayersContribute
                + defensivePlayersContribute + coachesContribute) / 3;
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
        output.setPathToTeamData(pathToData);

        return output;
    }
}
