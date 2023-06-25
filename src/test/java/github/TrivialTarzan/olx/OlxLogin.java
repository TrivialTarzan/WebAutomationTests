package github.TrivialTarzan.olx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OlxLogin {
    private final WebDriver driver;

//    @FindBy(xpath = "//button[id='onetrust-accept-btn-handler']")
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement onetrustPolicyBtn;

    @FindBy(className = "inlblk")
    private WebElement myAccountBtn;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwdInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public OlxLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptOnetrustPolicy() {
        if (onetrustPolicyBtn.isDisplayed()) onetrustPolicyBtn.click();
    }

    public void login(String email, String passwd) {
        myAccountBtn.click();

        emailInput.clear();
        emailInput.sendKeys(email);

        passwdInput.clear();
        passwdInput.sendKeys(passwd);

        loginBtn.click();
    }
}
