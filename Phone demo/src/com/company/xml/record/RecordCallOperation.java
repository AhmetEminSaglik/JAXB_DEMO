package com.company.xml.record;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CallOperation")
@XmlType(propOrder = {
        "phoneCallNumber",
        "phoneDialedNumber",
        "connected"
})
public class RecordCallOperation {

    private String phoneCallNumber;
    private String phoneDialedNumber;
    private boolean connected;

    @XmlElement(name = "PhoneCall")
    public String getPhoneCallNumber() {
        return phoneCallNumber;
    }

    public void setPhoneCallNumber(String phoneCallNumber) {
        this.phoneCallNumber = phoneCallNumber;
    }
    @XmlElement(name = "PhoneDialed")
    public String getPhoneDialedNumber() {
        return phoneDialedNumber;
    }

    public void setPhoneDialedNumber(String phoneDialedNumber) {
        this.phoneDialedNumber = phoneDialedNumber;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
