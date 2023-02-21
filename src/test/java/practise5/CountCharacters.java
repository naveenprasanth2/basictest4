package practise5;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {
    public static void main(String[] args) {
        char[] a = {'a', 's', 'a', 'f', 'm', 'm'};
        List<Character> test = new String(a).chars().mapToObj(x -> (char) x).collect(Collectors.toList());
       List<Map.Entry<Character, Long>> result = test.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted((x1,x2) -> {
                    if(!Objects.equals(x1.getValue(), x2.getValue())){
                        return (int) (x2.getValue() - x1.getValue());
                    }else{
                        return x1.getKey().compareTo(x2.getKey());
                    }
                }).collect(Collectors.toList());

        System.out.println(result);
    }
}
