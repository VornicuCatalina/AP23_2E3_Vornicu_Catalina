package LAB3.Compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compulsory {
    public static void main(String[] args) {
        Person p=new Person("hey","hm");
        Person p2=new Person("hayo","designer");
        Company c1=new Company("first");
        List<Node> test=new ArrayList<>();
        test.add(p);
        test.add(p2);
        test.add(c1);
        Collections.sort(test,(t1,t2)-> t1.getName().compareTo(t2.getName()));//test, Comparator.comparing(Node::getName)
        for(int i=0;i< test.size();i++)
            System.out.println(test.get(i).getName());
        for(Node node: test){
            System.out.println(node.getName());
        }
    }
}
