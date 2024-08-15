package com.rb.lab.utils.csv;

import com.rb.lab.models.MessageModel;
import com.rb.lab.utils.property.ConfigProperty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSVReader {
    private static Function<String, MessageModel> mapToItem = (line) -> {
        MessageModel messageModel = new MessageModel();
        String[] row = line.split(",");
        messageModel.setMailTo(row[0]);
        messageModel.setMailSubject(row[1]);
        messageModel.setMailMessage(row[2]);
        return messageModel;
    };

    public List<MessageModel> getMessages() {
        List<MessageModel> messages = new ArrayList<>();
        try {
            ConfigProperty configProperty = new ConfigProperty();
            File csv = new File(configProperty.getPathCSVMessages());
            InputStream fileInputStream = new FileInputStream(csv);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            messages = bufferedReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            bufferedReader.close();
            fileInputStream.close();
            return messages;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

