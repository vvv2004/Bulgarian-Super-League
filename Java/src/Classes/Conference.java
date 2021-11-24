package Classes;


//Conference
public class Conference implements Interfaces.LeagueInterface{
   Team teams[] = new Team[10];
   String name;

 public Team[] getTeams() {
  return teams;
 }

 public void setTeams(Team[] teams) {
  this.teams = teams;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 @Override
    public void organiseTeamsByPoints() {

    }

    @Override
    public void organiseTeamsByGoalsScored() {

    }

    @Override
    public void organiseTeamsByGoalsAllowed() {

    }

    @Override
    public void organiseTeamsByGoalDifference() {

    }
}
