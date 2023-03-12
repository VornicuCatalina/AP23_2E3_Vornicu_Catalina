package LAB3.Homework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        Person p=new Programmer("George",1990,11,2);
        Company c1=new Company("first");
        Network network=new Network();
        Node node=new Company("bae");
        network.addNode(c1);
        network.addNode(node);
        c1.addRelationship(c1,"hm");
        c1.addRelationship(p,"gr");
        network.addNode(p);
        p.addRelationship(c1,"bf");
        network.sortNodes();
        network.print();
    }
}
