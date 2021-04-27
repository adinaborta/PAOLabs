package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Borrow {
    private final String borrowId;
    private String bookCopyId;
    private String readerId;
    private LocalDate dateBorrowed;
    private int limit = 10;
    private LocalDate dateReturned = null;

    public Borrow(String bookCopyId, String readerId) {
        this.borrowId = UUID.randomUUID().toString();
        this.bookCopyId = bookCopyId;
        this.readerId = readerId;
        this.dateBorrowed = java.time.LocalDate.now();
    }

    public Borrow(String borrowId, String bookCopyId, String readerId, LocalDate dateBorrowed, int limit, LocalDate dateReturned) {
        this.borrowId = borrowId;
        this.bookCopyId = bookCopyId;
        this.readerId = readerId;
        this.dateBorrowed = dateBorrowed;
        this.limit = limit;
        this.dateReturned = dateReturned;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public String getReaderId() {
        return readerId;
    }

    public LocalDate getDateBorrowed() {
        return dateBorrowed;
    }

    public int getLimit() {
        return limit;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public void setDateBorrowed(LocalDate dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }
}
