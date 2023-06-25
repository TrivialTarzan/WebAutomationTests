package github.TrivialTarzan.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoLogInPage {

    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn_action")
    private WebElement submitButton;

    public SaucedemoLogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInCredentialsAndSubmit(String userName, String password) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.click();
    }
}
