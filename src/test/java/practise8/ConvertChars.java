package practise8;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertChars {
    public static void main(String[] args) {
        char[] a = {'a', 's', 'l'};

        List<Character> test = new String(a).chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        System.out.println(test);
    }
}
