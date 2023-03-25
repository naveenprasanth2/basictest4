package practise11;

import java.util.List;
import java.util.stream.Stream;

public class CheckAnagram {
    public static void main(String[] args) {
        String first = "secure";
        String last = "rescue";

        List<String> firstList = Stream.of(first.split("")).sorted().toList();
        List<String> lastList = Stream.of(last.split("")).sorted().toList();

        System.out.println(firstList.equals(lastList));
    }
}
