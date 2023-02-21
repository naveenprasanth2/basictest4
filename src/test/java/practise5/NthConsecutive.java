package practise5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthConsecutive {
    public static void main(String[] args) {
        String a = "Amazon is a great company as it has AtoooZzz";
        Map<String, Integer> testMap = new HashMap<>();
        List<String> test = Stream.of(a.replaceAll("\\s", "").split("")).collect(Collectors.toList());
        for (int i = 0; i < test.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < test.size(); j++) {
                if(test.get(i).equals(test.get(j))){
                    count++;
                }else{
                    break;
                }
            }

            if(testMap.containsKey(test.get(i))){
                testMap.put(test.get(i), testMap.get(test.get(i))>count?testMap.get(test.get(i)):count);
            }else{
                testMap.put(test.get(i), count);
            }

        }

        testMap.entrySet().stream().min((x1, x2) -> {
            if (!Objects.equals(x1.getValue(), x2.getValue())) {
                return (x2.getValue() - x1.getValue());
            } else {
                return x1.getKey().compareTo(x2.getKey());
            }
        }).ifPresent(System.out::println);
    }
}
