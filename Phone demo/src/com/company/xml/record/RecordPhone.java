/*
package com.company.xml.record;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(namespace = "Phone")
@XmlAccessorType(XmlAccessType.FIELD)

public class RecordPhone {

    @XmlElementWrapper(name = "CallOperationList")
    @XmlElement(name = "call")
    private List<RecordCallOperation> callOperationsList;


    @XmlElementWrapper(name = "MessageList")
    @XmlElement(name = " message")
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
}
*/
