import java.util.Comparator;
import java.util.Map;

public interface Node {
    String getName();
    int getNoRelationship();
    void addRelationship(Node node,String name);
    Map<Node,String> getMap();
}
class Sort implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        return n2.getNoRelationship()-n1.getNoRelationship(); //for decreasing order
    }
}
