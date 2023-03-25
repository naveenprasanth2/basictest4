package practise10;

public class SingleTonExample {
    public static SingleTon singleTon;
    public static void main(String[] args) {
        singleTon = SingleTon.getInstance();
        System.out.println(singleTon.testMethod());
    }
}
