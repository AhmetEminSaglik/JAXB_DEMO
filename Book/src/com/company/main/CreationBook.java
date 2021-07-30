package com.company.main;

import com.company.book.Book;
import com.company.bookstore.Bookstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreationBook {
    //    private final String BOOKSTORE_XML = "bookstore-jaxb.xml";
    private String fileName;
    private Bookstore bookstore;

    public CreationBook(String fileName, Bookstore bookstore) throws JAXBException, IOException {
        this.fileName = fileName;
        this.bookstore = bookstore;

        List<Book> bookList = new ArrayList<Book>();

        // create books
        Book book1 = new Book();
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
        bookList.add(book2);

        Book book3 = new Book();
        book3.setIsbn("1233333");
        book3.setName("Sari Esirler");
        book3.setAuthor(null);
        book3.setPublisher("GETIR");
        bookList.add(book3);
        // create bookstore, assigning book
//        bookstore = new Bookstore();
        bookstore.setName("Amazon Bookstore");
        bookstore.setLocation("Newyorkt");
        bookstore.setBookList(bookList);
        System.out.println("------->>> kitaplar eklenecek");

        convertObjectToXML(bookstore);

    }

    private void convertObjectToXML(Bookstore bookstore) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(bookstore, System.out);

        // Write to File
        m.marshal(bookstore, new File(fileName));
        System.out.println("------->>> kitaplar eklenmis olmali");
    }

//    public Bookstore getBookstore() {
//        return bookstore;
//    }
//
//    public void setBookstore(Bookstore bookstore) {
//        this.bookstore = bookstore;
//    }
}
