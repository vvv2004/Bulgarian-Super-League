package Classes;
import ProjectUtils.*;

public class Coach extends Person{
    private int overall;
    private CoachRoles role;


    //===================================================== CONSTRUCTORS ======================================================================
    public Coach(String name, CoachRoles role, int age, String nationality, int overall) {
        super(name, age, nationality);
        this.overall = overall;
        this.role = role;
    }

    public Coach(){
        super(null, 0, null);
    }


    //===================================================== GETTERS ======================================================================
    public int getOverall() {
        return overall;
    }

    public CoachRoles getRole() {
        return role;
    }


    //===================================================== SETTERS ======================================================================
    public void setOverall(int overall) {
        this.overall = overall;
    }

    public void setRole(CoachRoles role) {
        this.role = role;
    }


    //===================================================== METHODS ======================================================================
    public String toString(){
        return "name=" + getName() +
                "\nrole=" + role.toString().toLowerCase() +
                "\nage=" + getAge() +
                "\nnationality=" + getNationality() +
                "\noverall=" + getOverall();
    }
}
