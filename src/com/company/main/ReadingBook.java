package com.company.main;


import com.company.book.Book;
import com.company.bookstore.Bookstore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Unmarshaller Class - Convert XML to Object in Java
 *
 * @author Ramesh Fadatare
 */
public class ReadingBook {

    private Bookstore bookstore;
    private List<Book> list;
//    private final String BOOKSTORE_XML = "bookstore-jaxb.xml";


    public ReadingBook(String fileName, Bookstore bookstore) throws JAXBException, IOException {
        this.bookstore = bookstore;
//        List<Book> bookList = new ArrayList<Book>();

        // create books
    /*    Book book1 = new Book();
        book1.setIsbn("978-0134685991");
        book1.setName("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setPublisher("Amazon");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-0596009205");
        book2.setName("Head First Java, 2nd Edition");
        book2.setAuthor("Kathy Sierra");
        book2.setPublisher("amazon");
        bookList.add(book2);*/

        // create bookstore, assigning book
//        this.bookstore = bookstore;
//        bookstore.setName("Amazon Bookstore");
//        bookstore.setLocation("Newyorkt");
//        bookstore.setBookList(bookList);


        convertXMLToObject(fileName);
    }
//
//    Bookstore createBookstore() {
//        bookstore = new Bookstore();
//        bookstore.setName("AES Bookstore");
//        bookstore.setLocation("Ankara/Turkey");
//        return bookstore;
//    }

    private Bookstore convertXMLToObject(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller un = context.createUnmarshaller();
            Bookstore bookstore = (Bookstore) un.unmarshal(new File(fileName));

            System.out.println(bookstore.toString());
            list = bookstore.getBooksList();
            for (Book book : list) {
                System.out.println("Book: " + book.getName() + " from " + book.getAuthor());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public Bookstore getBookstore(int a) {
//        if (bookstore == null) {
////            bookstore = createBookstore();
//        }
//        return bookstore;
//    }
//
//    public void setBookstore(Bookstore bookstore) {
//        this.bookstore = bookstore;
//    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}