package practise11;

import java.util.List;
import java.util.stream.Stream;

public class ConvertChatracterList {
    public static void main(String[] args) {
        String name = "naveen";
        List<Character> test = new String(name.toCharArray()).chars().mapToObj(i -> (char) i).toList();

        System.out.println(test);
    }
}
