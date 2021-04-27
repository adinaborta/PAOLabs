package com.company;

import java.time.LocalDate;

public class Database1 extends Database {
    public Database1() {
        this.genreService.addGenres(
                new Genre("Romance", "Romantic books", 20),
                new Genre("SF", "Fantastic stories", 10),
                new Genre("History", "Real life stories", 15),
                new Genre("Horror", "Scary stories", 5),
                new Genre("Architecture", "Artistic pictures", 10)
        );
        try {
            this.authorService.addAuthors(
                    new Author("Jane Austen",
                            this.genreService.getGenreByName("Romance"),
                            LocalDate.of(1775, 7, 18)),
                    new Author("Frank Herbert",
                            this.genreService.getGenreByName("SF"),
                            LocalDate.of(1920, 2, 11)),
                    new Author("Barbara W. Tuchman",
                            this.genreService.getGenreByName("History"),
                            LocalDate.of(1912, 2, 6)),
                    new Author("Stephen King",
                            this.genreService.getGenreByName("Horror"),
                            LocalDate.of(1947, 9, 21)),
                    new Author("Christopher Alexander",
                            this.genreService.getGenreByName("Architecture"),
                            LocalDate.of(1936, 10, 4))
            );
            this.bookService.addBooks(
                    new Book("Pride and Prejudice",
                            this.authorService.getAuthorIdByName("Jane Austen"),
                            this.genreService.getGenreByName("Romance"), 20, 1813),
                    new Book("Sense and Sensibility",
                            this.authorService.getAuthorIdByName("Jane Austen"),
                            this.genreService.getGenreByName("Romance"), 15, 1811),
                    new Book("Persuasion",
                            this.authorService.getAuthorIdByName("Jane Austen"),
                            this.genreService.getGenreByName("Romance"), 1, 1818),

                    new Book("Dune",
                            this.authorService.getAuthorIdByName("Frank Herbert"),
                            this.genreService.getGenreByName("SF"), 30, 1965),
                    new Book("The White Plague",
                            this.authorService.getAuthorIdByName("Frank Herbert"),
                            this.genreService.getGenreByName("SF"), 20, 1982),
                    new Book("The Jesus Incident",
                            this.authorService.getAuthorIdByName("Frank Herbert"),
                            this.genreService.getGenreByName("SF"), 35, 1979),

                    new Book("The Guns of August",
                            this.authorService.getAuthorIdByName("Barbara W. Tuchman"),
                            this.genreService.getGenreByName("History"), 20, 1962),
                    new Book("The Proud Tower",
                            this.authorService.getAuthorIdByName("Barbara W. Tuchman"),
                            this.genreService.getGenreByName("History"), 40, 1966),
                    new Book("A Distant Mirror",
                            this.authorService.getAuthorIdByName("Barbara W. Tuchman"),
                            this.genreService.getGenreByName("History"), 3, 1978),

                    new Book("IT",
                            this.authorService.getAuthorIdByName("Stephen King"),
                            this.genreService.getGenreByName("Horror"), 50, 1986),
                    new Book("The Stand",
                            this.authorService.getAuthorIdByName("Stephen King"),
                            this.genreService.getGenreByName("Horror"), 30, 1978),
                    new Book("Pet Sematary",
                            this.authorService.getAuthorIdByName("Stephen King"),
                            this.genreService.getGenreByName("Horror"), 35, 1983),

                    new Book("A pattern Language",
                            this.authorService.getAuthorIdByName("Christopher Alexander"),
                            this.genreService.getGenreByName("Architecture"), 30, 1977),
                    new Book("The Nature of Order",
                            this.authorService.getAuthorIdByName("Christopher Alexander"),
                            this.genreService.getGenreByName("Architecture"), 40, 2003),
                    new Book("A City Is not a Tree",
                            this.authorService.getAuthorIdByName("Christopher Alexander"),
                            this.genreService.getGenreByName("Architecture"), 10, 1975)
            );
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}