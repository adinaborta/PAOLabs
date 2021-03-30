package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BorrowService {
    protected ArrayList<Borrow> borrowedBooksList = new ArrayList<Borrow>();

    public void addBorrows(Borrow... borrows){
        this.borrowedBooksList.addAll(Arrays.asList(borrows));
    }

    public int getBorrowIndexByMemberAndBook(String readerId, String bookId, BookService bookService){
        int i = 0;
        for(Borrow borrow: this.borrowedBooksList){
            if(borrow.getReaderId() == readerId && bookId == bookService.getBookIdByCopyId(borrow.getBookCopyId())) {
                return i;
            }
            i += 1;
        }
        return -1;
    }
}
