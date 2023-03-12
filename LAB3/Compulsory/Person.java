package LAB3.Compulsory;

public class Person implements Node , Comparable<Person> {
    private String name;
    private String specialisation;
    public Person(String name, String s){
        this.name=name;
        this.specialisation=s;
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
