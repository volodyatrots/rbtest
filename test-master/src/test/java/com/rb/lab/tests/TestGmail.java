package com.rb.lab.tests;

import com.rb.lab.businessobjects.GmailLoginBO;
import com.rb.lab.businessobjects.MessagesBO;
import com.rb.lab.models.MessageModel;
import com.rb.lab.models.UserModel;
import com.rb.lab.utils.provider.TestProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestGmail extends BaseTest {

    @Test(dataProvider = "getUsersData", dataProviderClass = TestProvider.class)
    public void sendFromDrafts(UserModel userModel, MessageModel message) {

        GmailLoginBO gmailLoginBO = new GmailLoginBO();

        gmailLoginBO.openLoginPage();

        gmailLoginBO.loginAS(userModel);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        MessagesBO messagesBO = new MessagesBO();

        messagesBO.writeLetter(message);

        messagesBO.openDrafts();

        assertTrue(messagesBO.checkLoadDrafts());

        messagesBO.openMyLetter();

        messagesBO.sendLetter();

        assertTrue(messagesBO.checkSentMessage());
    }


}