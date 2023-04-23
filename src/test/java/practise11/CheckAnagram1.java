package practise11;


import java.util.List;

public class CheckAnagram1 {

    public static void main(String[] args) {
        String first = "secure";
        String last = "rescue";

        List<Character> firstList = new String(first.toCharArray()).chars().mapToObj(i -> (char) i)
                .sorted(Character::compareTo).toList();

        List<Character> lastList = new String(last.toCharArray()).chars().mapToObj(i -> (char) i)
                .sorted(Character::compareTo).toList();

        System.out.println(firstList.equals(lastList));
    }
}
