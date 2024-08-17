package org.example;

import org.example.pages.FormPage;
import org.example.pages.ConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertEquals;

public class FormTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/workspace/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirm = new ConfirmationPage();
        confirm.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirm.getAlertBannerText(driver));

        driver.quit();
    }
}
