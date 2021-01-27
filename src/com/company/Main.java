package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Book> Books = new ArrayList<>();
    public static ArrayList<Person> Persons = new ArrayList<>();

    public static void main(String[] args) {
        Book book1 = new Book(01, "Alphabet", "Arthur", "01.01.2000", "Science");
        Book book2 = new Book(02, "Da_Vinci_Code", "Dan Brown", "07.04.2003", "Novel");
        Book book3 = new Book(03, "Street", "Unknown", "15.04.2007", "Thriller");
        Book book4 = new Book(04, "Life_isn't_easy_nowadays", "Ellie", "01.01.2021", "Novel");
        Book book5 = new Book(05, "Apartment", "Nick Owens", "02.07.1998", "Fiction");
        Books.add(book1);
        Books.add(book2);
        Books.add(book3);
        Books.add(book4);
        Books.add(book5);

         ArrayList<Book> borrowedBooks1 = new ArrayList<>();
         ArrayList<Book> borrowedBooks2= new ArrayList<>();
        ArrayList<Book> borrowedBooks3 = new ArrayList<>();
        ArrayList<Book> borrowedBooks4 = new ArrayList<>();
        ArrayList<Book> borrowedBooks5= new ArrayList<>();
        Person person1 = new Person(01, "Atabek", "Karim", borrowedBooks1);
        Person person2 = new Person(02, "Lambert", "Bulguchev", borrowedBooks2);
        Person person3 = new Person(03, "Kirill", "Gorovykh", borrowedBooks3);
        Person person4 = new Person(04, "Yasmin", "Zhangusirova", borrowedBooks4);
        Person person5 = new Person(05, "Wael", "Aljabban", borrowedBooks5);
        Persons.add(person1);
        Persons.add(person2);
        Persons.add(person3);
        Persons.add(person4);
        Persons.add(person5);

        int select = -1;

        while (select != 0) {
            System.out.println("1.List of all books");
            System.out.println("2.Add new book to the list");
            System.out.println("3.Add new person");
            System.out.println("4.Borrow book");
            System.out.println("5.List of users");
            System.out.println("6.Return borrowed book to the library");
            select = sc.nextInt();

            if (select == 1) {
                Listofallbooks();
            } else if (select == 2) {
                Addnewbook();
            } else if (select == 3) {
                Addnewperson();
            } else if (select == 4) {
                Personborrowsbook();
            } else if (select == 5) {
                Listofusers();
            } else if (select == 6) {
                Returnborrowedbook();
            }


        }

    }

    private static void Listofallbooks() {
        System.out.println("List of all books: ");
        for (int i = 0; i < Books.size(); i++) {
            System.out.println(Books.get(i).title);
        }
    }

    private static void Addnewbook() {
        System.out.println("Enter ID for new book: ");
        int ID = sc.nextInt();
        System.out.println("How is this book named? ");
        String title = sc.next();
        System.out.println("Who is author of this book? ");
        String author = sc.next();
        System.out.println("When was this book published? ");
        String date = sc.next();
        System.out.println("And finally, what is genre of this book? ");
        String genre = sc.next();
        System.out.println("Successfully added new book to the list! \n");
        Book newBook = new Book(ID, title, author, date, genre);
        Books.add(newBook);

    }

    private static void Addnewperson() {
        System.out.println("Please, enter your id: ");
        int ID = sc.nextInt();
        System.out.println("What is your name? ");
        String name = sc.next();
        System.out.println(name + "," + " what is your surname? ");
        String surname = sc.next();
        System.out.print(name + " ,we are glad to welcome you in our library. Enjoy it! \n");
        ArrayList<Book> borrowedBooks = new ArrayList<>();
        Person newPerson = new Person(ID, name, surname, borrowedBooks);
        Persons.add(newPerson);
    }

    private static void Personborrowsbook() {
        System.out.println("Write your name: ");
        String name = sc.next();
        int index = 0;
        for (int i = 0; i < Persons.size(); i++) {
            if (Persons.get(i).name.equals(name)) {
                index = i;
                System.out.println(name + ", please choose book that you want to borrow: ");
            }
        }
        String title = sc.next();
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).title.equals(title)) {
                System.out.println("Congratulations, you successfully borrowed " + title + "!");
                Persons.get(index).borrowedBooks.add(Books.get(i));
                Books.remove(i);
            }
        }
    }

    private static void Listofusers() {
        System.out.println("List of all users: ");
        for (int i = 0; i < Persons.size(); i++) {
            System.out.println(Persons.get(i).ID);
            System.out.println(Persons.get(i).name);
            System.out.println(Persons.get(i).surname);
            System.out.println("List of borrowed books: ");{
                for (int j = 0; j < Persons.get(i).borrowedBooks.size(); j++) {
                    System.out.println(j + 1 + ") " + Persons.get(i).borrowedBooks.get(j).title);
                }
            }
        }
    }

    private static void Returnborrowedbook() {
        System.out.println("Write your name: ");
        String name = sc.next();
        int index = 0;
        for (int i = 0; i < Persons.size(); i++) {
            if (Persons.get(i).name.equals(name)) {
                System.out.println(name + ", please choose book that you want to return: ");
                for (int j = 0; j < Persons.get(i).borrowedBooks.size(); j++) {
                    System.out.println(j + 1 + ") " + Persons.get(i).borrowedBooks.get(j).title);
                    index = sc.nextInt();
                }
                Books.add(Persons.get(i).borrowedBooks.get(index-1));
                Persons.get(i).borrowedBooks.remove(index-1);
            }
        }
    }
}
