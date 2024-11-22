package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager.getInstance().getDriver().get("https://www.google.com/");
        //DriverManager.getInstance().getDriver().quit();

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        String theNameOfTheFirstTab = driver.getWindowHandle();

        // Open new window and navigate opencard
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebElement myAccountDropDown = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountDropDown.click();

        WebElement registerLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerLink.click();

        //Print the url of the new page
        System.out.println("The driver is on page:" + driver.getCurrentUrl());


        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(RandomDataManager.getRandomFirstName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(RandomDataManager.getRandomLastName());

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = RandomDataManager.getRandomEmail();
        System.out.println("Email: " + emailData);
        emailInput.sendKeys(emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        String passwordData = RandomDataManager.getRandomPassword(3, 21, true, true);
        System.out.println("Password: " + passwordData);
        passwordInput.sendKeys(passwordData);

        WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        //scroll until the element is in view
        ScrollManager.scrollToElement(privacyToggleBar);

        privacyToggleBar.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());


        // Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        System.out.println("The driver is on page:" + driver.getCurrentUrl());
        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The driver is on page:" + driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        myAccountDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa-solid fa-user']")));
        myAccountDropDown.click();

        WebElement loginLink = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
        loginLink.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());


        emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
        emailInput.sendKeys(emailData);


        passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
        passwordInput.sendKeys(passwordData);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("The driver is on page:" + driver.getCurrentUrl());


        //Thread.sleep(5000);

        driver.quit();


    }
}