package practise8;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceFind {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";

//        Stream.of(a.split(" ")).filter(x -> Pattern.matches("^[a-zA-Z]+-[a-zA-Z]+$|^[a-zA-Z]+", x)).collect(Collectors.toList()).forEach(System.out::println);

        Stream.of(a.split(" ")).filter(x -> Pattern.matches("^[A-Z]+[a-zA-Z]$|^[A-Z]+-[a-zA-Z]$", x)).collect(Collectors.toList()).forEach(System.out::println);
    }
}
