package practise5;

import java.util.ArrayList;
import java.util.List;

public class SortArray {
    public static void main(String[] args) {
        int[][] array1 ={{10, 15},
                        {30, 50}};
        int[][] array2 ={{20,5},
                        {40, 10}};
        List<Integer> test = new ArrayList<>();

        for(int i=0; i<array1.length; i++){
            for(int j=0; j< array2.length; j++){
                if(test.isEmpty()){
                    test.add(array1[i][j]);
                }
                if(test.get(test.size()-1)<(array1[i][j])){
                    test.add(array1[i][j]);
                }
                if(test.get(test.size()-1)<(array2[i][j])){
                    test.add(array2[i][j]);
                }
            }
        }

        System.out.println(test);
    }
}
