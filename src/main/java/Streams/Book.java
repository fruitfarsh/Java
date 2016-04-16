package Streams;

import java.time.Year;

public class Book {
    String title;
    int[] pageCounts;
    double height;
    Topic topic;
    Year year;

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

    public static enum Topic {
        FANTASTIC,
        ROMAN,
        COMEDIA,
        HORROR
    }
}
