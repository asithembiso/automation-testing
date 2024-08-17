package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/workspace/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/datepicker");

        // Selects date picker add a date and press enter
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("01/01/2025");
        datePicker.sendKeys(Keys.RETURN);

        driver.quit();
    }
}
