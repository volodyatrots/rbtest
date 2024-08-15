package com.rb.lab.utils.xml.users;

import com.rb.lab.utils.property.ConfigProperty;
import com.rb.lab.models.UserModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class UserDataUnmarshaller {

    public List<UserModel> createObjectsUserData() {
        try {
            ConfigProperty configProperty = new ConfigProperty();
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller un = context.createUnmarshaller();
            Users users = (Users) un.unmarshal(new File(configProperty.getPathUserData()));
            return users.getUserModels();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
