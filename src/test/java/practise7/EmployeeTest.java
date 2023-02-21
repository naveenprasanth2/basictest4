package practise7;

import practise5.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeTest {
    public static void main(String[] args) {
        practise5.Employee e1 = new practise5.Employee();
        e1.setName("naveen");
        e1.setAge(20);
        e1.setSex("male");
        e1.setDevices("apple");
        e1.setDevices("apple11");
        e1.setDevices("apple12");
        e1.setDevices("apple13");
        e1.setDevices("apple14");
        e1.setDevices("samsung");

        practise5.Employee e2 = new Employee();
        e2.setName("naveen");
        e2.setAge(20);
        e2.setSex("male");
        e2.setDevices("samsung");
        e2.setDevices("samsung11");
        e2.setDevices("samsung12");
        e2.setDevices("samsung13");
        e2.setDevices("samsung14");
        e2.setDevices("applee");

        List<Employee> test = Arrays.asList(e1, e2);

        test.stream().map(Employee::getDevices)
                .filter(devices -> devices.stream().noneMatch(y -> Pattern.matches("^[a-zA-Z]+e{2}$", y)))
                .forEach(System.out::println);

    }
}
