import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class FilterSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Raju", 82.5),
                new Student("Sneha", 74.0),
                new Student("Amit", 90.2),
                new Student("Priya", 67.5),
                new Student("Manish", 78.0)
        );

        System.out.println("Students scoring above 75% (sorted by marks):");

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
