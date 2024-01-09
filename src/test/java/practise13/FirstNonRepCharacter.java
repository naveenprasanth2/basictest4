package practise13;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepCharacter {
    public static void main(String[] args) {
        String a = "is it your first company";
        List<String> resource = Stream.of(a.replaceAll("\\s", "").split("")).toList();

        Map<String, Long> test = resource.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        resource.stream().filter(x -> test.get(x) == 1).findFirst().ifPresent(System.out::println);
    }
}
