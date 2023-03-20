package LAB3.Bonus;

public class Bonus {
    public static void main(String[] args) {
        Network network = new Network(); //
        Node node1 = new Company("Amazon");
        Node node2 = new Company("Centric");
        Node node3 = new Company("Mambu");
        network.addNode(node1);
        network.addNode(node2);
        network.addNode(node3);
        Node node4 = new Programmer("Popescu_Vasile", 1998, 2, 2);
        network.addNode(node4);
        node4.addRelationship(node2, "works for");
        node4.addRelationship(node1, "applied to");
        node1.addRelationship(node2, "business partner");
        node1.addRelationship(node3, "partners");
        node2.addRelationship(node1, "helps");
        node3.addRelationship(node4, "offer job");
        network.findCutPoints();
        // network.print();
        network.showingSubgraph();
        // network.printCycle();
    }
}
