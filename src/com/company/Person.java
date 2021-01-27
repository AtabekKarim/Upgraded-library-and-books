package com.company;

import java.util.ArrayList;

public class Person {
    int ID;
    String name;
    String surname;
    ArrayList<Book> borrowedBooks;

    public Person(int ID, String name, String surname, ArrayList<Book> borrowedBooks) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.borrowedBooks = borrowedBooks;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Book> getBooks() {
        return borrowedBooks;
    }

    public void setBooks(ArrayList<Book> books) {
        this.borrowedBooks = books;
    }
}
