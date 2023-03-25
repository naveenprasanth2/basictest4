package practise10;

import practise9.Employee;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        practise9.Employee e1 = new practise9.Employee("naveen", 25, "male", List.of("samsung", "lg", "galaxy", "galaxy22", "galaxy24"));
        practise9.Employee e2 = new Employee("naveena", 25, "male", List.of("iphone", "iphone1", "iphone2", "galaxy22", "galaxy24"));

        List<Employee> test = List.of(e1, e2);

        test.stream().filter(x -> x.devices().contains("iphone2"))
                .map(x -> new Employee("summa", 25, "male", List.of("iphone", "iphone1", "iphone2", "galaxy22", "galaxy24")))
                .findFirst().ifPresent(System.out::println);
    }
}
