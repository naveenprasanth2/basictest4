package practise5;

public class FirstOccuranceDifference {
    public static void main(String[] args) {
        int[] a = {1, 5, 0, -1, 3, -2, -1, 0, 1, 2, 3};
        for(int i=0; i<(a.length-1); i++){
            if(Math.abs(a[i]-a[i+1])==1){
                System.out.println("The values are "+ a[i] + " and " + a[i+1]);
                break;
            }
        }
    }
}
