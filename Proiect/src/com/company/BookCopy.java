package com.company;

import java.util.UUID;

public class BookCopy {
    private final String bookCopyId;
    private String bookId;
    private Boolean available;

    public BookCopy(String bookId) {
        this.bookId = bookId;
        this.bookCopyId = UUID.randomUUID().toString();
        this.available  = true;
    }

    public BookCopy(String id, String bookId, Boolean available) {
        this.bookCopyId = id;
        this.available = available;
        this.bookId = bookId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public String getBookId() {
        return bookId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}


