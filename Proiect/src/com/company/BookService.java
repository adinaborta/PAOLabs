package com.company;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookService {
    protected ArrayList<Book> books = new ArrayList<Book>();
    protected BookCopyService bookCopyService = new BookCopyService();

    public void addBooks(Book... books){
        for(Book book: books){
            this.books.add(book);
            this.bookCopyService.addBookCopies(book.getBookId(), book.getNumberOfCopies());
        }
    }

    public void showAvailableBooks(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What book do you want to see?");
            String title = scanner.nextLine();
            for(Book book: this.books){
                if(Utility.compareStrings(book.getTitle(), title)){
                    System.out.println(this.bookCopyService.getNumberOfAvailableCopies(book.getBookId()));
                }
            }
            System.out.println("Would you like to look up another book? 0-no, 1-yes");
            int res = scanner.nextInt();
            scanner.nextLine();
            if(res != 1)
                return;
        }

    }

    public void showBooks(AuthorService authorService, GenreService genreService){
        for(Book book: this.books){
            try {
                System.out.println("'" + book.getTitle() + "'"
                        + " by " + authorService.getAuthorNameById(book.getAuthorId())
                        + " is a " + genreService.getGenreNameById(book.getGenreId()) + " book.\nThere are "
                        + book.getNumberOfCopies() + " copies in total in the library and "
                        + this.bookCopyService.getNumberOfAvailableCopies(book.getBookId()) + " available copies at the moment.\n"
                );
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public void showContemporaryBooks(AuthorService authorService, GenreService genreService){
        for(Book book: this.books){
            try {
                if (authorService.getAuthorById(book.getAuthorId()).getContemporary()) {
                    System.out.println("'" + book.getTitle() + "'"
                            + " by " + authorService.getAuthorNameById(book.getAuthorId())
                            + " is a " + genreService.getGenreNameById(book.getGenreId()) + " book.\nThere are "
                            + book.getNumberOfCopies() + " copies in total in the library and "
                            + this.bookCopyService.getNumberOfAvailableCopies(book.getBookId()) + " available copies at the moment.\n"
                    );
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public String getBookIdByTitle(String title){
        for(Book book: books){
            if(Utility.compareStrings(title, book.getTitle())){
                return book.getBookId();
            }
        }
        return "INCORECT";
    }

    public String updateFalseCopyStatus(String bookId){
        for(BookCopy bookCopy: this.bookCopyService.bookCopies){
            if(bookCopy.getBookId().equals(bookId) && bookCopy.getAvailable()){
                bookCopy.setAvailable(false);
                return bookCopy.getBookCopyId();
            }
        }
        return "INCORECT";
    }

    public void updateTrueCopyStatus(String bookCopyId){
        for(BookCopy bookCopy: this.bookCopyService.bookCopies){
            if(bookCopy.getBookCopyId().equals(bookCopyId)){
                bookCopy.setAvailable(true);
            }
        }
    }

    public String getBookIdByCopyId(String bookCopyId){
        for(BookCopy bookCopy: this.bookCopyService.bookCopies){
            if(bookCopy.getBookCopyId().equals(bookCopyId)){
                return bookCopy.getBookId();
            }
        }
        return null;
    }

}
