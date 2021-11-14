import Classes.Player;
import ProjectUtils.Position;

public class TestTeams {
    public static void main(String[] args) {
        Player testPlayer = new Player("Ivan", 16, "Bulgarian", Position.MIDFIELDER, 75);

        System.out.println(testPlayer.getPosition());
    }
}
