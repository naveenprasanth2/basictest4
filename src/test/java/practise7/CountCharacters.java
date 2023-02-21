package practise7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {
    public static void main(String[] args) {
        char[] a = {'a', 's', 'a', 'f', 'm', 'm'};
        List<Map.Entry<Character, Long>> test = new ArrayList<>(new String(a).chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet());

        System.out.println(test);

    }
}
