package practise8;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "secure";
        String last = "rescue";

        List<String> firstList = Stream.of(first.split("")).sorted().collect(Collectors.toList());
        List<String> lastList = Stream.of(last.split("")).sorted().collect(Collectors.toList());

        System.out.println(firstList.equals(lastList));

        Optional<String> testing = lastList.stream().max(Comparator.naturalOrder());
        System.out.println(testing.get());
    }
}
