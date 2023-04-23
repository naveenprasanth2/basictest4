package practise12;

import java.util.*;

public class FirstAndLast {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 5, 7, 8, 1};
        List<Integer> test = Arrays.stream(list).boxed().toList();
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> lastMap = new HashMap<>();
        for (int i = 0; i < test.size(); i++) {
            if (!firstMap.containsKey((test.get(i)))) {
                firstMap.put(test.get(i), i);
            }
            lastMap.put(test.get(i), i);
        }

        System.out.println(firstMap);
        System.out.println(lastMap);
    }
}
