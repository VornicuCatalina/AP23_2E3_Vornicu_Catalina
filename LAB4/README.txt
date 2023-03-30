--------------------
*****COMPULSORY*****
--------------------
+ we create it by opening the option "new project" and changing it to Maven

+ we create those classes in a normal way and by making them comparable -> we inhreit the behaviour of Comparable interface:

publi class <name> implements Comparable<[name]>

+ To create them easier we will just use stream: 3 students and their object has the name S<idx>

var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

+ The LinkedList is created this way:
LinkedList<Student> studentsList = new LinkedList<>();

and we use Collections.sort() to sort it by name, using the Comparable interface in lambda expression

+ The TreeSet is created this way:
TreeSet<Project> projectsTree = new TreeSet<>();

and unlike a linkedlist, it needs to be streamed in order to be sorted -> projectsTree.stream().sorted()

where in sorted we use the same thing like in linkedlist, a lambda expression using Comparable interface

------------------
*****HOMEWORK*****
------------------
+ I created the class "StudentProjectAllocation" that has a map used to store the connections between a student and the projects that they would like to be asssigned to;


public class StudentProjectAllocation {
    private Map<Student, List<Project>> prefMap = new HashMap<>();
}

+ To solve this task, I used a variable that stores all the preferences that every single student has, then i calculate the average of preferences by divinding that variable to the size of the list students (every student is added one by one uniquely when adding elements to the map) -> we will know how many students we have ;  then we round it, bu=y using Math.round()

	After it is just a matter of looping through the students by using a stream().filter().forEach(); the filter will be used to save only the students that have more preferences than the average of preferences; forEach will just print them in the console.

+ To create those fake names , I had to download "com.github.javafaker:javafaker" and then created an object of Faker class that will be used in the streams to create the students/projects by using the methods name().fullName() or name().title().
	In the end, I have just printed them on the screen to see that it works.

+ The Greedy algorithm has the following principle :
	- You choose a student as root (where the algorithm starts) [ in my case I chose the first student, because it is less complicated to do this]
	- You find the projects that haven't been chosen by using a vector of int , size of the number of projects from a new list projects
	- You choose the first project that has not been taken
	- If the student's projects all have been taken, it will be just created a match between them and the first projects that it has been picked by him as preference
	- In the end, there is still the case of being untaken projects , so I loop one more time through the projects to check if they have been taken or not ; if not -> we find students that chose it and create a new match

!!!IT is a fast algorithm, but it is not always correct!!!
FOR example: the task from compulsory

---------------
*****BONUS*****
---------------
+ I downloaded the JGraphT library, but not Graph4J (IDK how to download it)
      *"org.jgrapht:jgrapht-core" 

	For the implementation, I created a graph that it is created and has elements that are added when we use the function for the map
	Then, I use a separate function for findinf the match: 

DenseEdmondsMaximumCardinalityMatching<String, DefaultEdge> graphHelper = new DenseEdmondsMaximumCardinalityMatching<>(graphJGraphT);//for creating the class that will help us
        MatchingAlgorithm.Matching<String, DefaultEdge> newGraph = graphHelper.getMatching(); //calling it then printing newGraph at the end using sout

+ For creating those random things -> I used a random implementation that helps us with this

1. I created objects of student and project classes by using the class Faker (methods from it)
2. Then I looped through students arraylist and for every single one i used a random variable used to store a random number (Math.random()) and a linkedlist to add the projects that have been chosen from the list of projects also randomly
3. In the end, I have just called those 2 functions: greedyAlg & matchingAlg [they don't have these names in my code] - matching for both libraries 

+ SO, to get that I used a way of getting the elements faster by using LinkedLists -> they have the functions max and min implemented, by calling Collection.min/max. The alg is this way

1. We check who has the most neighbors in students, but also projects then compare them
2. If it is student -> we will loop through projects and if it is project otherwise
3. We check what elements have that student/project and decrease their value from their Arraylist , so we can find in real time who has more neighbors left (without the checked ones)
4. Also in that loop we iterate through the student arraylist (if the student had more neighbors) , same for project arraylist to check who has that project/student to decrease them , so i do not have to do more useless calculus, better to use the opportunity to finish faster
5. After we reached the numer of nodes as checked, the function stops using the variable safeWayOut -> turns ok as false then we get the result

+ In this part, i used most of the alg used at the previous exercise , but with some changes

1. We check who has the fewest neighbors in students/projects then we compare them
2. Same as the previous exercise
3. We check what elements have that student/project and we change the value in their arraylist with number of nodes (projects+students) -> so we will make sure they are not counted
4. same as 5th at previous exercise