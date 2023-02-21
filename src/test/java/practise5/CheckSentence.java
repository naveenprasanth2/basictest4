package practise5;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckSentence {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa summa-summa summa- test-panni paathenhu -a";
        List<String> result = Stream.of(a.split(" "))
                .filter(x -> Pattern.matches("^[a-zA-Z]+$|^[a-zA-Z]+-[a-zA-Z]+$",x)).collect(Collectors.toList());

        StringBuilder build = new StringBuilder();
        result.forEach(x -> build.append(x).append(" "));
        System.out.println(build.toString().trim());
    }
}
