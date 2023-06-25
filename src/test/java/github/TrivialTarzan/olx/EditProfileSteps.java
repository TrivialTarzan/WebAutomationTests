package github.TrivialTarzan.olx;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class EditProfileSteps {
    private  WebDriver driver;

    OlxEditProfileInfoPage editProfileInfoPage;

    OlxLogin loginPage;

    OlxMyAccountPage accountPage;

    private final String OLX_URL = "https://www.olx.pl/";

    @Given("User is on the main page")
    public void userIsOnMainPage(){
        ChromeOptions options = new ChromeOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.93 Safari/537.36";
        options.addArguments("--user-agent=" + userAgent);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OLX_URL);
    }

    @When("User logs in using email: {string} and password: {string}")
    public void userLogsInUsingEmailAndPassword(String email, String passwd) {
        loginPage = new OlxLogin(driver);
        loginPage.acceptOnetrustPolicy();
        loginPage.login(email, passwd);
    }


    @When("User goes to the profile information edit page")
    public void userGoesToProfileInfoEditPage() {
        accountPage = new OlxMyAccountPage(driver);
        accountPage.goToUserProfilePage();
        accountPage.goToEditProfileInfoPage();
    }

    @Then("User sees the name set to {string}")
    public void userSeesNameSetTo(String name) {
        editProfileInfoPage = new OlxEditProfileInfoPage(driver);
        Assertions.assertEquals(name, editProfileInfoPage.getCurrentUserName());
    }

    @And("User sees the location set to {string}")
    public void userSeesLocationSetTo(String location) {
        Assertions.assertEquals(location, editProfileInfoPage.getCurrentLocation());
    }

    @And("User sees the phone number set to {string}")
    public void userSeesPhoneNumberSetTo(String phoneNumber) {
        Assertions.assertEquals(phoneNumber ,editProfileInfoPage.getCurrentPhoneNumber());
    }

    @Then("User enters the new name: {string}")
    public void userEntersNewName(String newName) {
        editProfileInfoPage.setNewUserName();
        Assertions.assertEquals(newName, editProfileInfoPage.getCurrentUserName());
    }

    @And("User enters the new location: {string}")
    public void userEntersNewLocation(String newLocation) {
        editProfileInfoPage.setNewLocation();
        Assertions.assertEquals(newLocation, editProfileInfoPage.getCurrentLocation());
    }

    @And("User enters the new phone number: {string}")
    public void userEntersNewPhoneNumber(String newPhoneNumber) {
        editProfileInfoPage.setNewPhoneNumber();
        Assertions.assertEquals(newPhoneNumber, editProfileInfoPage.getCurrentPhoneNumber());
    }

    @Then("User accepts the changes")
    public void userAcceptsTheChanges() {
        editProfileInfoPage.submitChanges();
    }

    @And("User verifies the added changes name: {string}, location: {string}, phone number: {string}")
    public void userVerifiesAddedChanges(String userName, String location, String phoneNumber) {
        accountPage = new OlxMyAccountPage(driver);
        accountPage.goToEditProfileInfoPage();

        editProfileInfoPage = new OlxEditProfileInfoPage(driver);
        Assertions.assertEquals(userName, editProfileInfoPage.getCurrentUserName());
        Assertions.assertEquals(location, editProfileInfoPage.getCurrentLocation());
        Assertions.assertEquals(phoneNumber, editProfileInfoPage.getCurrentPhoneNumber());
    }

    @And("User closes the browser")
    public void userClosesBrowser() {
        driver.quit();
    }

}
