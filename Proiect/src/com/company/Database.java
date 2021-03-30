package com.company;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

public class Database {
    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();
    BorrowService borrowService = new BorrowService();
    GenreService genreService = new GenreService();
    ReaderService readerService = new ReaderService();


    public void sortMmebers(){
        Collections.sort(bookService.books);
    }

    public void newMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nume: ");
        String name = scanner.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please choose your favourite genre (option 1, 2...): ");
        String genreId = this.genreService.getGenreIdFromScanner();
        System.out.println("Chose a maximum 10 letters member name: ");
        String memberName = scanner.next();

        this.readerService.addReader(
                new Reader(name, phoneNumber, genreId, memberName)
        );
        System.out.println("Thank you for becoming a member!");
    }

    public void showBooksByGenre(){
        System.out.println("What genre are you looking for?");
        String genreId = this.genreService.getGenreIdFromScanner();
        for(Book book: this.bookService.books){
            if(book.getGenreId() == genreId){
                System.out.println("'" + book.getTitle() + "'"
                        + " by " + this.authorService.getAuthorNameById(book.getAuthorId())
                        + " is a " + this.genreService.getGenreNameById(book.getGenreId()) + " book.\nThere are "
                        + book.getNumberOfCopies() + " copies in total in the library and "
                        + bookService.bookCopyService.getNumberOfAvailableCopies(book.getBookId()) + " available copies at the moment.\n"

                );

            }
        }
    }

    public void showBooksByAuthor(){
        System.out.println("What author are you looking for?");
        String authorId = this.authorService.getAuthorIdFromScanner();
        for(Book book: this.bookService.books){
            if(book.getAuthorId() == authorId){
                System.out.println("'" + book.getTitle() + "'"
                        + " by " + this.authorService.getAuthorNameById(book.getAuthorId())
                        + " is a " + this.genreService.getGenreNameById(book.getGenreId()) + " book.\nThere are "
                        + book.getNumberOfCopies() + " copies in total in the library and "
                        + bookService.bookCopyService.getNumberOfAvailableCopies(book.getBookId()) + " available copies at the moment.\n"

                );
            }
        }
    }

    public void showMembershipInformations(){
        System.out.println(MembershipOptions.Guest.toString() + ": "
                + "This option allows you to read any book, but you can not borrow any of them for home.\n"
                + MembershipOptions.Standard.toString() + ": "
                + "You are able to borrow and read in the library. The limit for returning the books is 10 days.\n"
                + MembershipOptions.Gold.toString() + ": "
                + "This membership status is achieved after the 100th borrowed book. This status will bring you benefits such as" +
                " 20% off any bookstore asociated with our library, unlimited number of books that can be borrowed and a limit time of one month.\n"
                + MembershipOptions.Premium.toString() + ": "
                + "This last membership status is achieved after the 500th borrowed book. To encourage people to read more, once you become " +
                "a premium member you have benefits such as 75% off any bookstore asociated with our library and " +
                "tickets to huge events such as 'Booknaval' and 'Art in a bookshell' that take place across the country "+
                "where the greatest writers of our time attend every year"

        );
    }

    public void showAllMembers(){
        System.out.println("For this action we need an authorised password: ");
        Scanner scanner = new Scanner(System.in);
        for(int i = 2; i >= 0; i--){
            String pass = scanner.nextLine();
            if(!pass.equals("librarian")){
                System.out.println("Wrong password. " + i + " chances left.");
            }
            else{
                this.readerService.showReaders(this.genreService);
                return;
            }
        }
    }

    public void borrowBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your member name: ");
        String memberName = scanner.next();
        scanner.nextLine();
        System.out.println("Book name: ");
        String title = scanner.nextLine();

        String readerId = this.readerService.getReaderIdByMemberName(memberName);
        String bookId = this.bookService.getBookIdByTitle(title);

        this.borrowService.addBorrows(new Borrow(readerId, bookId));
        this.readerService.updateNumberOfBooks(readerId);
        this.bookService.updateFalseCopyStatus(bookId);
    }

    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your member name: ");
        String memberName = scanner.next();
        System.out.println("Book name: ");
        String title = scanner.nextLine();

        String readerId = this.readerService.getReaderIdByMemberName(memberName);
        String bookId = this.bookService.getBookIdByTitle(title);

        int borrowIndex = this.borrowService.getBorrowIndexByMemberAndBook(readerId, bookId, this.bookService);

        this.borrowService.borrowedBooksList.get(borrowIndex).setDateReturned(java.time.LocalDate.now());
        this.bookService.updateTrueCopyStatus(this.borrowService.borrowedBooksList.get(borrowIndex).getBookCopyId());

        int limit = this.borrowService.borrowedBooksList.get(borrowIndex).getLimit();
        LocalDate dateBorrowed = this.borrowService.borrowedBooksList.get(borrowIndex).getDateBorrowed();

        if(dateBorrowed.isBefore(java.time.LocalDate.now().minusDays(limit))){
            int readerIndex = this.readerService.getReaderIndexById(readerId);
            this.readerService.readers.get(readerIndex).updateStrikes();
        }

    }
}
