package practise12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class PutAllZerosToEnd {
    public static void main(String[] args) {
        int[] a = {2, 3, 0, 0, 5, 0, 8};
        List<Integer> test = new ArrayList<>(Arrays.stream(a).boxed().toList());

        long count = test.stream().filter(x -> x == 0).count();
        test.removeIf(x -> x == 0);
        LongStream.rangeClosed(0, count).forEach(x -> test.add(0));

        System.out.println(test);
    }
}
