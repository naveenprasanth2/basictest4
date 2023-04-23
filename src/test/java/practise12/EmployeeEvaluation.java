package practise12;


import java.util.List;

public class EmployeeEvaluation {
    public static void main(String[] args) {
        Employee e1 = new Employee("naveen", 25, "male", List.of("samsung", "lg", "galaxy", "galaxy22", "galaxy24"));
        Employee e2 = new Employee("naveena", 25, "male", List.of("iphone", "iphone1", "iphone2", "galaxy22", "galaxy24"));

        List<Employee> test = List.of(e1, e2);

        test.stream().filter(x -> x.devices().contains("galaxy22"))
                .filter(x -> x.name().contains("naveen")).skip(1).findFirst()
                .ifPresentOrElse(System.out::println, null);
    }
}
