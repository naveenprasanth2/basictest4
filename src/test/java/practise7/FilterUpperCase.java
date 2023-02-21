package practise7;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterUpperCase {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";

        List<String> upperCases = Stream.of(a.split(" ")).filter(x -> Pattern.matches("^[A-Z]+$|^[A-Z]+[a-zA-Z]+$", x))
                .collect(Collectors.toList());

        System.out.println(upperCases);
    }
}
