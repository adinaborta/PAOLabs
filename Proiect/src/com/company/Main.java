package com.company;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Database database = new Database();

        ReadAndWriteService.uploadReaders(database.readerService.readers);
        ReadAndWriteService.uploadBorrows(database.borrowService.borrowedBooksList);
        ReadAndWriteService.uploadBookCopies(database.bookService.bookCopyService.bookCopies);
        ReadAndWriteService.uploadBooks(database.bookService.books);
        ReadAndWriteService.uploadAuthors(database.authorService.authors);
        ReadAndWriteService.uploadGenres(database.genreService.genres);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! What would you like to do?\n");
        while(true){
            System.out.println(
                            "1. Become a member\n" +
                            "2. See all the books in a specific genre\n" +
                            "3. See all books from a specific author\n" +
                            "4. Borrow a book\n" +
                            "5. Return a book\n" +
                            "6. See memberships information and benefits\n" +
                            "7. See all members\n" +
                            "8. See available copies for a certain book\n" +
                            "9. See all books\n" +
                            "10. See all contemporary books"
                    );
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    database.newMember();
                    ReadAndWriteService.updateHistory("Added-new-member", new Timestamp(System.currentTimeMillis()));
                    break;
                case 2:
                    database.showBooksByGenre();
                    ReadAndWriteService.updateHistory("Select-books-by-genre", new Timestamp(System.currentTimeMillis()));
                    break;
                case 3:
                    database.showBooksByAuthor();
                    ReadAndWriteService.updateHistory("Select-books-by-author", new Timestamp(System.currentTimeMillis()));
                    break;
                case 4:
                    database.borrowBook();
                    ReadAndWriteService.updateHistory("Borrow-book", new Timestamp(System.currentTimeMillis()));
                    break;
                case 5:
                    database.returnBook();
                    ReadAndWriteService.updateHistory("Return-book", new Timestamp(System.currentTimeMillis()));
                    break;
                case 6:
                    database.showMembershipInformations();
                    ReadAndWriteService.updateHistory("Select-membership-information", new Timestamp(System.currentTimeMillis()));
                    break;
                case 7:
                    database.showAllMembers();
                    ReadAndWriteService.updateHistory("Select-all-members", new Timestamp(System.currentTimeMillis()));
                    break;
                case 8:
                    database.bookService.showAvailableBooks();
                    ReadAndWriteService.updateHistory("Select-available-books", new Timestamp(System.currentTimeMillis()));
                    break;
                case 9:
                    database.bookService.showBooks(database.authorService, database.genreService);
                    ReadAndWriteService.updateHistory("Select-books", new Timestamp(System.currentTimeMillis()));
                    break;
                case 10:
                    database.bookService.showContemporaryBooks(database.authorService, database.genreService);
                    ReadAndWriteService.updateHistory("Select-contemporary-books", new Timestamp(System.currentTimeMillis()));
                    break;
            }
            System.out.println("Would you like to continue? 1 - yes, 0 - no");
            if(scanner.nextInt() == 0){
                System.out.println("You have unsaved changes. 1 - save changes, 0 - discard changes");
                    if(scanner.nextInt() != 0){
                        ReadAndWriteService.updateReaders(database.readerService.readers);
                        ReadAndWriteService.updateBorrows(database.borrowService.borrowedBooksList);
                        ReadAndWriteService.updateBookCopies(database.bookService.bookCopyService.bookCopies);
                        ReadAndWriteService.updateBooks(database.bookService.books);
                        ReadAndWriteService.updateAuthors(database.authorService.authors);
                        ReadAndWriteService.updateGenres(database.genreService.genres);
                        ReadAndWriteService.updateHistory("Commit-changes", new Timestamp(System.currentTimeMillis()));
                    }
                    else{
                        ReadAndWriteService.updateHistory("Rollback", new Timestamp(System.currentTimeMillis()));
                    }
                break;
            }
            System.out.println("What would you like to do next?\n");

        }


    }
}
