package practise8;

import practise5.Employee;

import java.util.ArrayList;
import java.util.List;

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
        e2.setName("senba");
        e2.setAge(20);
        e2.setSex("male");
        e2.setDevices("samsung");
        e2.setDevices("samsung11");
        e2.setDevices("samsung12");
        e2.setDevices("samsung13");
        e2.setDevices("samsung14");
        e2.setDevices("applee");


        List<Employee> test = List.of(e1, e2);

        test.stream().filter(x -> x.getDevices().contains("samsung14")).map(x -> x.getName().toUpperCase()).findFirst().ifPresent(System.out::println);

    }
}
