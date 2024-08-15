package com.rb.lab.driver;

import com.rb.lab.utils.property.ConfigProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static java.lang.Integer.parseInt;

public class Driver {

    private ConfigProperty configProperty = new ConfigProperty();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browserName = System.getProperty("browserName");
            if(browserName != null && browserName.equalsIgnoreCase("firefox")){
                driver.set(new FirefoxDriver());
                System.out.println("FireFox browser set");
            }else {
                driver.set(new ChromeDriver());
                System.out.println("Chrome browser set");
            }
        }

        return driver.get();
    }

    private Driver() {
    }

    public static void close() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.set(null);
        }
    }

}
