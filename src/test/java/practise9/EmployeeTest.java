package practise9;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("naveen", 25, "male", List.of("samsung", "lg", "galaxy", "galaxy22", "galaxy24"));
        Employee e2 = new Employee("naveena", 25, "malee", List.of("iphone", "iphone1", "iphone2", "galaxy22", "galaxy24"));
        List<Employee> test = List.of(e1, e2);

        test.stream().filter(x -> x.devices().contains("iphone"))
                .filter(x -> x.name().equalsIgnoreCase("naveena"))
                .findFirst()
                .map(Employee::devices)
                .stream()
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
