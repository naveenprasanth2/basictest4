package practise10;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepCharacter {
    public static void main(String[] args) {
        String a = "is it your first company";

        Map<String, Long> value = Stream.of(a.replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Stream.of(a.replaceAll("\\s", "").split(""))
                .filter(x -> value.get(x) == 1)
                .findFirst().ifPresent(System.out::println);
    }
}
