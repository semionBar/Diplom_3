package org.example.shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                return new ChromeDriver();
            case "Firefox":
                return new FirefoxDriver();
        }
        return null;
    }
}
