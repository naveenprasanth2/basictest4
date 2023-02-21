package practise5;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepChar {
    public static void main(String[] args) {
        String a = "is it your first company";
        List<String> test = Stream.of(a.replaceAll("\\s", "").split("")).collect(Collectors.toList());

        Map<String, Long> result = test.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String x : test) {
            if (result.get(x) == 1) {
                System.out.println(x);
                break;
            }
        }

    }
}
