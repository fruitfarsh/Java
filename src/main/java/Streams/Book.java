package Streams;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class Book {
    String title;

    List<String> autor;

    int[] pageCounts;
    double height;
    Topic topic;
    Year year;
    public static List<Book> library = createLibrary();


    static List<Book> createLibrary() {
        Book book1 = new Book("Sherlock", "Doel",new int[] {200}, 25.3, Topic.COMEDIA, Year.of(1985));
        Book book2 = new Book("War and peace", "Tolstoy", new int[]{300, 400, 500}, 55.9, Topic.ROMAN, Year.of(1872));
        Book book3 = new Book("Tom Soyer", "Pushkin", new int[]{155}, 32.1, Topic.FANTASTIC, Year.of(1864));

        return Arrays.asList(book1, book2, book3);
    }

    public Book(String title, int[] pageCounts, double height, Year year) {
        this.title = title;
        this.pageCounts = pageCounts;
        this.height = height;
        this.topic = Topic.ROMAN;
        this.year = year;
    }

    public Book(String title, int[] pageCounts, double height, Topic topic, Year year) {
        this.title = title;
        this.pageCounts = pageCounts;
        this.height = height;
        this.topic = topic;
        this.year = year;
    }

    public Book(String title, String autor, int[] pageCounts, double height, Topic topic, Year year) {
        this.title = title;
        this.autor.add(autor);
        this.pageCounts = pageCounts;
        this.height = height;
        this.topic = topic;
        this.year = year;
    }

    public Topic getTopic() {

        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int[] getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(int[] pageCounts) {
        this.pageCounts = pageCounts;
    }

    public List<String> getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor.add(autor);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public static List<Book> getLibrary() {
        return library;
    }

    public static void setLibrary(List<Book> library) {
        Book.library = library;
    }
    public static enum Topic {
        FANTASTIC,
        ROMAN,
        COMEDIA,
        HORROR;
    }
}
