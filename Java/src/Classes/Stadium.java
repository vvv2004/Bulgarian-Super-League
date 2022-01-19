package Classes;

public class Stadium {
    String name;
    int capacity;

    //===================================================== CONSTRUCTORS ======================================================================
    public Stadium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Stadium(){}

    //===================================================== GETTERS ======================================================================
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    //===================================================== SETTERS ======================================================================
    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
