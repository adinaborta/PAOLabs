package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Connection db = DatabaseConnection.getInstance().conn;
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
    void showAllMembers(){
        System.out.println("For this action we need an authorised password: ");
        Scanner scanner = new Scanner(System.in);
        for(int i = 2; i >= 0; i--){
            String pass = scanner.nextLine();
            if(!pass.equals("librarian")){
                System.out.println("Wrong password. " + i + " chances left.");
            }
            else{
                try{
                    String querySQL= (
                            "SELECT *" +
                                    "FROM reader");
                    var stmt = db.createStatement();
                    var rs = stmt.executeQuery(querySQL);
                    while(rs.next()){
                        System.out.println(rs.getString("name") + " " +
                                rs.getString("starting_date") + " " +
                                rs.getString("phone_number") + " " +
                                rs.getString("member_name") + " " +
                                rs.getString("member_name") + " " +
                                rs.getString("current_number_of_books") + "\n");
                    }
                }
                catch (SQLException ex){
                    System.out.println(ex);
                }
                return;
            }
        }
    }
    String getGenresFromScanner(){
        try{
            Statement stmt1 = db.createStatement();
            Scanner scanner = new Scanner(System.in);
            String querySql =
                    "SELECT genre_name " +
                            "FROM genre ";
            int i = 1;
            var rs = stmt1.executeQuery(querySql);
            String [] genres = new String[100];
            while(rs.next()){
                genres[i-1] = rs.getString("genre_name");
                System.out.println(i + ". " + genres[i-1]);
            }

            int position = scanner.nextInt();
            querySql =
                    "SELECT genre_id " +
                            "FROM genre " +
                            "WHERE genre_name=?;";
            var stmt2 = db.prepareStatement(querySql);
            stmt2.setString(1, genres[position - 1]);
            rs = stmt2.executeQuery();
            if(rs.next()){
                return rs.getString("genre_id");
            }

        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return "Err";
    }
    void showBooksByGenre(){
        System.out.println("What genre are you looking for?");
        String genreId = getGenresFromScanner();
        try {
            String querySQL= (
                    "SELECT b.title, a.name, g.genre_name, b.number_of_copies, b.year_published" +
                            "FROM genre g, book b, author a " +
                            "WHERE genre_id = ?" +
                            "AND b.genre_id = g.genre_id " +
                            "AND b.author_id = a.author_id;");
            var stmt = db.prepareStatement(querySQL);
            stmt.setString(1, genreId);
            var rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("title") + " " +
                        rs.getString("name") + " " +
                        rs.getString("genre_name") + " " +
                        rs.getString("number_of_copies") + " " +
                        rs.getString("year_published") + "\n");
            }
        }
        catch (
                SQLException ex){
            System.out.println(ex);
        }
    }
    String getAuthorIdFromScanner(){
        try{
            Statement stmt1 = db.createStatement();
            Scanner scanner = new Scanner(System.in);
            String querySql =
                    "SELECT name " +
                            "FROM author ";
            int i = 1;
            var rs = stmt1.executeQuery(querySql);
            String [] authors = new String[100];
            while(rs.next()){
                authors[i-1] = rs.getString("name");
                System.out.println(i + ". " + authors[i-1]);
            }

            int position = scanner.nextInt();
            querySql =
                    "SELECT author_id " +
                            "FROM author " +
                            "WHERE name=?;";
            var stmt2 = db.prepareStatement(querySql);
            stmt2.setString(1, authors[position - 1]);
            rs = stmt2.executeQuery();
            if(rs.next()){
                return rs.getString("author_id");
            }

        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return"Error";
    }

    void showBooksByAuthor(){
        System.out.println("What author are you looking for?");
        String authorId = getAuthorIdFromScanner();
        try {
            String querySQL= (
                    "SELECT b.title, a.name, g.genre_name, b.number_of_copies, b.year_published" +
                            "FROM genre g, book b, author a " +
                            "WHERE author_id = ?" +
                            "AND b.genre_id = g.genre_id " +
                            "AND b.author_id = a.author_id;");
            var stmt = db.prepareStatement(querySQL);
            stmt.setString(1, authorId);
            var rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("title") + " " +
                        rs.getString("name") + " " +
                        rs.getString("genre_name") + " " +
                        rs.getString("number_of_copies") + " " +
                        rs.getString("year_published") + "\n");
            }
        }
        catch (
                SQLException ex){
            System.out.println(ex);
        }
    }

    void incrementNumberOfBooks(String readerId){
        try{
            String querySQL= (
                    "SELECT current_number_of_books" +
                            "FROM reader" +
                            "WHERE reader_id = ?;");
            var stmt = db.createStatement();
            var rs = stmt.executeQuery(querySQL);
            int nr_books;
            if(rs.next()){
                nr_books = rs.getInt("current_number_of_books");
            }

            querySQL= (
                    "UPDATE reader" +
                            "SET current_number_of_books = ?" +
                            "WHERE reader_id = ?;");
            var stmt2 = db.createStatement();
            var rs2 = stmt2.executeUpdate(querySQL);
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }


}
