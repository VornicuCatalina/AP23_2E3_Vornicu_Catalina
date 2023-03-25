package bonus;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentProjectAllocation {
    /*
    An instance of this problem consists of students and projects. Each student has a list of projects that are admissible.
A matching is a set of pairs (student, project) such that each student
is assigned to at most one project and each project is assigned to at most one student.
We consider the problem of creating a maximum cardinality matching between students and projects.
     */
    private Map<Student, List<Project>> prefMap = new HashMap<>();
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Project> projectsList = new LinkedList<>();
    private int[] verification;
    private int numberOfPreferences = 0;

    //new
    private Graph<String, DefaultEdge> graphJGraphT = new DefaultUndirectedGraph<>(DefaultEdge.class);
    //end

    private Map<Student, Integer> preferences = new HashMap<>();

    public void addPrefMap(Student student, List<Project> projects) {
        prefMap.put(student, projects);
        if (!students.contains(student)) {
            students.add(student);
            preferences.put(student, projects.size());

            //adding in the graph
            graphJGraphT.addVertex(student.getName());
        } else {
            preferences.replace(student, preferences.get(student) + projects.size());
        }
        numberOfPreferences += projects.size();
        for (Project p : projects) {
            if (!projectsList.contains(p)) {
                projectsList.add(p);

                //adding in the graph
                graphJGraphT.addVertex(p.getName());
            }
            //adding edge
            graphJGraphT.addEdge(student.getName(), p.getName());
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
}
