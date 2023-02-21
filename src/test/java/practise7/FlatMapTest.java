package practise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {
    public static void main(String[] args) {
         int[] a = {1,2,3};
         int[] b = {5,6,7};

        List<int[]> test = new ArrayList<>();

        test.add(a);
        test.add(b);

       List<Integer> test1 = test.stream().flatMap(x -> Arrays.stream(x).boxed()).collect(Collectors.toList());
        System.out.println(test1);
    }
}
