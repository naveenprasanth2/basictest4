package practise5;

import java.util.*;
import java.util.stream.Collectors;

public class NthSubset {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 15, 17, 19};
        List<Integer> test = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int subset = 3;
        for(int i=0; i< test.size(); i+=subset){
            List<Integer> temp = test.subList(i, i+subset);
            Collections.reverse(temp);
            result.addAll(temp);
        }

        System.out.println(result);
    }
}
