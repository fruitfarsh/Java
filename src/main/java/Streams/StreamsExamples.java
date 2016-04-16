package Streams;


import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamsExamples {


    public static void example01() {
        System.out.println("Streams examples 01");
        IntStream.iterate(2, i -> i * 2).limit(10).forEachOrdered(System.out::println);

        Optional<Integer> max = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                                .stream()
                                .map(i -> i + 1)
                                .max(Integer::compareTo);

        OptionalInt maxInt = IntStream.rangeClosed(1, 7).map(i->i+1).max();


    }
}
