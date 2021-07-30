package com.company;

import com.company.xml.record.RecordCallOperation;
import com.company.xml.record.RecordMessage;
import com.company.xml.record.RecordServer;

import java.util.ArrayList;
import java.util.List;

public class MessageOperation {
    String message;
    String phoneNumbergetMessage;
    String phoneNumberSendMessage;

    List<RecordMessage> recordMessageList = new ArrayList<RecordMessage>();

    public void sendMessage(String phoneNumber, String message) {
        this.phoneNumbergetMessage = phoneNumber;
        this.message = message;
        System.out.println(phoneNumber + "'e mesaj  gonderildi :" + message);

        RecordMessage recordMessage = new RecordMessage();

        recordMessage.setMessage(message);
        recordMessage.setPhoneRecivedText(phoneNumbergetMessage);
        recordMessage.setPhoneTexted(phoneNumberSendMessage);

        recordMessage(recordMessage);

    }


    void recordMessage(RecordMessage recordMessage) {
        RecordServer recordServer = new RecordServer();
        recordMessageList.add(recordMessage);

        recordServer.setRecordMessagesList(recordMessageList);

//        System.out.println(recordServer.getCallOperationsList().get(0).getPhoneCallNumber());
        System.out.println(recordServer.getRecordMessagesList().size());
        XMLFileOperation.appendFile(recordServer.getClass(), recordServer, getFileName());


//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    String getFileName() {
        return new FileName("server").getFileName();
    }

    public String getPhoneNumberSendMessage() {
        return phoneNumberSendMessage;
    }

    public void setPhoneNumberSendMessage(String phoneNumberSendMessage) {
        this.phoneNumberSendMessage = phoneNumberSendMessage;
    }
}

