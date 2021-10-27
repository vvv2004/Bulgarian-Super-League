public class TestTeams {
    public static void main(String[] args) {
        Player[] marekPlayers = new Player[12];
        marekPlayers[0] = new Player("Boyan", 17, Utils.bulgarian, Utils.defender, 60);
        marekPlayers[1] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);
        marekPlayers[2] = new Player("Kir40", 44, Utils.bulgarian, Utils.attacker, 44);
        marekPlayers[3] = new Player("trtr", 44, Utils.bulgarian, Utils.attacker, 67);
        marekPlayers[4] = new Player("ads", 44, Utils.bulgarian, Utils.attacker, 89);
        marekPlayers[5] = new Player("rrr", 44, Utils.bulgarian, Utils.attacker, 33);
        marekPlayers[6] = new Player("yut", 44, Utils.bulgarian, Utils.attacker, 78);
        marekPlayers[7] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);
        marekPlayers[8] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);
        marekPlayers[9] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);
        marekPlayers[10] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);
        marekPlayers[11] = new Player("Georgi", 16, Utils.bulgarian, Utils.midfielder, 70);

        Coach marekCoach = new Coach("Mitko", 50, Utils.bulgarian, 80);
        Assistant marekAssCoach = new Assistant("Georgi", 40, Utils.bulgarian, 75);

        Team marekDupnica = new Team(marekPlayers, marekCoach, marekAssCoach);

        System.out.println("Marek dupenica att overall: " + marekDupnica.getAttackOverall());
    }
}
