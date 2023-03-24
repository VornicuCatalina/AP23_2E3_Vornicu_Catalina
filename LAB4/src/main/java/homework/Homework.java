package homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework {
    public static void main(String[] args) { //Create a class that describes the problem.
        LinkedList<Student> studentsList = new LinkedList<>();
        TreeSet<Project> projectsTree = new TreeSet<>();
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);
        StudentProjectAllocation studentProjectAllocation = new StudentProjectAllocation();

        for (Student s : students) {
            studentsList.add(s);
        }

        Map<Student, List<Project>> prefMap = new HashMap<>();
        prefMap.put(students[0], Arrays.asList(projects[0], projects[1], projects[2]));
        studentProjectAllocation.addPrefMap(students[0], Arrays.asList(projects[0], projects[1], projects[2]));
        studentProjectAllocation.printStudents();
        /*
        List<Project> target = Arrays.asList(projects[1], projects[2]);
        List<Student> result = studentsList.stream()
                .filter(s -> prefMap.containsKey(s))
                .filter(s -> prefMap.get(s).contains(projects[0]))
                .collect(Collectors.toList());
        studentsList.stream()
                .filter(s -> prefMap.containsKey(s))
                .filter(s -> prefMap.get(s).contains(projects[0]))
                .forEach(System.out::println);*/

        Faker faker = new Faker();
        var students2 = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        var projects2 = IntStream.rangeClosed(0, 5)
                .mapToObj(i -> new Project(faker.name().title()))
                .toArray(Project[]::new);
        for (Student s : students2) {
            System.out.println(s.getName());
        }
        for (Project p : projects2) {
            System.out.println(p.getName());
        }
        studentProjectAllocation.addPrefMap(students[1], Arrays.asList(projects[0],projects[1]));
        studentProjectAllocation.addPrefMap(students[2],Arrays.asList(projects[0]));
        studentProjectAllocation.greedyAlg();
    }
}
