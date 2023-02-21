package practise5;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAndReverse {
    public static void main(String[] args) {
        String a = "Amazon is a great company as it has AtoooZzzzz";
        List<String> test = Stream.of(a.replaceAll("\\s", "").split(""))
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));
        System.out.println(test);
    }
}
