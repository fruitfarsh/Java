package Streams;


import java.util.*;
import java.util.stream.Collectors;
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


    public static void example02() {
        List<Book> library = Book.createLibrary();
        Stream<Book> filteredStream = library.stream().filter(b->b.getTopic() == Book.Topic.ROMAN);

        //Stream<String> map = library.stream().map(b->b.getTitle());

        //library.stream().sorted(Comparator.comparing(Book::getTitle));
    }

    public static void example03(){
        Book.library.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .flatMap(book -> book.getAutor().stream())
                .distinct();

        Book.library.stream().sorted(Comparator.comparing(Book::getTitle))
                .flatMap(book -> book.getAutor().stream()).distinct();

        Book.library.stream().sorted(Comparator.comparing(Book::getTitle))
                .limit(3);

        Book.library.stream().sorted(Comparator.comparing(Book::getTitle))
                .skip(3);

        List<String> list = Book.library.stream().map(Book::getTitle).collect(Collectors.toList());
        System.out.println(list);
        Stream<String> streamOfTitles = Book.library.stream().map(book -> {
            System.out.println(book);
            return book.getTitle();
        }); // transform
    }

}
