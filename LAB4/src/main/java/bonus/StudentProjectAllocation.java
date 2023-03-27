package bonus;

import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;
import org.graph4j.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentProjectAllocation {
    private Map<Student, List<Project>> prefMap = new HashMap<>();
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Project> projectsList = new LinkedList<>();
    private int[] verification;
    private int numberOfPreferences = 0;

    //new
    private Graph<String, DefaultEdge> graphJGraphT = new DefaultUndirectedGraph<>(DefaultEdge.class);
    private org.graph4j.Graph graphGraph4J = GraphBuilder.numVertices(1000).buildGraph();
    //end

    private Map<Student, Integer> preferences = new HashMap<>();

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

                //adding in the graph
                String project = p.getName();
                graphJGraphT.addVertex(project);
                graphGraph4J.addVertex(project);
            }
            //adding edge
            String stud = student.getName();
            String proj = p.getName();
            graphJGraphT.addEdge(stud, proj);
            graphGraph4J.addEdge(stud, proj);
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

}