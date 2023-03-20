package org.example.Compulsory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Compulsory {
    public static void main(String[] args) {
    /*
Put all the students in a LinkedList and print them sorted by their names.
Put all the projects in a TreeSet and print them sorted by their names.
     */
        LinkedList<Student> studentsList=new LinkedList<>();
        TreeSet<Project> projectsTree=new TreeSet<>();
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var projects = IntStream.rangeClosed(0,2)
                .mapToObj(i-> new Project("P"+i))
                .toArray(Project[]::new);
        for(Student s:students)
        {
            studentsList.add(s);
        }
        Collections.sort(studentsList,(s1,s2)->s1.compareTo(s2));
        for(Student s:students){
            System.out.println(s.getName());
        }
        for(Project p:projects){
            projectsTree.add(p);
        }
        projectsTree.stream().sorted((p1,p2)->p1.compareTo(p2));
        for(Project p:projects){
            System.out.println(p.getName());
        }
    }
}
