package practise7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "secure";
        String last = "rescre";

        List<String> firstList = Stream.of(first.split("")).sorted().collect(Collectors.toList());
        List<String> lastList = Stream.of(last.split("")).sorted().collect(Collectors.toList());
        System.out.println(firstList.equals(lastList));
    }
}
