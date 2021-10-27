public class Player extends Person{
    int overall;
    Position position;

    public Player(String name, int age, Nationality nationality, Position position) {
        super(name, age, nationality);
        this.position = position;
    }
}
