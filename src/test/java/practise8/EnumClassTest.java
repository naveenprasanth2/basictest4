package practise8;

import org.testng.annotations.Test;

public class EnumClassTest {
    @Test
    public static void test() {
        System.out.println(EnumTest.APPLE.price);
        System.out.println(EnumTest.ORANGE.price);
    }
}
