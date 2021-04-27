package com.company;
import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class ReadAndWriteService {

    public static void updateReaders(ArrayList<Reader> readers) throws IOException {
        File fold = new File("readerData.txt");
        FileWriter fout = new FileWriter(fold);

        for(Reader reader: readers){
            String str = reader.getName() + "," +
                    reader.getPhoneNumber() +  "," +
                    reader.getFavouriteGenreId() +  "," +
                    reader.getMemberName() + "," +
                    reader.getPersonId() + "," +
                    reader.getStrikes() + "," +
                    reader.getStartingDate() + "," +
                    reader.getMembershipOption() +  "," +
                    reader.getCurrNumberOfBooks();

            fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadReaders(ArrayList<Reader> readers) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("readerData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            readers.add(new Reader(atributes[4], atributes[0], atributes[1], atributes[2], atributes[3],
                    LocalDate.parse(atributes[6]), MembershipOptions.valueOf(atributes[7]),
                    Integer.parseInt(atributes[8]), Integer.parseInt(atributes[5])));
        }
    }

    public static void updateBooks(ArrayList<Book> books) throws IOException {
        File fold = new File("booksData.txt");
        FileWriter fout = new FileWriter(fold);

        for(Book book: books){
            String str
                    = book.getBookId() + ","
                    + book.getTitle() + ","
                    + book.getAuthorId() + ","
                    + book.getGenreId() + ","
                    + book.getNumberOfCopies() + ","
                    + book.getYearPublished();
                    fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadBooks(ArrayList<Book> books) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("booksData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            books.add(new Book(atributes[0], atributes[1], atributes[2], atributes[3],
                    Integer.parseInt(atributes[4]), Integer.parseInt(atributes[5])));
        }
    }

    public static void updateBookCopies(ArrayList<BookCopy> bookCopies) throws IOException {
        File fold = new File("bookCopiesData.txt");
        FileWriter fout = new FileWriter(fold);

        for(BookCopy bookCopy: bookCopies){
            String str
                    = bookCopy.getBookCopyId() + ","
                    + bookCopy.getBookId() + ","
                    + bookCopy.getAvailable();

                    fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadBookCopies(ArrayList<BookCopy> bookCopies) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("bookCopiesData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            bookCopies.add(new BookCopy(atributes[0], atributes[1], Boolean.parseBoolean(atributes[2])));
        }
    }

    public static void updateBorrows(ArrayList<Borrow> borrows) throws IOException {
        File fold = new File("borrowsData.txt");
        FileWriter fout = new FileWriter(fold);

        for(Borrow borrow: borrows){
            String str
                    = borrow.getBorrowId() + ","
                    + borrow.getBookCopyId() + ","
                    + borrow.getReaderId() + ","
                    + borrow.getDateBorrowed() + ","
                    + borrow.getLimit() + ","
                    + borrow.getDateReturned();

            fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadBorrows(ArrayList<Borrow> borrows) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("borrowsData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            borrows.add(new Borrow(atributes[0], atributes[1], atributes[2],
                    LocalDate.parse(atributes[3]), Integer.parseInt(atributes[4]),
                    (!(atributes[5].equals("null")) ? LocalDate.parse(atributes[5]) : null)));
        }
    }

    public static void updateAuthors(ArrayList<Author> authors) throws IOException {
        File fold = new File("authorsData.txt");
        FileWriter fout = new FileWriter(fold);

        for(Author author: authors){
            String str
                    = author.getPersonId() + ","
                    + author.getName() + ","
                    + author.getMainGenreId() + ","
                    + author.getDateOfBirth() + ","
                    + author.getContemporary();

            fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadAuthors(ArrayList<Author> authors) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("authorsData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            authors.add(new Author(atributes[0], atributes[1], atributes[2],
                    LocalDate.parse(atributes[3]), Boolean.parseBoolean(atributes[4])));
        }
    }

    public static void updateGenres(ArrayList<Genre> genres) throws IOException {
        File fold = new File("genresData.txt");
        FileWriter fout = new FileWriter(fold);

        for(Genre genre: genres){
            String str
                    = genre.getGenreId() + ","
                    + genre.getGenreName() + ","
                    + genre.getGenreDescription() + ","
                    + genre.getaisle();

            fout.write(str + "\n");
        }
        fout.close();
    }

    public static void uploadGenres(ArrayList<Genre> genres) throws IOException{
        BufferedReader fin =  new BufferedReader(new FileReader("genresData.txt"));
        String str;
        while((str = fin.readLine()) != null){
            String[] atributes = str.split(",", 0);
            genres.add(new Genre(atributes[0], atributes[1], atributes[2],
                    Integer.parseInt(atributes[3])));
        }
    }

    public static void updateHistory(String action, Timestamp timestamp) throws IOException{
        String textToAppend = action + "," + timestamp.toString() + "\n";
        BufferedWriter fout = new BufferedWriter(
                new FileWriter("historyData.txt", true));
        fout.write(textToAppend);
        fout.close();
    }

}
