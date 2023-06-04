package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String testCommand = scanner.nextLine();
        ClassTester classTester = new ClassTester(testCommand);
        System.out.println(classTester.getClassMethods());
    }
}