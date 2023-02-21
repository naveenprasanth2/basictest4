package practise8;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepChar {
    public static void main(String[] args) {
        String a = "is it your first company";
     Map<String, Long> test = Stream.of(a.replaceAll("\\s", "").split(""))
             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

     List<String> justList = Stream.of(a.replaceAll("\\s", "").split("")).collect(Collectors.toList());
     justList.stream().filter(x -> test.get(x) == 1).findFirst().ifPresent(System.out::println);

    }
}
