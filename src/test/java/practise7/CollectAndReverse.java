package practise7;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectAndReverse {
    public static void main(String[] args) {
        String a = "Amazon is a great company as it has AtooooZzzzzo";
        List<Map.Entry<String, Long>> test = Stream.of(a.replaceAll("\\s", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((x1,x2) -> {
                    if(!Objects.equals(x1.getValue(), x2.getValue())){
                        return (int) (x2.getValue() - x1.getValue());
                    }else{
                        return x1.getKey().compareTo(x2.getKey());
                    }
                })
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));

        System.out.println(test);

    }
}
