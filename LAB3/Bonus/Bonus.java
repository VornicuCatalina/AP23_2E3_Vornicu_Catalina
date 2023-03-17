package LAB3.Bonus;

public class Bonus {
    public static void main(String[] args) {
        Network network=new Network(); //
        Node node=new Company("bae");
        Node n=new Company("nume");
        Node m=new Company("baka");
        network.addNode(node);
        network.addNode(n);
        network.addNode(m);
        Node k=new Programmer("hey",1998,2,2);
        network.addNode(k);
        k.addRelationship(n,"yus");
        k.addRelationship(node,"check");
        node.addRelationship(n,"hmm");
        node.addRelationship(m,"da");
        n.addRelationship(node,"yuhu");
        m.addRelationship(k,"da");
        network.findCutPoints();
       // network.print();
        network.showingSubgraph();
       // network.printCycle();
    }
}
