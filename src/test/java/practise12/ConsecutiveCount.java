package practise12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ConsecutiveCount {
    public static void main(String[] args) {
        String a = "Amazon is a great company as it has AtoooZzz";

        List<String> values = Stream.of(a.replaceAll("\\s", "").split("")).toList();
        Map<String, Integer> test = new HashMap<>();

        int count = 1;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i).equals(values.get(i + 1))) {
                count++;
            } else {
                if (!test.containsKey(values.get(i))) {
                    test.put(values.get(i), count);
                } else if (test.get(values.get(i)) < count) {
                    test.put(values.get(i), count);
                }
                count = 1;
            }
        }

        List<Map.Entry<String, Integer>> finalList = test.entrySet().stream().sorted((x1, x2) -> {
            if (!Objects.equals(x2.getValue(), x1.getValue())) {
                return ((x2.getValue() - x1.getValue()));
            } else {
                return x1.getKey().compareTo(x2.getKey());
            }
        }).toList();

        System.out.println(finalList);


    }
}
