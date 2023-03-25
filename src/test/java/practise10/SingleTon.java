package practise10;

public class SingleTon {
    public static SingleTon singleTon;

    static {
        singleTon = new SingleTon();
    }
    private SingleTon() {

    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public String testMethod(){
        return "test completed";
    }
}
