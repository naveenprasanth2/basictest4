package practise12;

import java.util.List;

public class CovertCharacter {
    public static void main(String[] args) {
        String name = "naveen";

        List<Character> test = new String(name.toCharArray()).chars().mapToObj(i -> (char) i).toList();

        System.out.println(test);
    }
}
