package practise8;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> test = () -> Stream.of(1,2,3);
        test.get().forEach(System.out::println);
    }
}
