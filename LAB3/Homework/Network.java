package LAB3.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {
    private List<Node> nodes=new ArrayList<>();
    public void addNode(Node n){
        nodes.add(n);
    }
    public void sortNodes(){
        Collections.sort(nodes,new Sort());
    }
    public void print(){
        for(Node node: nodes) {
            System.out.println(node.getName());
        }
    }
}
