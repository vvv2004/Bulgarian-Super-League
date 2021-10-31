import jdk.jshell.execution.Util;

public class Team {
    private Player[] players = new Player[16];
    private Coach coach;
    private Assistant assistantCoach;
    private Stadium stadium;

    private int attackOverall;
    private int midfieldOverall;
    private int defenceOverall;

    public Team(Player[] players, Coach coach, Assistant assistantCoach, Stadium stadium) {
        this.players = players;
        this.coach = coach;
        this.assistantCoach = assistantCoach;
        this.stadium = stadium;

        attackOverall = calculateAvgOverall(players, Utils.attacker);
        midfieldOverall = calculateAvgOverall(players, Utils.midfielder);
        defenceOverall = calculateAvgOverall(players, Utils.defender);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Assistant getAssistantCoach() {
        return assistantCoach;
    }

    public void setAssistantCoach(Assistant assistantCoach) {
        this.assistantCoach = assistantCoach;
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

    private int calculateAvgOverall(Player[] players, Position position){
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
}
