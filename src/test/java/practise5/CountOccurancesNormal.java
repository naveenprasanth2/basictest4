package practise5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurancesNormal {
    public static void main(String[] args) {
        String a = "Banana";
        List<String> test = Stream.of(a.split("")).collect(Collectors.toList());
        Map<String, Integer> result = new HashMap<>();
        for(int i=0; i< test.size(); i++){
            int count = 1;
            for(int j=i+1; j<test.size(); j++){
                if(test.get(i).equals(test.get(j))){
                    count++;
                }
            }
            if(!result.containsKey(test.get(i))){
                result.put(test.get(i), Math.max(i, count));
            }
        }
        result.entrySet().stream().sorted((x1,x2) -> {
            if(!Objects.equals(x1.getValue(), x2.getValue())){
                return (int) (x2.getValue() - x1.getValue());
            }else{
                return x1.getKey().compareTo(x2.getKey());
            }
        }).skip(1).findFirst().ifPresent(System.out::println);
    }
}
