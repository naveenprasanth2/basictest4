package practise5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxValue {
    public static void main(String[] args) {
        int[] a =  {1, 2, 3};
        List<Integer> test = new ArrayList<>();
        for(int i=0; i<a.length-1; i++){
            test.add(a[i]+a[i+1]);
        }
        test.stream().sorted((x1,x2) -> x2-x1).collect(Collectors.toList()).forEach(System.out::println);
    }
}
