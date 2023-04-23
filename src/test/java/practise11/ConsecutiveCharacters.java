package practise11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String a = "AtoooZzzzz";
        List<String> val = Stream.of(a.split("")).toList();
        Map<String, Integer> test = new HashMap<>();

        for (int i=0; i< val.size(); i++){
            int count = 1;
            for (int j=i+1; j< val.size(); j++){
                if(val.get(i).equals(val.get(j))){
                    count++;
                }
            }
            if(!test.containsKey(val.get(i))){
                test.put(val.get(i), count);
            }else if(test.get(val.get(i)) < count){
                    test.put(val.get(i), count);
            }
        }
        System.out.println(test);

        System.out.println(test.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null));
    }
}
