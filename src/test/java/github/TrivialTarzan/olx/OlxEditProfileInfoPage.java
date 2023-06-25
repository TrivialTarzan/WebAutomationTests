package github.TrivialTarzan.olx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OlxEditProfileInfoPage {
    private final WebDriver driver;

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(name = "city_id")
    private WebElement locationInput;


    @FindBy(css = "//li[data-testid='location-list-item']")
    private WebElement selectCityNameFromList;

    @FindBy(name = "userPhoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitChangesBtn;

    public OlxEditProfileInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUserName() {
        String text = userNameInput.getAttribute("value");
        if (text == null) {
            text = userNameInput.getAttribute("defaultValue");
        }
        return text;
    }

    public String getCurrentLocation() {
        return locationInput.getText();
    }

    public String getCurrentPhoneNumber() {
        return phoneNumberInput.getText();
    }

    public void setNewUserName() {
        userNameInput.clear();
        userNameInput.sendKeys("nothingness");
    }

    public void setNewLocation() {
        locationInput.clear();
        locationInput.sendKeys("Bytom");
        selectCityNameFromList.click();
    }

    public void setNewPhoneNumber() {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys("666 222 666");
    }

    public void submitChanges() {
        submitChangesBtn.click();
    }
}
