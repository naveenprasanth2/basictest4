package practise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternStringPrint {
    public static void main(String[] args) {
        String a = "<abcabcsummatestpannipaathen>";
       List<Map.Entry<String, Long>> test = new ArrayList<>(Stream.of(a.split("")).filter(x -> Pattern.matches("[a-zA-Z]", x))
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet());
        StringJoiner join = new StringJoiner(",", "<", ">");
        test.forEach(x -> join.add("("+x.getKey()+","+x.getValue()+")"));
        System.out.println(join);
    }
}
