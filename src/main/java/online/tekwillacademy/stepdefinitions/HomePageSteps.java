package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("The Home page is displayed")
    public void theHomePageIsDisplayed() {
        driver.get("https://tekwillacademy-opencart.online/");
    }

    @And("Register Page is accessed from the Home Page button")
    public void registerPageIsAccessedFromTheHomePageButton() {
        homePage.navigateToRegisterPage();
    }
}
