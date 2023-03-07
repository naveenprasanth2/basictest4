package practise9;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWords {
    public static void main(String[] args) {
        char[] a = {'s', 'a', 'f', 'm', 'm', 'a'};
        new String(a).chars().mapToObj(i -> (char) i).toList()
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().min((x1, x2) -> {
                    if (!Objects.equals(x1.getValue(), x2.getValue())) {
                        return (int) (x2.getValue() - x1.getValue());
                    } else {
                        return x1.getKey().compareTo(x2.getKey());
                    }
                }).ifPresent(System.out::println);
    }
}
