package com.company;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    public Connection conn = null;

    //static block initialization for exception handling
    private DatabaseConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao", "root", "password");
            Statement stmt = conn.createStatement();
            //drop existing tables
            String querySQL = "DROP TABLE IF EXISTS genre;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS membership;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS author;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS reader;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS book;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS book_copy;";
            stmt.executeUpdate(querySQL);
            querySQL = "DROP TABLE IF EXISTS borrow;";
            stmt.executeUpdate(querySQL);

            // create new tables
            querySQL = "CREATE TABLE genre (" +
                    "  genre_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  genre_name varchar(255)," +
                    "  genre_description varchar(255)," +
                    "  aisle int" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE membership(" +
                    "  membership_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  membership_name int NOT NULL" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE author(" +
                    "  author_id varchar(255) PRIMARY KEY NOT NULL ," +
                    "  name varchar(255) default NULL," +
                    "  genre_id int NOT NULL," +
                    "  date_of_birth DATE," +
                    "  contemporary boolean DEFAULT false," +
                    "  CONSTRAINT author_genre_fk FOREIGN KEY (genre_id) REFERENCES genre(genre_id) ON DELETE CASCADE" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE reader(" +
                    "  reader_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  name varchar(255) default NULL," +
                    "  membership_id int," +
                    "  starting_date DATE," +
                    "  phone_number varchar(255)," +
                    "  member_name VARCHAR(255)," +
                    "  current_number_of_books INT," +
                    "  strikes int," +
                    "  CONSTRAINT reader_membership_fk FOREIGN KEY (membership_id) REFERENCES membership(membership_id) ON DELETE CASCADE" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE book(" +
                    "  book_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  title varchar(255)," +
                    "  author_id int," +
                    "  genre_id int," +
                    "  number_of_copies int," +
                    "  year_published int," +
                    "  CONSTRAINT book_author_fk FOREIGN KEY (author_id) REFERENCES author(author_id) ON DELETE CASCADE," +
                    "  CONSTRAINT book_genre_fk FOREIGN KEY (genre_id) REFERENCES genre(genre_id) ON DELETE CASCADE" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE book_copy(" +
                    "  book_copy_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  book_id int," +
                    "  available boolean," +
                    "  CONSTRAINT book_book_copy_fk FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE" +
                    ");";
            stmt.executeUpdate(querySQL);
            querySQL = "CREATE TABLE borrow(" +
                    "  borrow_id varchar(255) PRIMARY KEY NOT NULL," +
                    "  book_copy_id INT," +
                    "  reader_id INT," +
                    "  date_borrowed DATE," +
                    "  limit_days INT," +
                    "  date_returned DATE," +
                    "  CONSTRAINT borrow_book_copy_fk FOREIGN KEY (book_copy_id) REFERENCES book_copy(book_copy_id) ON DELETE CASCADE," +
                    "  CONSTRAINT borrow_reader_fk FOREIGN KEY (reader_id) REFERENCES reader(reader_id) ON DELETE CASCADE" +
                    ");";
            stmt.executeUpdate(querySQL);

            // insert data
            querySQL = "INSERT INTO genre VALUES ('1', 'Romance', 'Sweet love', 20);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO genre VALUES ('2', 'SF', 'Fantastic stories', 10);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO genre VALUES ('3', 'History', 'Real life stories', 15);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO genre VALUES ('4', 'Horror', 'Scary stories', 5);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO genre VALUES ('5', 'Architecture', 'Artistic pictures', 10);";
            stmt.executeUpdate(querySQL);

            querySQL = "INSERT INTO author VALUES ('1', 'Jane Austen','1' , '1775-07-18', false);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO author VALUES ('2', 'Frank Herbert','2' ,'1920-02-11', false);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO author VALUES ('3', 'Barbara W. Tuchman','3' , '1912-02-06', false);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO author VALUES ('4', 'Stephen King','4' , '1947-09-21', false);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO author VALUES ('5', 'Christopher Alexander','5' , '1936-10-4', false);";
            stmt.executeUpdate(querySQL);

            querySQL = "INSERT INTO book VALUES ('1', 'Pride and Prejudice','1' ,'1', 20, 1813);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('2','Sense and Sensibility', '1', '1', 15, 1811);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('3','Persuasion','1', '1', 1, 1818);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('4','Dune','2', '2', 30, 1965);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('5','The White Plague','2', '2', 20, 1982);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('6','The Jesus Incident','2', '2', 35, 1979);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('7','The Guns of August','3', '3', 20, 1962);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('8','The Proud Tower','3', '3', 40, 1966);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('9','A Distant Mirror','3','3', 3, 1978);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('10','IT','4', '4', 50, 1986);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('11','The Stand','4', '4', 30, 1978);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('12','Pet Sematary','4', '4', 35, 1983);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('13','A pattern Language','5', '5', 30, 1977);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('14','The Nature of Order','5', '5', 40, 2003);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO book VALUES ('15','A City Is not a Tree','5', '5', 10, 1975);";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO membership VALUES ('1','Premium');";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO membership VALUES ('2','Gold');";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO membership VALUES ('3','Standard');";
            stmt.executeUpdate(querySQL);
            querySQL = "INSERT INTO membership VALUES ('4','Guest');";
            stmt.executeUpdate(querySQL);



            System.out.println("Database available");
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
    }


    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
