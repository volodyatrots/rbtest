package com.rb.lab.utils.xml.messages;

import com.rb.lab.models.MessageModel;
import com.rb.lab.utils.property.ConfigProperty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class MessageUnmarshaller {

    public List<MessageModel> createObjectsMessage() {
        try {
            ConfigProperty configProperty = new ConfigProperty();
            JAXBContext context = JAXBContext.newInstance(Messages.class);
            Unmarshaller un = context.createUnmarshaller();
            Messages messages = (Messages) un.unmarshal(new File(configProperty.getPathMessage()));
            return messages.getMessages();
        } catch (JAXBException e) {
            e.printStackTrace();
        }return null;
    }
}
