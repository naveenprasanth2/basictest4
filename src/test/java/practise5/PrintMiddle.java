package practise5;

import java.util.stream.Stream;

public class PrintMiddle {
    public static void main(String[] args) {
        String a = "Amazone";
        float count = (float) Stream.of(a.strip().split("")).count();

        if(count%2==0){
            System.out.println("the middle values are "+ a.charAt((int) (count/2) -1)+ " and last is "+ a.charAt((int) ((count/2))));
        }else{
            System.out.println("the value is "+ a.charAt((int) Math.floor(count/2)));
        }
    }
}
