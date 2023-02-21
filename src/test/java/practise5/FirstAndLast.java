package practise5;

import java.util.HashMap;

public class FirstAndLast {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 5, 7, 8};
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            if (!first.containsKey(list[i])) {
                first.put(list[i], i);
            }
            last.put(list[i], i);
        }
        System.out.println(first);
        System.out.println(last);
    }
}
