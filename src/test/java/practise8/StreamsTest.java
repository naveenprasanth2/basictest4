package practise8;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> test = () -> IntStream.rangeClosed(1, 10).boxed();
        test.get().forEach(System.out::println);
    }
}
