package LAB3.Homework;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Person implements Node, Comparable<Person> {
    protected String name;
    private Map<Node, String> relationships = new HashMap<>();
    protected String specialisation;
    protected LocalDate date;
    public void addRelationship(Node n, String value){
        relationships.put(n,value);
    }
    @Override
    public int getNoRelationship(){
        return relationships.size();
    }
    public void setSpecialisation(String s){
        this.specialisation=s;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

}
