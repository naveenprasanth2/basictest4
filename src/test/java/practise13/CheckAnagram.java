package practise13;

import java.util.List;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "secure";
        String last = "rescue";

        List<String> firstList = Stream.of(first.split("")).sorted(String::compareTo).toList();
        List<String> lastList = Stream.of(last.split("")).sorted(String::compareTo).toList();

        System.out.println(firstList.equals(lastList));
    }
}
