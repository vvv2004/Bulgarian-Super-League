import Classes.*;

public class test {
    public static void main(String[] args) {
        Person person1 = new Person("Petko", 43, "bulgarian");
        System.out.println(person1.getName());
        person1.setName("Ivan");
        System.out.println(person1.getName());
    }
}
