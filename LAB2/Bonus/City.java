package LAB2.Bonus;

public class City extends Location {
    private int population;
    public City(String name, int pop, int k1, int k2){
        this.x=k1;
        this.y=k2;
        this.nameLocation=name;
        this.location="city";
        this.population=pop;
    }
    public void setPopulation(int pop){
        this.population=pop;
    }
    public int getPopulation(){
        return population;
    }
}
