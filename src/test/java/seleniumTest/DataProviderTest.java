package seleniumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DataProviderTest {
    @Test(dataProvider = "provider3")
    public void test(Map<String, String> test) {
        System.out.println(test.get("name"));
        System.out.println(test.get("last"));
        System.out.println(test.get("phone"));
        System.out.println(test.get("landline"));
    }


    @DataProvider(name = "provider1")
    public static Object[][] provider1() {
        HashMap<String, String> summa = new HashMap<>();
        summa.put("name", "naveen");
        summa.put("last", "prasanth");
        Object[][] o = new Object[1][];
        o[0] = new Object[]{summa};
        return o;
    }

    @DataProvider(name = "provider2")
    public static Object[][] provider2() {
        HashMap<String, String> test = new HashMap<>();
        test.put("phone", "909090909");
        test.put("landline", "563468798798");
        Object[][] o = new Object[1][];
        o[0] = new Object[]{test};
        return o;
    }

    @SuppressWarnings("unchecked")
    @DataProvider(name = "provider3")
    public Object[][] provider3() {
        HashMap<String, String> test = new HashMap<>();
        Object[][] o = new Object[1][];
        test.putAll((HashMap<String, String>) provider1()[0][0]);
        test.putAll((HashMap<String, String>) provider2()[0][0]);
        o[0] = new Object[]{test};
        return o;
    }
}
