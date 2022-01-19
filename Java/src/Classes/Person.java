package Classes;

public class Person {
    private String name;
    private int age;
    private String nationality;

    //===================================================== CONSTRUCTORS ======================================================================
    public Person(String name, int age, String nationality) {

        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    //===================================================== GETTERS ======================================================================
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    //===================================================== SETTERS ======================================================================
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    //===================================================== METHODS ======================================================================
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
