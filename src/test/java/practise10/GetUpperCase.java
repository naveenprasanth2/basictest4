package practise10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GetUpperCase {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";

        List<Character> test = new String(a.replaceAll(" ", "").toCharArray()).chars()
                .mapToObj(x -> (char) x).filter(Character::isUpperCase)
                .toList();

        System.out.println(test);
    }
}
