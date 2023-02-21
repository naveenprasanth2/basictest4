package practise5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "secure";
        String last = "rescue";
        List<String> firstList = Stream.of(first.split("")).sorted((String::compareTo)).collect(Collectors.toList());
        List<String> lastList = Stream.of(last.split("")).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(firstList.equals(lastList));
    }
}
