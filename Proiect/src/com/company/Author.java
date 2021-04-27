package com.company;

import java.time.LocalDate;
import java.util.Date;

public class Author extends Person{
    private String mainGenreId;
    private LocalDate dateOfBirth;
    private Boolean contemporary = false;

    public Author(String name, String mainGenreId, LocalDate dateOfBirth) {
        super(name);
        this.mainGenreId = mainGenreId;
        this.dateOfBirth = dateOfBirth;
        if(dateOfBirth.isBefore(java.time.LocalDate.now().minusYears(60))){
            this.contemporary = false;
        }
        else{
            this.contemporary = true;
        }
    }

    public Author(String id, String name, String mainGenreId, LocalDate dateOfBirth, Boolean contemporary) {
        super(id, name);
        this.mainGenreId = mainGenreId;
        this.dateOfBirth = dateOfBirth;
        this.contemporary = contemporary;
    }

    public Author(String name, String mainGenreId, LocalDate dateOfBirth, Boolean contemporary) {
        super(name);
        this.mainGenreId = mainGenreId;
        this.dateOfBirth = dateOfBirth;
        this.contemporary = contemporary;
    }

    public void setMainGenreId(String mainGenreId) {
        this.mainGenreId = mainGenreId;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setContemporary(Boolean contemporary) {
        this.contemporary = contemporary;
    }

    public String getMainGenreId() {
        return mainGenreId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getContemporary() {
        return contemporary;
    }
}
