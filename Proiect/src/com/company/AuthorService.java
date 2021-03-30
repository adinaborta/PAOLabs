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

    public String getAuthorIdByName(String authorName){
        for (Author author: this.authors){
            if(author.getName() == authorName){
                return author.getPersonId();
            }
        }
        return "INCORRECT";
    }

    public String getAuthorNameById(String authorId){
        for (Author author: this.authors){
            if(author.getPersonId() == authorId){
                return author.getName();
            }
        }
        return "INCORRECT";
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
            if(author.getPersonId() == authorId){
                return author;
            }
        }
        return null;
    }
}
