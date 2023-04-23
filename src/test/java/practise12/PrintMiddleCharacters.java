package practise12;

import java.util.List;
import java.util.stream.Stream;

public class PrintMiddleCharacters {
    public static void main(String[] args) {
        String a = "Amazonm";

        List<String> test = Stream.of(a.split("")).toList();

        if (test.size() % 2 == 0) {
            System.out.println((test.get(test.size() / 2 - 1)) + (test.get(test.size() / 2)));
        } else {
            System.out.println(test.get(test.size() / 2));
        }
    }
}
