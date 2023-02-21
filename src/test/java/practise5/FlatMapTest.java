package practise5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
   private static int[] a = {1,2,3};
    private static int[] b = {5,6,7};

    public static void main(String[] args) {
        List<int[]> test = new ArrayList<>();
        test.add(a);
        test.add(b);

        List<Integer> result = test.stream().flatMap(x -> Arrays.stream(x).boxed()).collect(Collectors.toList());
        System.out.println(result);
    }
}
