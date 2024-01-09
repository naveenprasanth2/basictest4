package practise13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ReverseASentence {
    public static void main(String[] args) {
        String a = "Hello Good Morning";
        List<String> test = new ArrayList<>(Stream.of(a.split(" ")).toList());
        Collections.reverse(test);
        StringBuilder stringBuilder = new StringBuilder();

        test.forEach(x -> stringBuilder.append(x).append(" "));
        System.out.println(stringBuilder.toString().trim());
    }
}
