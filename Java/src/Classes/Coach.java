package Classes;
import ProjectUtils.*;

public class Coach extends Person{
    private int overall;
    private CoachRoles role;

    public Coach(String name, CoachRoles role, int age, String nationality, int overall) {
        super(name, age, nationality);
        this.overall = overall;
        this.role = role;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

}
