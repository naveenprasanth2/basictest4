package practise6;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceCheck {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa summa-summa summa- test-panni paathenhu -a";
        List<String> test = Stream.of(a.split(" ")).filter(x -> Pattern.matches("^[a-zA-Z]+$|^[a-zA-Z]+-[a-zA-Z]+$", x)).collect(Collectors.toList());
        System.out.println(test);
    }
}
