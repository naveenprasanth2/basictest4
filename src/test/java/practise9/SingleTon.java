package practise9;

public class SingleTon {
    public static SingleTon single = new SingleTon();

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return single;
    }

    public String testMethod() {
        return "value1";
    }
}
