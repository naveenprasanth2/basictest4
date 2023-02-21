package practise8;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterConvert {
    public static void main(String[] args) {
        char[] a = {'a', 's', 'l'};
        List<Character> list = new String(a).chars().mapToObj((i -> (char) i)).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
