package seleniumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestDataProvider {
    @Test(dataProvider = "data3")
    public void summa(HashMap<String, String> test){
        System.out.println(test.get("name"));
        System.out.println(test.get("last"));
        System.out.println(test.get("phone"));
        System.out.println(test.get("landline"));
    }

    @DataProvider(name = "data1")
    public static Object[][] data1(){
        HashMap<String, String> test = new HashMap<>();
        test.put("name", "naveen");
        test.put("last", "summa");
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

    @DataProvider(name = "data2")
    public static Object[][] data2(){
        HashMap<String, String> test = new HashMap<>();
        test.put("phone", "99999");
        test.put("landline", "0000");
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

    @SuppressWarnings("unchecked")
    @DataProvider(name = "data3")
    public static Object[][] data3(){
        HashMap<String, String> test = new HashMap<>();
        test.putAll((HashMap<String, String>) data1()[0][0]);
        test.putAll((HashMap<String, String>) data2()[0][0]);
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

}
