package practise9;

public class SingleTonExample {
    public static void main(String[] args) {
        SingleTon s = SingleTon.getInstance();
        System.out.println(s.testMethod());
    }
}
