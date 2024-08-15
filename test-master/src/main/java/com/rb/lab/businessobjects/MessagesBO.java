package com.rb.lab.businessobjects;


import com.rb.lab.models.MessageModel;
import com.rb.lab.pageobjects.DraftsPage;
import com.rb.lab.pageobjects.GmailInboxPage;
import com.rb.lab.pageobjects.LetterPage;
import org.apache.log4j.Logger;

public class MessagesBO {
    private static final Logger LOG = Logger.getLogger(GmailLoginBO.class);
    private DraftsPage draftsPage;
    private GmailInboxPage gmailInboxPage;
    private LetterPage letterPage;


    public MessagesBO() {
        draftsPage = new DraftsPage();
        gmailInboxPage = new GmailInboxPage();
        letterPage = new LetterPage();
    }

    public void writeLetter(MessageModel message) {
        LOG.info("Writing Letter");
        gmailInboxPage.composeLetter();
        letterPage.enterEmailTo(message.getMailTo());
        letterPage.enterEmailSubject(message.getMailSubject());
        letterPage.enterMessage(message.getMailMessage());
        letterPage.closeLetter();
    }

    public void openDrafts() {
        LOG.info("Opening Drafts");
        draftsPage.openDrafts();
    }

    public boolean checkLoadDrafts() {
        return draftsPage.checkLoadDrafts();
    }

    public void openMyLetter() {
        LOG.info("Opening Saved Letter");
        draftsPage.openMyLetter();
    }

    public void sendLetter() {
        LOG.info("Sending Letter");
        letterPage.sendLetter();
    }

    public boolean checkSentMessage() {
        LOG.info("Check IF Sent Letter");
        return letterPage.checkSentMessage();
    }
}
