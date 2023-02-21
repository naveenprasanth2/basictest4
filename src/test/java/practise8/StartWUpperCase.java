package practise8;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartWUpperCase {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";

        List<String> test = Stream.of(a.split(" ")).filter(x -> Pattern.matches("^[A-Z]+[a-zA-Z0-9]*$", x)).collect(Collectors.toList());

        System.out.println(test);
    }
}
