package practise5;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestInteger {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1};
        int rotate = 3;
        List<Integer> real = Arrays.stream(a).boxed().collect(Collectors.toList());
        for (int i = 0; i < rotate; i++) {
            real.add(0, real.remove(real.size()-1));
        }
        int min = Collections.min(real);
        System.out.println(real.indexOf(min));
    }
}
