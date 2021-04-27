package com.company;

import java.time.LocalDate;
import java.util.UUID;

public class Book implements Comparable<Book>{
    private final String bookId;
    private String title;
    private String authorId;
    private String genreId;
    private int numberOfCopies;
    private int yearPublished;

    public Book(String title, String authorId, String genreId, int numberOfCopies, int yearPublished) {
        this.bookId = UUID.randomUUID().toString();
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
        this.numberOfCopies = numberOfCopies;
        this.yearPublished = yearPublished;
    }

    public Book(String id, String title, String authorId, String genreId, int numberOfCopies, int yearPublished) {
        this.bookId = id;
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
        this.numberOfCopies = numberOfCopies;
        this.yearPublished = yearPublished;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getGenreId() {
        return genreId;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public int compareTo(Book o) {
        return this.getYearPublished() - o.getYearPublished();
    }
}
