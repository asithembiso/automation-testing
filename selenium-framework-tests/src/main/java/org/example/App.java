package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class App 
{
    public static void main( String[] args ) {

        System.setProperty("webdriver.chrome.driver", "/workspace/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement name = driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("John Doe");

        WebElement button = driver.findElement(By.id("button"));
        button.click();

        driver.quit();
    }
}
