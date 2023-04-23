package practise12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ReverseNthSubset {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11,15,17,19};
        int subSetValue = 3;

        List<Integer> test = Arrays.stream(a).boxed().toList();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < test.size(); i+=subSetValue){
            ArrayList<Integer> temp;
            temp = new ArrayList<>(test.subList(i, i+subSetValue));
            Collections.reverse(temp);
            resultList.addAll(temp);
        }

        System.out.println(resultList);
    }
}
