--------------------
*****COMPULSORY*****
--------------------
+ created those classes using "public class <Name>"
+ the classes implement the interface java.util.Comparable by using this syntax

... <Name> implements Comparable<[Name]>

and by using @Override -> I will just compare them by their name so they will be ordered

compareTo(<Name> other) { return this.name.compareTo(other.name); }

!!!!It does not work if we do not use the keyword "other"!!!

+ I created the interface Node in the following way:

public interface Node{
	//inside of it we have methods of the following format 
	<return_type> <name_method> (<parameters>);
}

+ We create it by using the package java.util.List
List<Node> test=new ArrayList<>();

------------------
*****HOMEWORK*****
------------------
+ Programmer & Designer inherits from Person all its methods and attributes => they will use the keyword "extends"
public class <Name> extends Person

!!!all private attributes should become protected in order to be used by the <Name> class

+ I will use the java.util.Map & java.util.HashMap packages
protected Map<Node, String> relationships = new HashMap<>();

+ What we wrote in compulsory (main program) will be used inside of the new class Network

+ I used a new attribute called noRelationships and by comparing them using the Collections.sort() function that can do the sort by giving a function (lambda expression)
public void sortNodes(){
        Collections.sort(nodes,new Sort());
    }

where Sort -> a class that implements the sorting in the same way like compareTo, but as we have integers, it becomes:
n2.noRelationships-n1.noRelationships

-> so they would be ordered descending


+ created a function print using the syntax

for(Node node: nodes) {
            System.out.println(node.getName());
        }

as they will be already ordered -> we will just call it 

---------------
*****BONUS*****
---------------
+ I implemeted the argorithm from the slides (the link that sent to a site) -> so redid it but in java

+I used the following principles:
	- must be 1-connected or 2-connected
	- 1-connected -> have cut points
	- 2-connected -> cycles
	- I showed the nodes, then edges with 2 nodes
	- i applied the priciple of cut-points -> as long as it has it -> it is 1-connected subgraph -> 1<2
	- then i used to find cycles -> 2-connected subgraphs

It could have been done more efficiently by using the dfs + cutpoints in an interesting way , but it would have been too troublesome, so i decided to take the old way using cases 

+ Just used assertEquals() -> to check if they are equal