package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BorrowService {
    protected ArrayList<Borrow> borrowedBooksList = new ArrayList<Borrow>();

    public void addBorrows(Borrow... borrows){
        this.borrowedBooksList.addAll(Arrays.asList(borrows));
    }

    public int getBorrowIndexByMemberAndBook(String readerId, String bookId){
        int i = 0;
        for(Borrow borrow: this.borrowedBooksList){
            if(borrow.getReaderId().equals(readerId) && bookId.equals(borrow.getBookCopyId())) {
                return i;
            }
            i += 1;
        }
        return -1;
    }
}
