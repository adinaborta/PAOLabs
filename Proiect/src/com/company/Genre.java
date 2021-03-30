package com.company;

import java.util.UUID;

public class Genre {
    private final String genreId = UUID.randomUUID().toString();
    private String genreName;
    private String genreDescription;
    private int aisle;

    public Genre(String genreName, String genreDescription, int aisle) {
        this.genreName = genreName;
        this.genreDescription = genreDescription;
        this.aisle = aisle;
    }

    public Genre() {}

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    public void setaisle(int aisle) {
        this.aisle = aisle;
    }

    public String getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public int getaisle() {
        return aisle;
    }
}
