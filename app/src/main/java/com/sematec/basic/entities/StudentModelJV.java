package com.sematec.basic.entities;

class StudentModelJV {

    private String stdName ;
    private String stdAddress ;

    public StudentModelJV(String stdName, String stdAddress) {
        this.stdName = stdName;
        this.stdAddress = stdAddress;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    @Override
    public String toString() {
        return "StudentModelJV{" +
                "stdName='" + stdName + '\'' +
                ", stdAddress='" + stdAddress + '\'' +
                '}';
    }
}
