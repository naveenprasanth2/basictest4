package practise8;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetTheUppercase {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";
        List<Character> test = Stream.of(a.replaceAll("\\s", "").toCharArray())
                .flatMap(x -> new String(x).chars().mapToObj(i -> (char) i))
                .filter(Character::isUpperCase)
                .distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    Collections.reverse(l);
                    return l;
                }));

        System.out.println(test);

    }
}
