package com.company;

import java.util.ArrayList;

class BookCopyService {
    protected ArrayList<BookCopy> bookCopies = new ArrayList<BookCopy>();

    public void addBookCopies(String bookId, int nrOfCopies){
        for(int i = 0; i < nrOfCopies; i++){
            this.bookCopies.add(new BookCopy(bookId));
        }
    }

    public int getNumberOfAvailableCopies(String bookId){
        int nr = 0;
        for(BookCopy bookCopy: this.bookCopies){
            if(bookCopy.getBookId().equals(bookId))
                if(bookCopy.getAvailable()){
                    nr += 1;
                }
        }
        return nr;
    }
}
