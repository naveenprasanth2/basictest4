package practise13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PutAllZerosToEnd {
    public static void main(String[] args) {
        int[] a = {2, 3, 0, 0, 5, 0, 8};

        List<Integer> test = new ArrayList<>(Arrays.stream(a).boxed().filter(x -> x != 0).toList());
        long count = Arrays.stream(a).boxed().filter(x -> x==0).count();

        LongStream.rangeClosed(1, count).forEach(x -> test.add(0));

        System.out.println(test);

    }
}
