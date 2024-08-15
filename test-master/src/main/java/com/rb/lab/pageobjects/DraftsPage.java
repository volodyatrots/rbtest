package com.rb.lab.pageobjects;


import com.rb.lab.control.elements.Button;
import com.rb.lab.control.elements.TextInput;
import com.rb.lab.driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftsPage extends PageObject {

    @FindBy(xpath = "//div[@class='aim'][3]")
    private Button draftsButton;

    @FindBy(xpath = "//input[@name='q']")
    private TextInput searchInput;

    @FindBy(xpath = "//span[contains(text(),'Hi!')]")
    private Button myLetter;


    public void openDrafts() {
        draftsButton.click();
    }


    public boolean checkLoadDrafts() {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(60)).until(ExpectedConditions.textToBePresentInElementValue(searchInput, "in:draft "));
    }

    public void openMyLetter() {
        myLetter.click();
    }
}
