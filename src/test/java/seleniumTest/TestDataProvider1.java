package seleniumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestDataProvider1 {

    @Test(dataProvider = "data3")
    public void test(HashMap<String, String> test){
        System.out.println(test.get("first"));
        System.out.println(test.get("last"));
        System.out.println(test.get("phone"));
        System.out.println(test.get("landline"));
    }

    @DataProvider(name = "data1")
    public static Object[][] data1(){
        Object[][] o = new Object[1][];
        HashMap<String, String> test = new HashMap<>();
        test.put("first", "naveen");
        test.put("last", "prasanth");
        o[0] = new Object[] {test};
        return o;
    }

    @DataProvider(name = "data2")
    public static Object[][] data2(){
        Object[][] o = new Object[1][];
        HashMap<String, String> test = new HashMap<>();
        test.put("phone", "11111111");
        test.put("landline", "00000000");
        o[0] = new Object[] {test};
        return o;
    }

    @SuppressWarnings("unchecked")
    @DataProvider(name = "data3")
    public static Object[][] data3() {
        Object[][] o = new Object[1][];
        HashMap<String, String> test = new HashMap<>();
        test.putAll((HashMap<String, String>) data1()[0][0]);
        test.putAll((HashMap<String, String>) data2()[0][0]);
        o[0] = new Object[] {test};
        return o;
    }
}
