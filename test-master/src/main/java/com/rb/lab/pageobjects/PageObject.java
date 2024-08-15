package com.rb.lab.pageobjects;


import com.rb.lab.control.CustomFieldDecorator;
import com.rb.lab.driver.Driver;

import org.openqa.selenium.support.PageFactory;

class PageObject {

    PageObject() {
        PageFactory.initElements(new CustomFieldDecorator(Driver.getDriver()), this);
    }
}
