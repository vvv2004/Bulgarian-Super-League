public class Coach extends Person{
    private int overall;

    public Coach(String name, int age, Nationality nationality, int overall) {
        super(name, age, nationality);
        this.overall = overall;
    }
}
