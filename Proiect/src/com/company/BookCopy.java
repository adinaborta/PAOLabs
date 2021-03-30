package com.company;

import java.util.UUID;

public class BookCopy {
    private final String bookCopyId = UUID.randomUUID().toString();
    private String bookId;
    private Boolean available = true;

    public BookCopy(String bookId) {
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


