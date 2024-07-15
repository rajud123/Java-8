package org.example.interview.questions.main;

import org.example.interview.questions.dto.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CommonProgrammingQA  {
    public static void main(String[] args) {

        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());


        //rank in between 50 - 100
        System.out.println(" //rank in between 50 - 100");
        studentList.stream().filter(student -> student.getRank()>=50 && student.getRank() <=100).forEach(System.out::println);

        //students who stays in karnataka and sort them by their names
        System.out.println(" //students who stays in karnataka and sort them by their names");
        studentList.stream().filter(student -> student.getCity().equalsIgnoreCase("Karnataka")).sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);

        //find all department names
        System.out.println(" //find all department names");
        studentList.stream().map(student -> student.getDept()).distinct().forEach(System.out::println);

        //find all contact numbers
        System.out.println(" //find all contact numbers");

        List<List<String>> collect = studentList.stream().map(Student::getContacts).collect(Collectors.toList());
//        [[+912632632782, +1673434729929], [+912632632762, +1673434723929], [+912632633882, +1673434709929], [+9126325832782, +1671434729929], [+012632632782], [+9126254632782, +16736784729929], [+912632632782, +1671234729929], [+9126326355782, +1673434729929], [+9126398932782, +16563434729929, +5673434729929], [+912632646482, +16734323229929]]

        System.out.println(collect);
        List<String> list = studentList.stream().flatMap(student -> student.getContacts().stream()).toList();
//        [+912632632782, +1673434729929, +912632632762, +1673434723929, +912632633882, +1673434709929, +9126325832782, +1671434729929, +012632632782, +9126254632782, +16736784729929, +912632632782, +1671234729929, +9126326355782, +1673434729929, +9126398932782, +16563434729929, +5673434729929, +912632646482, +16734323229929]

        System.out.println(list);

        //group students by deaprtment name
        System.out.println("//group students by deaprtment name");
        Map<String, List<Student>> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        collect1.entrySet().stream().forEach(System.out::println);

        //print the number of students in each department
        System.out.println("  //print the number of students in each department");
        Map<String, Long> noOfStudentsinEachDepartment = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));

        noOfStudentsinEachDepartment.entrySet().stream().forEach(System.out::println);

        System.out.println("prinitng the department containing max students");
        Map.Entry<String, Long> maxCountEntry = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(maxCountEntry);

        System.out.println("print the avergae age of gender groups");
        Map<String, List<Student>> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getGender));

        Map<String, Double> collect3 = collect2.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream().mapToDouble(student -> student.getAge()).average().orElse(0.0)));

        System.out.println(collect3);

        //second method

        Map<String, Double> collect4 = studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
        System.out.println(collect4);

        Map<String, Optional<Student>> collect5 = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.maxBy(Comparator.comparing(Student::getRank))));

        System.out.println(collect5);

        //find the student who has the second rank
        System.out.println("//find the student who has the second rank");
        Student student = studentList.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList()).get(2);
        System.out.println(student);
    }
}
