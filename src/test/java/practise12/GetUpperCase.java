package practise12;

import java.util.List;

public class GetUpperCase {
    public static void main(String[] args) {
        String a = "naveen is a A good? boy--boy ?testing \\--- test]pannitu iruken pa test8956 -summaa summa" +
                " summa-summa summa- test-panni Paathenhu -a GJHGU HGSYG GUYGS JHGSUYFJYf GHJG VG BBl LL KK HGHGH KKllll hhLLL";
        List<Character> test =new String(a.replaceAll("\\s", "").toCharArray()).chars().mapToObj(i -> (char) i)
                .filter(Character::isUpperCase).toList();

        System.out.println(test);
    }

}
