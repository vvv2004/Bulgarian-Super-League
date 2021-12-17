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

    public Coach(){
        super(null, 0, null);
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public CoachRoles getRole() {
        return role;
    }

    public void setRole(CoachRoles role) {
        this.role = role;
    }

    public String toString(){
        return "name=" + getName() +
                "role=" + role.toString().toLowerCase() +
                "age=" + getAge() +
                "nationality=" + getNationality() +
                "overall=" + getOverall();
    }
}
