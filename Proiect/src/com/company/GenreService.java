package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenreService {
    protected ArrayList<Genre> genres = new ArrayList<Genre>();

    public void addGenres(Genre... genres){
        this.genres.addAll(Arrays.asList(genres));
    }

    public String getGenreByName(String genreName){
        for (Genre genre: this.genres){
            if(genre.getGenreName() == genreName){
                return genre.getGenreId();
            }
        }
        return "INCORRECT";
    }

    public String getGenreIdFromScanner(){
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for(Genre genre: this.genres){
            System.out.println(i + " " + genre.getGenreName());
            i++;
        }
        int position = scanner.nextInt();

        return this.genres.get(position-1).getGenreId();
    }

    public String getGenreNameById(String genreId){
        for (Genre genre: this.genres){
            if(genre.getGenreId() == genreId){
                return genre.getGenreName();
            }
        }
        return "INCORRECT";
    }


}
