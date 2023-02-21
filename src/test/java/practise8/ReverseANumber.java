package practise8;

public class ReverseANumber {
    public static void main(String[] args) {
        int a = 1234560890;
        int newNumber = 0;

        while (a != 0) {
            newNumber = (newNumber * 10) + (a % 10);
            a /= 10;
        }
        System.out.println(newNumber);
    }
}
