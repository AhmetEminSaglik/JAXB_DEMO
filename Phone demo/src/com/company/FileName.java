package com.company;

public class FileName {
    private Phone phone;
    private String name;
    private String fileName;

    public FileName(String name) {
        this.name = name;
        createFileName(name);
    }

    public FileName(Phone phone) {
        this.phone = phone;
        createFileName(phone.getNumber());
    }

    void createFileName(String firstName) {
        fileName = firstName + getFileExtension();
    }

    String getFileExtension() {
        return ".xml";
    }

    public String getFileName() {
        return fileName;
    }
}