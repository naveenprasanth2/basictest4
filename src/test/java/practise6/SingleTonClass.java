package practise6;

public class SingleTonClass {

    private static SingleTonClass single = new SingleTonClass();

    private SingleTonClass() {
        
    }

    public static SingleTonClass getInstance() {
        return single;
    }

    public String test() {
        return "summa";
    }
}
