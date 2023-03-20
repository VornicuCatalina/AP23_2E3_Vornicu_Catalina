import java.time.LocalDate;
import java.util.Map;

public class Designer extends Person implements Node {
    private int noCollections=0;
    public Designer(String name, int year, int month, int day){
        this.name=name;
        this.specialisation="programmer";
        date=LocalDate.of(year,month,day);
    }
    @Override
    public void addRelationship(Node n, String value){
        relationships.put(n,value);
    }
    @Override
    public int getNoRelationship(){
        return relationships.size();
    }

    //new
    @Override
    public Map<Node,String> getMap(){ return this.relationships;}
    @Override
    public String getName(){
        return name;
    }

    public void setNoCollections(int noCollections) {
        this.noCollections = noCollections;
    }

    public int getNoCollections() {
        return noCollections;
    }
}
