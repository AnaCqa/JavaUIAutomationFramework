package online.tekwillacademy.pageobjects;


import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(name = "agree")
    private WebElement privacyToggleBar;

    @FindBy(css = "button[type='submit']")
    private WebElement continueBtn;

    public void completeTheRegisterForm(String firstName, String lastName, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        System.out.println("The form was completed for: " + email + " and password: " + password);
    }

    public void enableOnTheToggleBar() {
        ScrollManager.scrollToElement(privacyToggleBar);
        privacyToggleBar.click();
    }

    public void clickOnTheContinueBtn() {
        ScrollManager.scrollToElement(continueBtn);
        continueBtn.click();
    }


}
