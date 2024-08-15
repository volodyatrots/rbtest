package com.rb.lab.utils;

import com.rb.lab.models.MessageModel;
import com.rb.lab.models.UserModel;
import com.rb.lab.utils.csv.CSVReader;
import com.rb.lab.utils.xlsx.XLSXReader;
import com.rb.lab.utils.xml.messages.MessageUnmarshaller;
import com.rb.lab.utils.xml.users.UserDataUnmarshaller;

import java.util.List;

public class DataReader {
    public Object[][] getXMLData() {
        List<UserModel> userModels = new UserDataUnmarshaller().createObjectsUserData();
        List<MessageModel> messages = new MessageUnmarshaller().createObjectsMessage();
        Object[][] gmailData = new Object[userModels.size()][2];
        for (int i = 0, j = 0; i < userModels.size(); i++, j++) {
            gmailData[i][0] = userModels.get(i);
            gmailData[j][1] = messages.get(j);
        }
        return gmailData;
    }

    public Object[][] getXLSAndCSVData() {
        List<UserModel> userModels = new XLSXReader().getUsers();
        List<MessageModel> messages = new CSVReader().getMessages();
        Object[][] gmailData = new Object[userModels.size()][2];
        for (int i = 0, j = 0; i < userModels.size(); i++, j++) {
            gmailData[i][0] = userModels.get(i);
            gmailData[j][1] = messages.get(j);
        }
        return gmailData;
    }
}
