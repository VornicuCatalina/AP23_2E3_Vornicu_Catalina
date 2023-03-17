package LAB3.Bonus;

import java.util.*;

public class Network {
    private List<Node> nodes=new ArrayList<>();
    //new
    private boolean verification=true;
    private ArrayList<ArrayList<Integer> > adjList;
    private ArrayList<String> nameNode=new ArrayList<>();
    //end

    //for dfs and stuff
    private int timer;
    private int noNodes;
    private boolean valid;
    private boolean[] visited;
    private int[] tin;
    private int[] low;
    //end for dfs
    public void addNode(Node n){
        nodes.add(n);
        nameNode.add(n.getName()); //to have a string to int representation
    }
    public void sortNodes(){
        Collections.sort(nodes,new Sort());
    }
    public void print(){
        for(Node node: nodes) {
            System.out.println(node.getName());
        }
    }
    private void creatingAdjMatrix(){
        //new
        if(verification){
            adjList=new ArrayList<ArrayList<Integer>>(nodes.size());
            verification=false;
        }
        //end
        for(Node node:nodes){
            ArrayList<Integer> adjJr = new ArrayList<Integer>();
            for(Node key:node.getMap().keySet()){
                adjJr.add(nameNode.indexOf(key.getName())); //the mini arraylist used to create the final one (a matrix somehow)
            }
            adjList.add(adjJr);
        }
        sus();
    }

    public void sus(){
        for (int i = 0; i < adjList.size(); i++)
            for (int j = 0; j < adjList.get(i).size(); j++) {
                if (!adjList.get(j).contains(i) && i != j)
                    adjList.get(j).add(i);
            }
    }

    //here the programs for dfs
    public void dfs(int v,int p){
        visited[v]=true;
        tin[v]=low[v]=timer++;
        int children=0;
        for(int to : adjList.get(v)){
            if(to==p) continue;
            if(visited[to]){
                low[v]=Math.min(low[v],tin[to]);
            }else{
                dfs(to,v);
                low[v]=Math.min(low[v],low[to]);
                if(low[to]>=tin[v] &&p!=-1){
                    valid=false;
                }
                ++children;
            }

        }
        if(p==-1 && children>1) {
            valid = false;
        }
    }
    public void findCutPoints(){
        creatingAdjMatrix();
        noNodes=nodes.size();
        valid=true;
        visited=new boolean[noNodes];
        tin=new int[noNodes];
        low=new int[noNodes];
        for(int i=0;i<noNodes;i++){
            visited[i]=false;
            tin[i]=-1;
            low[i]=-1;
        }
        for(int i=0;i<noNodes&&valid==true;++i){
            if(!visited[i])
                dfs(i,-1);
        }
        if(valid){
            System.out.println("No nodes that disconnect the network");
        }
        else{
            System.out.println("There are nodes who disconnect the network");
        }
    }

    //for showing all subgraphs that are maximum 2-connected we must know that they usually are
    // 1. the single vertices
    //2. 2 vertices that have a connection
    //3. cycles
    /*
    In order to solve it. we might use the dfs algorithm to find out if they have articulation points and by including them in the subgraphs
    => we will have 1-connected
    So we will use different combinations of 3->n subgraphs to see if they are 1-connected
    After that we could test if there are cycles -> if there exist means they are 2-connected
     */

    //I will use different functions for this problem so i will not have to modify the ones from above

    public void showingSubgraph(){
        //variables
        int index;
        //first of all i am going to start with the nodes
        System.out.println("\nTHE subgraphs that are 1-connected\nContaining only a node:");
        print();
        System.out.println("\nContaining two nodes");
        for (int i = 0; i < adjList.size(); i++)
            for (int j = 0; j < adjList.get(i).size(); j++) {
                index=adjList.get(i).get(j);
                if (index>i)
                    System.out.println(nameNode.get(index) +"-"+nameNode.get(i));
            }
        System.out.println("\nFinding cycles");
        printCycle( noNodes);
    }
    public void printCycle(int v){
        Stack<Integer> path=new Stack<Integer>();
        boolean []visited=new boolean[v];
        for(int i=0;i<visited.length;i++){
                dfsFinder(i,visited,path);
            for(int j=0;j<visited.length;j++){
                visited[j]=false;
            }
        }
    }
    void dfsFinder(int v,boolean visited[],Stack<Integer> p){
        // Mark the current node as visited and print it
        visited[v] = true;
        p.push(v);
        Iterator<Integer> i = adjList.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                dfsFinder(n, visited, p);
            }
            else {
                int idx = p.search(n);
                if (idx != -1 && idx >=3) {
                    for (int j = idx-1; j >= 0; j--) {
                        System.out.print(nameNode.get(p.get(j)) + " ");
                    }
                    System.out.println(nameNode.get(p.get(idx-1)));
                }
            }
        }
            p.pop();
    }
}

