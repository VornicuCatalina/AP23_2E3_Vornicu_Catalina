package bonus;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;
//import "C:/Users/User/Documents/AP23_2E3_Vornicu_Catalina/LAB4/graph4j-1.0.1.jar";

public class Bonus {
    public static void main(String[] args) {
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

        studentProjectAllocation.addPrefMap(students[0], Arrays.asList(projects[0], projects[1], projects[2]));
        studentProjectAllocation.printStudents();
        studentProjectAllocation.addPrefMap(students[1], Arrays.asList(projects[0], projects[1]));
        studentProjectAllocation.addPrefMap(students[2], Arrays.asList(projects[0]));
        studentProjectAllocation.greedyAlg();
        System.out.println();
        studentProjectAllocation.matchingJGraphT();


        StudentProjectAllocation studentProjectAllocation1 = new StudentProjectAllocation();
        Faker faker = new Faker();
        var students2 = IntStream.rangeClosed(0, 1000)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        var projects2 = IntStream.rangeClosed(0, 1000)
                .mapToObj(i -> new Project(faker.name().title()))
                .toArray(Project[]::new);

        //creating the random connections
        for (int i = 0; i < students2.length; i++) {
            int rand = (int) (Math.random() * projects2.length);
            LinkedList<Project> constructor = new LinkedList<>();
            for (int j = 0; j < rand; j++) {
                if (!constructor.contains(projects2[i])) {
                    constructor.add(projects2[i]);
                }
            }
            studentProjectAllocation1.addPrefMap(students2[i], constructor);
        }
        studentProjectAllocation1.greedyAlg();
        System.out.println();
        studentProjectAllocation1.matchingJGraphT();
    }
}
