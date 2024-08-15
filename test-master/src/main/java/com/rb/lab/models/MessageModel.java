package com.rb.lab.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageModel {
    private String mailto;
    private String mailsubject;
    private String mailmessage;

    public String getMailTo() {
        return mailto;
    }

    public void setMailTo(String mailto) {
        this.mailto = mailto;
    }

    public String getMailSubject() {
        return mailsubject;
    }

    public void setMailSubject(String mailsubject) {
        this.mailsubject = mailsubject;
    }

    public String getMailMessage() {
        return mailmessage;
    }

    public void setMailMessage(String mailmessage) {
        this.mailmessage = mailmessage;
    }

}
