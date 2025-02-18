package kit.interview.java_problems.core_java;

import java.util.*;

public class Q2ComparatorVsComparable {
    public static void main(String[] args) {
        List<Student> students = getStudents();
        System.out.println("Before Sorting: " + students);

        //Sorting using natural ordering: Class should implement Comparable
        Collections.sort(students);
        System.out.println("After Sorting (Natural Ordering): " + students);

        //Sorting using StudentMarksComparator
        Collections.sort(students, new StudentMarksComparator());
        System.out.println("After Sorting (StudentMarksComparator): " + students);

        //Java 8 Comparator (Using Lambda): Create comparator class in runtime.
        Comparator<Student> byMarks = (o1, o2) -> o2.marks - o1.marks;
        Collections.sort(students, byMarks);
        System.out.println("After Sorting (Java 8 Lambda): " + students);

        //Java 8 Comparator (Using Comparator.comparing())
        Comparator<Student> byMarksComparing = Comparator.comparing(Student::getMarks).reversed();
        Collections.sort(students, byMarksComparing);
        System.out.println("After Sorting (Java 8 Comparing): " + students);
    }

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Amar", 2, 65, 16));
        students.add(new Student("Akbar", 1, 35, 17));
        students.add(new Student("Antony", 4, 85, 15));
        students.add(new Student("Amit", 3, 95, 28));
        return students;
    }

    // Comparable: Comparing Object of same type. Natural ordering.
    static class Student implements Comparable<Student> {
        String name;
        int roll;
        int marks;
        int age;

        public Student(String name, int roll, int marks, int age) {
            this.name = name;
            this.roll = roll;
            this.marks = marks;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getRoll() {
            return roll;
        }

        public int getMarks() {
            return marks;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Student o) {
            // Student sorted by roll in ascending order.
            return (this.roll - o.roll);
        }

        // If compareTo() results 0 for two objects, then equals() should result true.
        // If compareTo() results 1 or -1 for two objects, then equals() should result false.
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Student student = (Student) o;
            return roll == student.roll;
        }

        @Override
        public int hashCode() {
            return Objects.hash(roll);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append(name);
            sb.append(", ").append(roll);
            sb.append(", ").append(marks);
            sb.append(", ").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    // Comparator Class is used to sort Objects based on custom logic
    // We can create multiple Comparator class as per need
    static class StudentMarksComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            // Student sorted by marks in descending order.
            return o2.marks - o1.marks;
        }
    }
}
