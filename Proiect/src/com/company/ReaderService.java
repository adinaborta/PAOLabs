package com.company;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ReaderService {
    protected ArrayList<Reader> readers = new ArrayList<Reader>();

    public void addReader(Reader... readers){
        this.readers.addAll(Arrays.asList(readers));
    }


    public void showReaders(GenreService genreService){
        for(Reader reader: this.readers){
            try {
                System.out.println("Nume: "
                        + reader.getName()
                        + "\nPhone number: "
                        + reader.getPhoneNumber()
                        + "\nFavourite genre: "
                        + genreService.getGenreNameById(reader.getFavouriteGenreId())
                        + "\nMembership status: "
                        + reader.getMembershipOption().toString()
                        + "\nMember since: "
                        + reader.getStartingDate().toString()
                        + "\nMember name: "
                        + reader.getMemberName().toString()
                        + "\nCurrent number of books:: "
                        + reader.getCurrNumberOfBooks()
                        + "\nStrikes: "
                        + reader.getStrikes()
                        + "\n\n"
                );
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }


    public String getReaderIdByMemberName(String memberName){
        for(Reader reader: readers){
            if(Utility.compareStrings(memberName, reader.getMemberName())){
                return reader.getPersonId();
            }
        }
        return "INCORECT";
    }

    public void updateNumberOfBooks(String readerId){
        for(Reader reader: this.readers){
            if(reader.getPersonId().equals(readerId)){
                reader.updateNumberOfBooks();
                break;
            }
        }
    }

    public int getReaderIndexById(String readerId){
        int i = 0;
        for(Reader reader: this.readers){
            if(reader.getPersonId().equals(readerId)){
                return i;
            }
            i += 1;
        }
        return -1;
    }}
