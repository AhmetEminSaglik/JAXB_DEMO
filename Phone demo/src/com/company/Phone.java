package com.company;

public class Phone {
    String number;
    String message;
    private CallOperation callOperation;
    private MessageOperation messageOperation;

    public Phone(String number) {
        this.number = number;
        createMessage();

    }

    void createMessage() {
        message = "Merhaba  ben : " + number;

    }

    public void sendMessage(String phoneNumber) {
        messageOperation = new MessageOperation();
        messageOperation.setPhoneNumberSendMessage(number);
        messageOperation.sendMessage(phoneNumber, message);


    }

    public void callPhone(String dialedNumber, boolean connected) {
        callOperation = new CallOperation(number);
        callOperation.call(dialedNumber, connected);
    }

    public String getNumber() {
        return number;
    }

}
