import java.util.*;
import java.util.stream.*;
class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender, 
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
    public static void main(String... args){
        List<Employee> empList = new ArrayList<>();
empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
   
   
   Map<String, List<Employee>> empsByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
  // System.out.println(empsByCity);
 
   
    Map<Integer, List<Employee>> empsByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
    // System.out.println(empsByAge);
    
   Map<String, Long> empsByGender =  empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
   
    
  // System.out.println(empsByGender);
   //Print the names of all departments in the organization.
   
   
   //empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);
   
   //. Print employee details whose age is greater than 28.
   
   
   //empList.stream().filter(emp->emp.getAge()>28).forEach(System.out::println);
   
   //Find maximum age of employee.
   
  Optional<Employee> emp = empList.stream().max(Comparator.comparing(Employee :: getAge));
  if(emp.isPresent()){
      //System.out.println(emp.get());
  }
 //  Print Average age of Male and Female Employees.
 
 Map<String, Double> gendersAvgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
 
 //System.out.println(gendersAvgAge);
   
   
  //Print the number of employees in each department.
  
 Map<String, Long>  empsByDept =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
   
   System.out.println(empsByDept);
   
   
   
   //Find oldest employee.
   Employee maxAgeEmp = empList.stream().max(Comparator.comparing(Employee::getAge)).get();
   //System.out.println(maxAgeEmp);
   
   //Find youngest female employee.
   
  
   Employee minAgeEmp =  empList.stream().filter(employee->employee.getGender().equals("F")).min(Comparator.comparing(Employee::getAge)).get();
  // System.out.println(minAgeEmp);
   
   //Find employees whose age is greater than 30 and less than 30.
   System.out.println("Find employees whose age is greater than 30 and less than 30.");
     List<Employee> AgeoFEmps = empList.stream().filter(emp1->emp1.getAge()>30 || emp1.getAge()<30).collect(Collectors.toList());
     
   
  // AgeoFEmps.forEach(System.out::println);
   
   // Find the department name which has the highest number of employees.
   
 Map.Entry<String, Long> higestNoOfEmpsInDept =   empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
 
 
 //System.out.println(higestNoOfEmpsInDept);
   
   // Find if there any employees from HR Department.
  Optional<Employee> optEmp =   empList.stream().filter(emp2->emp2.getDeptName().equals("HR")).findAny();
   
   
   // Find the department names that these employees work for, where the number of employees in the department is over 3.
 
    empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
entrySet().stream().filter(entry -> entry.getValue() > 4).forEach(System.out::println);

//Find distinct department names that employees work for.
empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

//Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
empList.stream().filter(emp3->emp3.getCity().equals("Blore")).sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).forEach(System.out::println);

//No of employees in the organisation.
empList.size();

//18. Find employee count in every department
empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream().forEach(System.out::println);

//Find the department which has the highest number of employees.
Optional<Map.Entry<String, Long>> deptNameWithHighestEmp =empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());

if (deptNameWithHighestEmp.isPresent()) {
    System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
}

//Sorting a Stream by age and name fields.


//empList.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName))).forEach(System.out::println);


//Comparator<Employee> comparator1 = Comparator.comparing(Employee::getName);
//Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::getAge);
//empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

//21. Highest experienced employees in the organization.

Employee highExp =  empList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get();

System.out.println("highExp :"+highExp);

//Print average and total salary of the organization.

 

double average = empList.stream()  // a stream of Employees
        .map(e -> e.getSalary())                  // a stream of Integer salaries// only the high salaries
        .mapToLong(Long::longValue)        // as a DoubleStream
        .average()                                // reduce to an average
        .getAsDouble();  

System.out.println("average :"+average);

long count = empList.stream().map(Employee::getSalary).mapToLong(Long::longValue).sum();

System.out.println("count :"+count);

//Print Average salary of each department.

 empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingDouble(Employee::getSalary))).entrySet().stream().forEach(System.out::println);

//Find Highest salary in the organisation.
empList.stream().map(emp->emp.getSalary()).max(Comparator.)
long maxSal = empList.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).get();
System.out.println(maxSal);
//Find Second Highest salary in the organisation.

empList.stream().sort(Comprator.comparing(Employee::getSalary).reversed()).get(2)
Employee SecondhighestSal = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get();

System.out.println(SecondhighestSal);

//Nth Highest salary.
int nth = 2;
Employee nthhighestSal = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(nth-1).findFirst().get();

//System.out.println(nthhighestSal);


//Find highest paid salary in the organisation based on gender.

empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.max))

System.out.println("Highest paid male and female employee : " + highestPaidMFEmployee);

// Find lowest paid salary in the organisation based in the organisation.
Map<String, Optional<Employee>> minPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));

//System.out.println("loswet paid male and female employee : " + minPaidMFEmployee);

// Sort the employees salary in the organisation in ascending order
//empList.stream().map(Employee::getSalary).sorted().forEach(System.out::println);

//Sort the employees by salary in the organisation in descending order.
//empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

//Highest salary based on department.
Map<String , Optional<Employee>>  highsaldept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));


System.out.println("highsaldept :"+highsaldept);


System.out.println("Sorting the department wise employee salary in ascending order:: ");
Map<String, Stream<Employee>> sortedEmployeeAsc = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, 
                                                   Collectors.collectingAndThen(Collectors.toList(),
                                                   list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)))));

sortedEmployeeAsc.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.avereginASDouble(Collectors)))
    }
}
