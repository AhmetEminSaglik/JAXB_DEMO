package com.company;

import com.company.xml.operation.MyJAXBUtility;
import com.company.xml.record.RecordCallOperation;
import com.company.xml.record.RecordServer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class XMLFileOperation {
    static void createAndWriteFile(Class clazz, Object object, String fileName) {
        try {
            MyJAXBUtility.writeObjectToXMLFile(clazz, object, fileName);
        } catch (JAXBException e) {
            printError(e);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            printError(e);
        }
//        catch (NoClassDefFoundError e){
//            System.out.println(" HATA : "+e.getMessage());
//        }
    }

    static void readFile(Class clazz, String fileName) {
        try {
            MyJAXBUtility.readXMLFileAndConvertToObject(clazz, fileName);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static void updateFile(Class clazz, Object object, String fileName) {
        readFile(clazz, fileName);

        System.out.println("GELEN OBJECT : " + object.toString());
        ((RecordServer) object).getCallOperationsList();
        RecordServer recordServer = new RecordServer();
//        System.out.println(" ((RecordServer) object).getCallOperationsList()  size " +((RecordServer) object).getCallOperationsList().get(0).getPhoneCallNumber());
//        System.out.println(" RecordServer.getRecordServer().getCallOperationsList() size : "+RecordServer.getRecordServer().getCallOperationsList().get(0).getPhoneCallNumber());
        RecordServer.getRecordServer().unionRecordCallOperation(((RecordServer) object).getCallOperationsList(),
                RecordServer.getRecordServer().getCallOperationsList());
        RecordServer.getRecordServer().unionMessageOperation(((RecordServer) object).getRecordMessagesList(),
                RecordServer.getRecordServer().getRecordMessagesList());
//        System.out.println(" RecordServer.getRecordServer().getCallOperationsList() size AFTER : "+RecordServer.getRecordServer().getCallOperationsList().get(0).getPhoneCallNumber());


        int i=1;
        for (RecordCallOperation temp : RecordServer.getRecordServer().getCallOperationsList()) {
            System.out.println(i+"-) TOPLAM DEGER temp : " + temp);
            i++;
        }

        createAndWriteFile(clazz, RecordServer.getRecordServer(), fileName);
//        (RecordServer) object).

    }

    public static void appendFile(Class clazz, Object object, String fileName) {
        try {
//            createAndWriteFile(clazz, object, fileName);
            updateFile(clazz, object, fileName);
            System.out.println("DOSYA BULUNDUUUU");
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR : " + ex.getMessage());
            System.out.println("DOSYA OLUSTURULDU");
            createAndWriteFile(clazz, object, fileName);
        }
    }

    static void printError(Exception e) {
        System.out.println(e.getMessage());

    }
}
