package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AuthorService{
    protected ArrayList<Author> authors = new ArrayList<Author>();

    public void addAuthors(Author... authors){
        this.authors.addAll(Arrays.asList(authors));
    }

    public String getAuthorIdByName(String authorName) throws Exception {
        for (Author author: this.authors){
            if(author.getName().equals(authorName)){
                return author.getPersonId();
            }
        }
        throw new Exception("Author does not exist");
    }

    public String getAuthorNameById(String authorId) throws Exception {
        for (Author author: this.authors){
            if(author.getPersonId().equals(authorId)){
                return author.getName();
            }
        }
        throw new Exception("Author does not exist");
    }

    public String getAuthorIdFromScanner(){
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for(Author author: this.authors){
            System.out.println(i + " " + author.getName());
            i++;
        }
        int position = scanner.nextInt();

        return this.authors.get(position-1).getPersonId();
    }

    public Author getAuthorById(String authorId){
        for(Author author: this.authors){
            if(author.getPersonId().equals(authorId)){
                return author;
            }
        }
        return null;
    }
}
