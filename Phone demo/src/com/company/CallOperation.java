package com.company;

import com.company.xml.record.RecordCallOperation;
import com.company.xml.record.RecordServer;

import java.util.ArrayList;
import java.util.List;

public class CallOperation {

    String phoneNumber;
    List<RecordCallOperation> recordCallOperationsList = new ArrayList<RecordCallOperation>();

    public CallOperation(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void call(String dialedNumber, boolean connected) {
        System.out.println(phoneNumber + " no " + dialedNumber + " adli numarayi ariyor");

        RecordCallOperation recordCallOperation = new RecordCallOperation();

        recordCallOperation.setPhoneCallNumber(phoneNumber);
        recordCallOperation.setPhoneDialedNumber(dialedNumber);
        recordCallOperation.setConnected(connected);

//        recordCallOperationsList.add(recordCallOperation);

        recordCallOperation(recordCallOperation);

    }

    void recordCallOperation(RecordCallOperation recordCallOperation) {
        RecordServer recordServer = new RecordServer();
        recordCallOperationsList.add(recordCallOperation);

        recordServer.setCallOperationsList(recordCallOperationsList);

//        System.out.println(recordServer.getCallOperationsList().get(0).getPhoneCallNumber());
        System.out.println(recordServer.getCallOperationsList().size());
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


}
