package practise1;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="data3")
	public void test(HashMap<String,String> test) {
		System.out.println(test.get("name"));
		System.out.println(test.get("age"));
		System.out.println(test.get("location"));
		System.out.println(test.get("phone"));
		
	}
	@DataProvider(name="data1")
	public static Object[][] data1(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("name","naveen");
	test.put("age", "20");
	o[0] = new Object[] {test};
	return o;
	}

	@DataProvider(name="data2")
	public static Object[][] data2(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("location","namakkal");
	test.put("phone","766786586978");
	o[0] = new Object[] {test};
	return o;
	}

	@SuppressWarnings("unchecked")
	@DataProvider(name="data3")
	public Object[][] data3(){
	Object[][] o = new Object[1][];
	HashMap<String,String> test = new HashMap<String,String>();
	test.putAll((HashMap<String,String>)data1()[0][0]);
	test.putAll((HashMap<String,String>)data2()[0][0]);
	o[0] = new Object[] {test};
	return o;
	}
}
