package practise9;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurances {
    public static void main(String[] args) {
        String[] a = {"cat", "mat", "bat", "cat", "mat", "mat", "cat", "mat", "bat", "cat", "cat", "bat", "bat", "bat"};
        Stream.of(a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().min((x1, x2) -> {
                    if (!Objects.equals(x1.getValue(), x2.getValue())) {
                        return (int) (x2.getValue() - x1.getValue());
                    } else {
                        return (x1.getKey().compareTo(x2.getKey()));
                    }
                }).ifPresent(System.out::println);
    }
}
