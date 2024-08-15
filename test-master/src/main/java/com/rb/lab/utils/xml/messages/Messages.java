package com.rb.lab.utils.xml.messages;

import com.rb.lab.models.MessageModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "messages")
@XmlAccessorType(XmlAccessType.FIELD)
public class Messages {
    @XmlElement(name = "message")
    private List<MessageModel> messages = null;

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }
}
