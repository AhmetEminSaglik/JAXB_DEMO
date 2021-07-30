package com.company.xml.record;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Message")
@XmlType(propOrder = {
        "phoneTexted",
        "phoneRecivedText",
        "message"
})
public class RecordMessage {
    private String phoneTexted;
    private String phoneRecivedText;
    private String message;

    public String getPhoneTexted() {
        return phoneTexted;
    }

    public void setPhoneTexted(String phoneTexted) {
        this.phoneTexted = phoneTexted;
    }

    public String getPhoneRecivedText() {
        return phoneRecivedText;
    }

    public void setPhoneRecivedText(String phoneRecivedText) {
        this.phoneRecivedText = phoneRecivedText;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
