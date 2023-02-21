package practise5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseAString {
    public static void main(String[] args) {
        String a = "Hello Good Morning";
        List<String> test = Stream.of(a.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        StringBuilder build = new StringBuilder();
        test.forEach(x -> build.append(x).append(" "));
        System.out.println(build.toString().strip());
    }
}
