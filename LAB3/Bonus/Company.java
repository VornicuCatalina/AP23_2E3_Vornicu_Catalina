package LAB3.Bonus;

import java.util.Map;
import java.util.HashMap;
public class Company implements Node, Comparable<Company> {
    private String name;
    private int noWorkers;
    public Company(String name){
        this.name=name;
    }
    private Map<Node, String> relationships = new HashMap<>();
    @Override
    public void addRelationship(Node n, String value){
        relationships.put(n,value);
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getNoRelationship(){
        return relationships.size();
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }

    //new
    @Override
    public Map<Node,String> getMap(){ return this.relationships;}
    //end

    public void setNoWorkers(int noWorkers) {
        this.noWorkers = noWorkers;
    }

    public int getNoWorkers() {
        return noWorkers;
    }
}
