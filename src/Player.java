public class Player extends Person{
    private int overall;
    private Position position;

    public Player(String name, int age, Nationality nationality, Position position, int overall) {
        super(name, age, nationality);
        this.position = position;
        this.overall = overall;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
