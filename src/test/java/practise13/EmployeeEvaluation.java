package practise13;

import java.util.List;

public class EmployeeEvaluation {
    public static void main(String[] args) {
        Employee employee1 = new Employee("naveen", 20, "male", "chennai", List.of("samsung", "iphone", "lg", "galaxy", "galaxy22", "galaxy24"));
        Employee employee2 = new Employee("naveena", 25, "male", "sivagangai", List.of("iphone", "iphone1", "iphone2", "galaxy22", "galaxy24"));

        List<Employee> test = List.of(employee1, employee2);

        List<Employee> values = test.stream().filter(x -> x.name().contains("naveen"))
                .filter(x -> x.devices().contains("iphone"))
                .toList();

        values.forEach(System.out::println);
    }
}
