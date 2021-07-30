package com.company.xml.operation;

import com.company.xml.record.RecordServer;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MyJAXBUtility {


    static JAXBContext getJAXBContent(Class clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        return context;
    }

    static Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        return getJAXBContent(clazz).createUnmarshaller();
//        Unmarshaller unmarshaller = getJAXBContent(clazz).createUnmarshaller();
//        return unmarshaller;
    }

    static Marshaller getMarshaller(Class clazz) throws JAXBException {
        Marshaller marshaller = getJAXBContent(clazz).createMarshaller();
        setMarshallerProperty(marshaller);
        return marshaller;
    }

    static void setMarshallerProperty(Marshaller marshaller) throws PropertyException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }
//    static void writeSystemOut(Marshaller marshaller){
//        marshaller.marshal(bookstore, System.out);
//    }

    static void writeToXMLFile(Marshaller marshaller, Object object, String fileName) throws JAXBException {
        marshaller.marshal(object, new File(fileName));
//        marshaller.marshal(object,System.out);
        System.out.println(MyJAXBUtility.class.getSimpleName() + " Burada  Object yerine class ismi yazmamiz gerekiyor ==> Aslinda ");
    }

    /**
     * @param clazz    <ns2:\\clazz is name of class which will be wrote here \\ xmlns:ns2="com.company.book">
     * @param object   is a class which variables will be wrote  as xmlElement
     * @param fileName
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static void writeObjectToXMLFile(Class clazz, Object object, String fileName) throws JAXBException, FileNotFoundException { //writeObjectInXMLFormatInXMLFile
        Marshaller marshaller = getMarshaller(clazz);
        writeToXMLFile(marshaller, object, fileName);


    }


    /*  public static void convertObjectToXML() throws JAXBException, FileNotFoundException {
          // create JAXB context and instantiate marshaller
  //        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
  //        Marshaller m = context.createMarshaller();
  //        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
  //
  //        // Write to System.out
  //        m.marshal(bookstore, System.out);
  //
  //        // Write to File
  //        m.marshal(bookstore, new File(fileName));
  //        System.out.println("------->>> kitaplar eklenmis olmali");
      }

  */

    /**
     * Unmarshaler must convert by which class want to be reached in xml file
     */
    public static void readXMLFileAndConvertToObject(Class clazz, String fileName) throws JAXBException {
        Unmarshaller unmarshaller = getUnmarshaller(clazz);
        RecordServer recordServer = (RecordServer) unmarshaller.unmarshal(new File(fileName));

        /*Object recordServer1 = unmarshaller.unmarshal(new File(fileName));
        RecordServer recordServer2=(RecordServer)recordServer1;*/
//        List<RecordCallOperation> list = recordServer.getCallOperationsList();
        recordServer.addAllObjectsByConvertingXMLToJavaObjectClass(unmarshaller, fileName);


//        System.out.println("BURAYA GELDIIII ");
      /*  for (RecordCallOperation temp : recordServer.getCallOperationsList()) {
            System.out.println("OKUNAN DEGER :  arayan no : " + temp.getPhoneCallNumber() + " list size : ");
        }
        for (RecordMessage temp : recordServer.getRecordMessagesList()) {
            System.out.println("OKUNAN DEGER :  arayan no : " + temp.getMessage() + " list size : ");
        }*/

    }
  /*  public static void convertXMLToObject(String fileName) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
//            Unmarshaller un = context.createUnmarshaller();
//            Bookstore bookstore = (Bookstore) un.unmarshal(new File(fileName));
//
//            System.out.println(bookstore.toString());
//            list = bookstore.getBooksList();
//            for (Book book : list) {
//                System.out.println("Book: " + book.getName() + " from " + book.getAuthor());
//            }
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
    }*/
}
