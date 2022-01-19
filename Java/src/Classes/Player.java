package Classes;
import ProjectUtils.*;

public class Player extends Person{
    private int overall;
    private Position position;
    private String number;

    //===================================================== CONSTRUCTORS =====================================================
    public Player(String name, int age, String nationality, Position position, int overall, String number) {
        super(name, age, nationality);
        this.position = position;
        this.overall = overall;
        this.number = number;
    }

    public Player(){
        super(null, 0, null);
    }


    //===================================================== GETTERS =====================================================
    public String getNumber() {
        return number;
    }

    public int getOverall() {
        return overall;
    }

    public Position getPosition() {
        return position;
    }


    //===================================================== SETTERS =====================================================
    public void setNumber(String number) {
        this.number = number;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    //===================================================== METHODS =====================================================
    @Override
    public String toString() {
        return "name=" + getName() +
                "\nage=" + getAge() +
                "\nnumber=" + number +
                "\nnationality=" + getNationality() +
                "\nposition=" + position.toString().toLowerCase().charAt(0) +
                "\noverall=" + overall;
    }
}
