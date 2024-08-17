package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class AutoCompleteTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/workspace/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("13 long street cape town");
        // Implicit Waits
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Explicit Waits
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // TODO: pac-item does not come up, google maps doesn't load correctly
        //WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        //autocompleteResult.click();

        driver.quit();
    }
}
