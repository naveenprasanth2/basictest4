package practise7;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountAndFirst {
    static String a = "BanananBB";
    static List<String> original = Stream.of(a.split("")).collect(Collectors.toList());

    public static void main(String[] args) {
       List<Map.Entry<String, Long>> test =  original.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted((x1,x2) -> {
                    if(!Objects.equals(x1.getValue(),x2.getValue())){
                        return (int) (x2.getValue() - x1.getValue());
                    }else{
                        return x1.getKey().compareTo(x2.getKey());
                    }
                }).collect(Collectors.toList());
        System.out.println(test);
    }
}
