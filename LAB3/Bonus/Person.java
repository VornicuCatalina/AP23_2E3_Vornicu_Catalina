package LAB3.Bonus;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Person implements Node, Comparable<Person> {
    protected String name;
    protected Map<Node, String> relationships = new HashMap<>();
    protected String specialisation;
    protected LocalDate date;

    //end
    public void setSpecialisation(String s){
        this.specialisation=s;
    }

    public String getSpecialisation() {
        return specialisation;
    }


    public void setName(String name){
        this.name=name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

}
