package practise12;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatPrint {
    public static void main(String[] args) {
        String a = "abcabc";

        List<Map.Entry<String, Long>> test = Stream.of(a.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().toList();

        StringJoiner join = new StringJoiner(",", "<", ">");

        test.forEach(x -> join.add("(" + x.getKey() + "," + x.getValue() + ")"));

        System.out.println(join);
    }
}
