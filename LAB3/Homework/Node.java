package LAB3.Homework;

import java.util.Comparator;

public interface Node {
    String getName();
    int getNoRelationship();
}
class Sort implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        return n2.getNoRelationship()-n1.getNoRelationship(); //for decreasing order
    }
}
