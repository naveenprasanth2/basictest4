package practise12;

import java.util.Arrays;
import java.util.List;

public class ConvertInteger {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};

        List<Integer> test = Arrays.stream(a).boxed().toList();

        System.out.println(test);
    }
}
