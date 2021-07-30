package com.company.main;


import com.company.book.Book;
import com.company.bookstore.Bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Marshaller Class - Convert Java Object to XML
 *
 * @author Ramesh Fadatare
 */
public class BookMain {

    public static void main(String[] args) throws JAXBException, IOException {
        String fileName = "bookstore-jaxb.xml";

        Bookstore bookstore = new Bookstore();


        CreationBook creationBook = new CreationBook(fileName, bookstore);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BOOKS ARE CREATED ");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------------------");

        List<Book> list = new ArrayList<Book>();
        Book book = new Book();
        book.setPublisher("AAAAAAAAA");
        book.setName("Denemeler");
        book.setIsbn("123i-3-3--4-");
        book.setAuthor("Anonim");
        list.add(book);
//        System.out.println("ILK KITAP EKLENDI  + "+list.get(list.size()-1).getName());

        Book book2 = new Book();
        book2.setPublisher("DenemePublisher");
        book2.setName("Guc Senin Elinde");
        book2.setIsbn("1-35-343--42-21");
        book2.setAuthor("AES");
        list.add(book2);


//        ReadingBook readingBook = new ReadingBook(fileName);
        UpdationBookXML updationBookXML = new UpdationBookXML(fileName, bookstore, list);


    /*    List<Book> bookList = new ArrayList<Book>();

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

        // create bookstore, assigning book
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Amazon Bookstore");
        bookstore.setLocation("Newyorkt");
        bookstore.setBookList(bookList);

        convertObjectToXML(bookstore);*/

    }


  /*  private static void convertObjectToXML(Bookstore bookstore) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(bookstore, System.out);

        // Write to File
        m.marshal(bookstore, new File(BOOKSTORE_XML));
    }*/
}