package github.TrivialTarzan.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoCheckoutPage {

    private final WebDriver driver;

    @FindBy(className = "title")
    private WebElement headerText;

    @FindBy(css = "input[data-test='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameField;

    @FindBy(name = "postalCode")
    private WebElement postalCodeField;

    @FindBy(name = "cancel")
    private WebElement backButton;

    public SaucedemoCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkPageHeader() {
        return headerText.getText();
    }

    public boolean checkIfDisplayedFirstNameField() {
        return firstNameField.isDisplayed();
    }

    public boolean checkIfDisplayedLastNameField() {
        return lastNameField.isDisplayed();
    }

    public boolean checkIfDisplayedPostalCodeField() {
        return postalCodeField.isDisplayed();
    }

    public void goBack() {
        backButton.click();
    }
}
