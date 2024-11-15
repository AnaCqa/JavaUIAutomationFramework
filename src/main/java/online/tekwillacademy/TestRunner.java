package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager.getInstance().getDriver().get("https://www.google.com/");
        //DriverManager.getInstance().getDriver().quit();

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open new window and navigate to the DIEZ page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md/");
        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.stiri.md/");
        Thread.sleep(2000);
        driver.quit();


    }
}