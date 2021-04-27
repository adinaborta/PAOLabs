package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Reader extends Person {
    private LocalDate startingDate;
    private MembershipOptions membershipOption;
    private String favouriteGenreId;
    private int currNumberOfBooks = 0;
    private String phoneNumber;
    private int strikes = 0;
    private String memberName;


    public Reader(String name, String phoneNumber, String favouriteGenreId, String memberName) {
        super(name);
        this.favouriteGenreId = favouriteGenreId;
        this.membershipOption = MembershipOptions.Standard;
        this.startingDate = java.time.LocalDate.now();
        this.phoneNumber = phoneNumber;
        this.memberName = memberName;
    }

    public Reader(String id, String name, String phoneNumber, String favouriteGenreId, String memberName,
                  LocalDate startingDate, MembershipOptions membershipOption, int currNumberOfBooks, int strikes) {
        super(id, name);
        this.favouriteGenreId = favouriteGenreId;
        this.membershipOption = MembershipOptions.Standard;
        this.startingDate = java.time.LocalDate.now();
        this.phoneNumber = phoneNumber;
        this.memberName = memberName;
        this.startingDate = startingDate;
        this.membershipOption = membershipOption;
        this.currNumberOfBooks = currNumberOfBooks;
        this.strikes = strikes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setMembershipOption(MembershipOptions membershipOption) {
        this.membershipOption = membershipOption;
    }

    public void setFavouriteGenreId(String favouriteGenreId) {
        this.favouriteGenreId = favouriteGenreId;
    }

    public void setCurrNumberOfBooks(int currNumberOfBooks) {
        this.currNumberOfBooks = currNumberOfBooks;
    }

    public String getFavouriteGenreId() {
        return favouriteGenreId;
    }

    public int getCurrNumberOfBooks() {
        return currNumberOfBooks;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public MembershipOptions getMembershipOption() {
        return membershipOption;
    }

    public void updateNumberOfBooks(){
        this.currNumberOfBooks += 1;
    }

    public void updateStrikes(){
        this.strikes += 1;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "startingDate=" + startingDate +
                ", membershipOption=" + membershipOption +
                ", favouriteGenreId='" + favouriteGenreId + '\'' +
                ", currNumberOfBooks=" + currNumberOfBooks +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", strikes=" + strikes +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
