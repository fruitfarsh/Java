package Streams;


import java.time.Year;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {


    public static void example01() {
        System.out.println("Streams examples 01");
        IntStream.iterate(2, i -> i * 2).limit(10).forEachOrdered(System.out::println);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

                Optional<Integer> max = list
                                .stream()
                                .map(i -> i + 1)
                                .max(Integer::compareTo);

        OptionalInt maxInt = IntStream.rangeClosed(1, 7).map(i->i+1).max();
    }


    public static void example02()
    {
        Book book1 = new Book("Sherlock", new int[] {200}, 25.3, Book.Topic.COMEDIA, Year.of(1985));
        Book book2 = new Book("War and peace", new int[]{300, 400, 500}, 55.9, Year.of(1872));
        Book book3 = new Book("Tom Soyer", new int[]{155}, 32.1, Book.Topic.FANTASTIC, Year.of(1864));

        List<Book> library = Arrays.asList(book1, book2, book3);
        Stream<Book> filteredStream = library.stream().filter(b->b.getTopic() == Book.Topic.ROMAN);

        Stream<String> map = library.stream().map(b->b.getTitle());

        library.stream().sorted(Comparator.comparing(Book::getTitle));



    }

}
