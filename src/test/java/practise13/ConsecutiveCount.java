package practise13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ConsecutiveCount {
    public static void main(String[] args) {
        String a = "Amazon is a great company as it has AtoooZzz";
        List<String> resource = Stream.of(a.split("")).filter(x -> !x.equals(" ")).toList();

        Map<String, Integer> finalMap = new HashMap<>();
        int count;
        for (int i = 0; i < resource.size(); i++) {
            count = 1;
            for (int j = i + 1; j < resource.size(); j++) {
                if (resource.get(i).equals(resource.get(j))) {
                    count++;
                } else {
                    break;
                }
            }
            if (!finalMap.containsKey(resource.get(i))) {
                finalMap.put(resource.get(i), count);
            }else if (finalMap.get(resource.get(i)) < count){
                finalMap.put(resource.get(i), count);
            }
        }

        List<Map.Entry<String, Integer>> test = finalMap.entrySet().stream().sorted((x1, x2) -> {
            if(!(Objects.equals(x1.getValue(), x2.getValue()))){
                return x2.getValue() - x1.getValue();
            }else {
                return x1.getKey().compareTo(x2.getKey());
            }
        }).toList();

        System.out.println(test);

    }
}
