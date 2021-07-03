package practise3;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> test = new HashMap<String, Integer>();
		test.put("Apple", 200);
		test.put("Mac", 2000);
		test.put("Win", 199);
		test.entrySet().stream().reduce((x1, x2) -> x1.getValue() > x2.getValue() ? x1 : x2)
				.ifPresent(System.out::println);
		IntStream.rangeClosed(1, 10).filter(x -> x > 5).forEach(System.out::print);
//		IntStream.iterate(0, n -> n + 1).filter(x -> x % 2 == 0).limit(10).forEach(System.out::println);
		IntStream.generate(() -> (new Random()).nextInt(100)).limit(10).forEach(System.out::println);

	}

}
