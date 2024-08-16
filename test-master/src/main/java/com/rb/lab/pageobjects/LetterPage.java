package com.rb.lab.pageobjects;

import com.rb.lab.control.elements.Button;
import com.rb.lab.control.elements.TextInput;
import com.rb.lab.driver.Driver;
import com.rb.lab.utils.WaitUtilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LetterPage extends PageObject {
    private Boolean ifSentMessage;

    @FindBy(xpath = "//textarea[@name='to']")
    private TextInput mailToInput;

    @FindBy(css = (".vh"))
    private Button labelSentMessage;

    @FindBy(css = ".aoT")
    private TextInput mailSubjectInput;

    @FindBy(css = "div[class='Am Al editable LW-avf']")
    private TextInput mailMessageInput;

    @FindBy(css = ".Ha")
    private Button closeButton;

    @FindBy(css = "td[class='gU Up']")
    private Button sendButton;


    public LetterPage enterEmailTo(String mailTo) {
        mailToInput.sendKeys(mailTo);
        return this;
    }

    public LetterPage enterEmailSubject(String mailSubject) {
        mailSubjectInput.sendKeys(mailSubject);
        return this;
    }

    public LetterPage enterMessage(String mailMessage) {
        mailMessageInput.sendKeys(mailMessage);
        return this;
    }

    public void closeLetter() {
        closeButton.click();
    }

    public void sendLetter() {
        sendButton.click();
    }

    public boolean checkSentMessage() {
        if ((new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60))).until(ExpectedConditions.elementToBeClickable(labelSentMessage)) != null) {
            ifSentMessage = true;
        }
        return ifSentMessage;
    }

}
