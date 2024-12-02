package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);


    @And("the register form is populated with data")
    public void theRegisterFormIsPopulatedWithData() {
        //Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
    }

    @And("the privacy toggle bar is enabled")
    public void thePrivacyToggleBarIsEnabled() {
        registerPage.enableOnTheToggleBar();
    }

    @When("the continueButton is clicked")
    public void theContinueButtonIsClicked() {
        registerPage.clickOnTheContinueBtn();
    }
}
