package practise10;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GetSentence {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";

        List<String> test = Stream.of(a.split(" "))
                .filter(x -> Pattern.matches("[a-zA-Z]+", x)|| Pattern.matches("[a-zA-Z]+-[a-zA-Z]+", x))
                .toList();

        System.out.println(test);
    }
}
