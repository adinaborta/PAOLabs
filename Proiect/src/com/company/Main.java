package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database1 database1 = new Database1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! What would you like to do?\n");
        while(true){
            System.out.println(
                            "1. Become a member\n" +
                            "2. See all the books in a specific genre\n" +
                            "3. See all books from a specific author\n" +
                            "4. Borrow a book\n" +
                            "5. Return a book\n" +
                            "6. See memberships informations and benefits\n" +
                            "7. See all members\n" +
                            "8. See available copies for a certain book\n" +
                            "9. See all books\n" +
                            "10. See all contemporary books"
                    );
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    database1.newMember();
                    break;
                case 2:
                    database1.showBooksByGenre();
                    break;
                case 3:
                    database1.showBooksByAuthor();
                    break;
                case 4:
                    database1.borrowBook();
                    break;
                case 5:
                    database1.returnBook();
                    break;
                case 6:
                    database1.showMembershipInformations();
                    break;
                case 7:
                    database1.showAllMembers();
                    break;
                case 8:
                    database1.bookService.showAvailableBooks();
                    break;
                case 9:
                    database1.bookService.showBooks(database1.authorService, database1.genreService);
                    break;
                case 10:
                    database1.bookService.showContemporaryBooks(database1.authorService, database1.genreService);
                    break;
            }
            System.out.println("Would you like to continue? 1 - yes, 0 - no");
            if(scanner.nextInt() == 0){
                break;
            }
            System.out.println("What would you like to do next?\n");

        }


    }
}
