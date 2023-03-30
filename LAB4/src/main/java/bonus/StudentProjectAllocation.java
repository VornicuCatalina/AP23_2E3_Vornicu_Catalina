package bonus;

import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;
import org.graph4j.*;

import java.util.*;
import java.util.stream.Collectors;

public class StudentProjectAllocation {
    private Map<Student, List<Project>> prefMap = new LinkedHashMap<>();

    private Map<Project, List<Student>> assignMap = new LinkedHashMap<>(); //to help me
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Project> projectsList = new LinkedList<>();
    private int[] verification;
    private int numberOfPreferences = 0;

    //new
    private Graph<String, DefaultEdge> graphJGraphT = new DefaultUndirectedGraph<>(DefaultEdge.class);
    private org.graph4j.Graph graphGraph4J = GraphBuilder.numVertices(1000000).buildGraph();
    //end

    private Map<Student, Integer> preferences = new LinkedHashMap<>();
    private Map<Project, Integer> assignations = new LinkedHashMap<>();

    public void addPrefMap(Student student, List<Project> projects) {
        prefMap.put(student, projects);
        if (!students.contains(student)) {
            students.add(student);
            preferences.put(student, projects.size());

            //adding in the graph
            String name = student.getName();
            graphJGraphT.addVertex(name);
            graphGraph4J.addVertex(name);
        } else {
            preferences.replace(student, preferences.get(student) + projects.size());
        }
        numberOfPreferences += projects.size();
        for (Project p : projects) {
            if (!projectsList.contains(p)) {
                projectsList.add(p);

                assignations.put(p, 1);

                //adding in the graph
                String project = p.getName();
                graphJGraphT.addVertex(project);
                graphGraph4J.addVertex(project);
            } else {
                assignations.replace(p, assignations.get(p) + 1);
            }
            //adding edge
            String stud = student.getName();
            String proj = p.getName();
            if(!graphJGraphT.containsEdge(stud,proj)){
                graphJGraphT.addEdge(stud, proj);
                graphGraph4J.addEdge(stud, proj);
            }
        }
    }

    public void printStudents() {
        int avg = Math.round(numberOfPreferences / students.size());
        students.stream()
                .filter(student -> preferences.get(student) > avg)
                .forEach(System.out::println);
    }

