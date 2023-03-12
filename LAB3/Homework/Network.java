package LAB3.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Network {
    private List<Node> nodes=new ArrayList<>();
    //for last task
    private int timer;
    private int NoNodes;
    private LinkedList<Integer> adj =new LinkedList<Integer>();
    private boolean[] visited;
    private int[] tin;
    private int[] low;
    public void findCutPoints(){
        /*
        timer = 0;
    visited.assign(n, false);
    tin.assign(n, -1);
    low.assign(n, -1);
    for (int i = 0; i < n; ++i) {
        if (!visited[i])
            dfs (i);
    }
         */
    }
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
