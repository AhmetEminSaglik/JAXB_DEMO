package com.company.xml.record;

import javax.swing.plaf.ListUI;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(namespace = "Server")

/**
 * @XmlAccessorType I added this because otherwise I cannot use my local variables
--> for example:  my variable "callOperationsList"  should be  added  or removed the list 1 character*/

@XmlAccessorType(XmlAccessType.FIELD)

public class RecordServer implements IConvertXMLToObject<RecordMessage> {

    private static RecordServer recordServer;
    @XmlElementWrapper(name = "CallOperationList")
    @XmlElement(name = "call")
    private List<RecordCallOperation> callOperationsList;


    @XmlElementWrapper(name = "MessageList")
    @XmlElement(name = "message")
    private List<RecordMessage> messagesList;


    public List<RecordCallOperation> getCallOperationsList() {
        if (callOperationsList == null) {
            callOperationsList = new ArrayList<RecordCallOperation>();
        }
        return callOperationsList;
    }

    public void setCallOperationsList(List<RecordCallOperation> callOperationsList) {
        this.callOperationsList = callOperationsList;
    }

    public List<RecordMessage> getRecordMessagesList() {
        if (messagesList == null) {
            messagesList = new ArrayList<RecordMessage>();
        }
        return messagesList;
    }

    public void setRecordMessagesList(List<RecordMessage> recordMessagesList) {
        this.messagesList = recordMessagesList;
    }


    public RecordServer getRecordServerByUnmarshalFile(Unmarshaller unmarshaller, String fileName) {
        RecordServer recordServer = null;
        try {
            recordServer = (RecordServer) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return recordServer;
    }

    @Override
    public <T> T addAllObjectsByConvertingXMLToJavaObjectClass(Unmarshaller unmarshaller, String fileName) {
//        RecordServer recordServer = (RecordServer) wholeObject;
//        System.out.println("type.toString() :"+type.toString());
        T recordServer = (T) getRecordServerByUnmarshalFile(unmarshaller, fileName);

//        System.out.println(recordServer.toString());
//        System.out.println("T : ?????????????????????????????????? " + type.cast( wholeObject));

        setRecordServer((RecordServer) recordServer);
        return recordServer;

//        return type.cast( wholeObject);
    }

    public static RecordServer getRecordServer() {
        return recordServer;
    }

    public static void setRecordServer(RecordServer recordServer) {
        RecordServer.recordServer = recordServer;
    }

    public void unionRecordCallOperation(List<RecordCallOperation> firstList, List<RecordCallOperation> secondList) {
        List<RecordCallOperation> recordCallOperationsList = new ArrayList<RecordCallOperation>();
        recordCallOperationsList.addAll(firstList);
        recordCallOperationsList.addAll(secondList);
        setCallOperationsList(recordCallOperationsList);

    }
    public void unionMessageOperation(List<RecordMessage> firstList, List<RecordMessage> secondList) {
        List<RecordMessage> recordMessageList = new ArrayList<RecordMessage>();
        recordMessageList.addAll(firstList);
        recordMessageList.addAll(secondList);
        setRecordMessagesList(recordMessageList);

    }
}
