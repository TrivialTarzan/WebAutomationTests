package github.TrivialTarzan.olx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OlxMyAccountPage {
    private final WebDriver driver;

    // the element I want to hover over
    @FindBy(xpath = "//div[@data-testid='qa-user-dropdown']")
    private WebElement hoverOverElement;

    @FindBy(css = "a[href='/myaccount/profile']")
    private WebElement profileLink;

    @FindBy(xpath = "//button[@data-cy='profile-basic-info-edit-button']")
    private WebElement editProfileBtn;

    public OlxMyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToUserProfilePage() {
        // Hover over the element
        Actions action = new Actions(this.driver);
        action.moveToElement(hoverOverElement).perform();

        // Explicit wait for the profile link to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement profileLinkClickable = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/myaccount/profile']")));
        profileLinkClickable.click();
    }

    public void goToEditProfileInfoPage() {
        editProfileBtn.click();
    }
}
