package homework;

import java.util.*;
import java.util.function.Consumer;
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
    private int numberOfPreferences = 0;

    private Map<Student, Integer> preferences = new HashMap<>();

    public void addPrefMap(Student student, List<Project> projects) {
        prefMap.put(student, projects);
        if (!students.contains(student)) {
            students.add(student);
            preferences.put(student, projects.size());
        } else {
            preferences.replace(student, preferences.get(student) + projects.size());
        }
        numberOfPreferences += projects.size();
    }

    public void printStudents() {
        int avg = Math.round(numberOfPreferences / students.size());
        students.stream()
                .filter(student -> preferences.get(student) > avg)
                .forEach(System.out::println);
    }
}
