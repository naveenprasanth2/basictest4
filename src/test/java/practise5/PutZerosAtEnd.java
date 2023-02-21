package practise5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PutZerosAtEnd {
    public static void main(String[] args) {
        int[] a={2,3,0,0,5,0,8};
        List<Integer> test = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> result = test.stream().filter(x -> x!=0).collect(Collectors.toList());
        int count = (int) test.stream().filter(x -> x==0).count();
        IntStream.rangeClosed(1, count).forEach(x -> result.add(0));
        System.out.println(result);
    }
}
