package com.company.main;

import com.company.book.Book;
import com.company.bookstore.Bookstore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UpdationBookXML {
    private String fileName;
    private Bookstore bookstore;
    List<Book> list;

    public UpdationBookXML(String fileName, Bookstore bookstore, List<Book> list) throws JAXBException, IOException {
        this.fileName = fileName;
        this.bookstore = bookstore;
        ReadingBook readingBook = new ReadingBook(fileName, bookstore);
        this.list = readingBook.getList();
        System.out.println("GELEN LISTE :::::: ");
        for (Book temp : list) {
            System.out.println(temp.getName());
            bookstore.addBook(temp);
        }


     convertObjectToXML(bookstore);
    }

    private void convertObjectToXML(Bookstore bookstore) throws JAXBException, FileNotFoundException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
//        m.marshal(bookstore, System.out);
        System.out.println("GUNCELLEME YAPILDI");

        // Write to File
        m.marshal(bookstore, new File(fileName));
    }
}
