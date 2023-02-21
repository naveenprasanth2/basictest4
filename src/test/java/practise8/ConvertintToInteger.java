package practise8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertintToInteger {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        char[] c = {'a', 'b', 'c'};

        List<Integer> test = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Character> test1 = new String(c).chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        System.out.println(test1);
        System.out.println(test);
    }
}
