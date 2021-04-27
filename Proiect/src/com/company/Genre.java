package com.company;

import java.util.UUID;

public class Genre {
    private final String genreId;
    private String genreName;
    private String genreDescription;
    private int aisle;

    public Genre(String genreName, String genreDescription, int aisle) {
        this.genreName = genreName;
        this.genreDescription = genreDescription;
        this.aisle = aisle;
        this.genreId = UUID.randomUUID().toString();
    }

    public Genre(String genreId, String genreName, String genreDescription, int aisle) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
        this.aisle = aisle;
    }

    public Genre(String id) {
        this.genreId = UUID.randomUUID().toString();
    }

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
