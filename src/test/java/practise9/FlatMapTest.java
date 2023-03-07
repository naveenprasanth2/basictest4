package practise9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {7, 8, 9, 0, 1};

        List<int[]> test = new ArrayList<>(Arrays.asList(a, b));

        List<Integer> test1 = test.stream().map(x -> Arrays.stream(x).boxed().toList())
                                .flatMap(List::stream)
                                .toList();
        System.out.println(test1);


    }
}
