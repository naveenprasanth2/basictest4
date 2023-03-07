package practise9;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepChar {
    public static void main(String[] args) {
        String a = "zis it your first company";
        Map<String, Long> values = Stream.of(a.replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Stream.of(a.replaceAll("\\s", "").split(""))
                .filter(x -> values.get(x) ==1 )
                .findFirst()
                .ifPresent(System.out::println);
    }
}
