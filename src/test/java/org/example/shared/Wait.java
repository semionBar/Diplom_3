package org.example.shared;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Wait {

    @Step("Подождать пока элемент интерфейса появится")
    public static void waitForElementToBeVisible(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    @Step("Подождать пока элемент интерфейса появится")
    public static void waitForElementToBeClickable(WebDriver driver, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step
    public static void waitForModalToDisappear(WebDriver driver) {
        List<WebElement> webElements = driver.findElements(By.xpath(".//div[contains(@class, 'overlay')]"));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.invisibilityOfAllElements(webElements));
    }

}
