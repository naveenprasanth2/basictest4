package practise7;

import java.util.*;

public class CountOccurancesNormal {
    public static void main(String[] args) {
        String a = "Banana";
        List<String> listValues = Arrays.asList(a.split(""));
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i<listValues.size() -1; i++){
            int count = 1;
            for (int j=i+1; j< listValues.size()-1; j++){
                if(listValues.get(i).equals(listValues.get(j))){
                    count++;
                }
            }

            if(!result.containsKey(listValues.get(i))){
                result.put(listValues.get(i), count);
            }else{
                result.put(listValues.get(i), result.get(listValues.get(i))>count?result.get(listValues.get(i)):count);
            }
        }

        System.out.println(result);

        Iterator<Map.Entry<String, Integer>> test = result.entrySet().iterator();
        String key = "";
        int val = 0;
        while (test.hasNext()){
            Map.Entry<String, Integer> temp = test.next();
            if(temp.getValue()>val){
                key = temp.getKey();
                val = temp.getValue();
            }
        }

        System.out.println(key+ "  " +val);

    }
}