    public void greedyAlg() {
        verification = new int[projectsList.size()];
        LinkedList<Project> matching = new LinkedList<>();
        students.stream()
                .map(s -> {
                    int lengthMap = prefMap.get(s).size();
                    Project help;
                    for (int i = 0; i < lengthMap; i++) {
                        help = prefMap.get(s).get(i);
                        int index = projectsList.indexOf(help);
                        if (verification[index] == 0) {
                            verification[index] = 1;
                            matching.add(help);
                            return help;
                        }
                    }
                    help = prefMap.get(s).get(0);
                    matching.add(help);
                    return help;
                })
                .collect(Collectors.toList());
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName() + " - " + matching.get(i).getName());
        }
        for (int i = 0; i < verification.length; i++) {
            if (verification[i] == 0) {
                for (Student s : students) {
                    if (prefMap.get(s).contains(projectsList.get(i))) {
                        System.out.println(s.getName() + " - " + projectsList.get(i).getName());
                        break;
                    }
                }
            }
        }
    }

    public void matchingJGraphT() {
        DenseEdmondsMaximumCardinalityMatching<String, DefaultEdge> graphHelper = new DenseEdmondsMaximumCardinalityMatching<>(graphJGraphT);
        MatchingAlgorithm.Matching<String, DefaultEdge> newGraph = graphHelper.getMatching();
        System.out.println(newGraph);
    }

    public void matchingGraph4J() {
        HopcroftKarpMaximumMatching solution = new HopcroftKarpMaximumMatching(graphGraph4J);
        System.out.println(solution);
    }

    //Determine a minimum cardinality set formed of students and projects
    // with the property that each admissible pair (student-project) contains at least an element of this set.

    public void helperMap() {
        for (Project p : projectsList) {
            LinkedList<Student> helper = new LinkedList<>();
            for (Student s : students) {
                if (prefMap.get(s).contains(p)) {
                    helper.add(s);
                }
            }
            assignMap.put(p, helper);
        }
    }

    public void setOfMinimumCardinality() {

        //now creating one long array that will help me to check who is verified / added to the final solution
        LinkedList<String> finalSet = new LinkedList<>(); //I will just use the name of them

        //creating 2 arrays specially used for checking only the unused variables
        int size1=students.size();
        int size2=projectsList.size();
        //int[] studs = new int[size1];
        //int[] projs = new int[size2];
        LinkedList<Integer> projVal = new LinkedList<>(assignations.values());
        LinkedList<Integer> studVal = new LinkedList<>(preferences.values());
        //works
        helperMap();

        int safeWayOut=size1+size2;
        boolean ok = true;
        while (ok) {
            int proj = Collections.max(projVal);
            int stud = Collections.max(studVal);
            if (proj > 0 || stud > 0) {
                if (proj > stud) { //to check who has more neighbors
                    //where is new -> to check them in those matrices that they were taken
                    int idx = projVal.indexOf(proj);
                    safeWayOut--; //decreasing
                    //projs[idx] = 1; //new
                    Project p = projectsList.get(idx);
                    finalSet.add(p.getName());
                    projVal.set(idx, 0);
                    for (Student s : students) { //what student has that project -> has a lower no. of neighbors by 1
                        if (prefMap.get(s).contains(p)) {
                            int idx2 = students.indexOf(s);
                            //studs[idx2] = 1; //new
                            studVal.set(idx2, studVal.get(idx2) - 1);
                            if(studVal.get(idx2)==0){
                                safeWayOut--;
                            }
                            for (Project projectHelp : projectsList) { //then checking what projects have that student -> -1
                                if (assignMap.get(projectHelp).contains(s)) {
                                    int idx3 = projectsList.indexOf(projectHelp);
                                    projVal.set(idx3, projVal.get(idx3) - 1);
                                    if(projVal.get(idx3)==0){
                                        safeWayOut--;
                                    }
                                }
                            }
                        }
                    }
                } else { //same pattern here, but in the opposite way
                    int idx = studVal.indexOf(stud);
                    //studs[idx] = 1; //new
                    finalSet.add(students.get(idx).getName());
                    Student s = students.get(idx);
                    safeWayOut--;
                    studVal.set(idx, 0);
                    for (Project p : projectsList) {
                        if (assignMap.get(p).contains(s)) {
                            int idx2 = projectsList.indexOf(p);
                            //projs[idx2] = 1; //new
                            projVal.set(idx2, projVal.get(idx2) - 1);
                            if(projVal.get(idx2)==0){
                                safeWayOut--;
                            }
                            for (Student studentHelp : students) {
                                if (prefMap.get(studentHelp).contains(p)) {
                                    int idx3 = students.indexOf(studentHelp);
                                    studVal.set(idx3, studVal.get(idx3) - 1);
                                    if(studVal.get(idx3)==0){
                                        safeWayOut--;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                ok = false;
            }
            if(safeWayOut==0){
                ok=false;
            }
        }
        System.out.println(finalSet);
    }

    public void setOfMaximumCardinality(){
        //now creating one long array that will help me to check who is verified / added to the final solution
        LinkedList<String> finalSet = new LinkedList<>(); //I will just use the name of them

        //creating 2 arrays specially used for checking only the unused variables
        int size1=students.size();
        int size2=projectsList.size();
        //int[] studs = new int[size1];
        //int[] projs = new int[size2];
        LinkedList<Integer> projVal = new LinkedList<>(assignations.values());
        LinkedList<Integer> studVal = new LinkedList<>(preferences.values());
        //works
        helperMap();

        int safeWayOut=size1+size2;
        boolean ok = true;
        int nrNodes= safeWayOut; //to be sure it is big enough
        while (ok) {
            int proj = Collections.min(projVal);
            int stud = Collections.min(studVal);
            if (proj < nrNodes || stud <nrNodes) {
                if (proj < stud) { //to check who has fewer neighbors
                    //where is new -> to check them in those matrices that they were taken
                    int idx = projVal.indexOf(proj);
                    //projs[idx] = 2; //new
                    Project p = projectsList.get(idx);
                    finalSet.add(p.getName());
                    projVal.set(idx, nrNodes);
                    safeWayOut--;
                    for (Student s : students) { //what student has that project -> has a lower no. of neighbors by 1
                        if (prefMap.get(s).contains(p)) {
                            int idx2 = students.indexOf(s);
                            //studs[idx2] = 1; //new
                            studVal.set(idx2, nrNodes);
                            safeWayOut--;
                        }
                    }
                } else { //same pattern here, but in the opposite way
                    int idx = studVal.indexOf(stud);
                    //studs[idx] = 2; //new
                    finalSet.add(students.get(idx).getName());
                    Student s = students.get(idx);
                    studVal.set(idx, nrNodes);
                    safeWayOut--;
                    for (Project p : projectsList) {
                        if (assignMap.get(p).contains(s)) {
                            int idx2 = projectsList.indexOf(p);
                            //projs[idx2] = 1; //new
                            projVal.set(idx2, nrNodes);
                            safeWayOut--;
                        }
                    }
                }
            } else {
                ok = false;
            }
            if(safeWayOut==0){
                ok=false;
            }
        }
        System.out.println(finalSet);

    }
}