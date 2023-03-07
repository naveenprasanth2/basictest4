package practise9;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamsTest {
    public static void main(String[] args) {
        List<Integer> test = IntStream.generate(() -> new Random().nextInt(1, 100))
                .limit(25).boxed().toList();

        System.out.println(test);
    }
}
