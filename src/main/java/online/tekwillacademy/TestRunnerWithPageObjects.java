package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import online.tekwillacademy.pageobjects.AccountPage;
import online.tekwillacademy.pageobjects.HomePage;
import online.tekwillacademy.pageobjects.LoginPage;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPage();

        //Generate random data
        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableOnTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(2000);

        //Account related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOutFromTheAccount();

        homePage.navigateToLoginPage();
        Thread.sleep(2000);

        //Login page relatedactions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginBtn();
        Thread.sleep(5000);

        driver.quit();

    }
}
