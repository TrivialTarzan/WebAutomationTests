package github.TrivialTarzan.saucedemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SaucedemoProceedToCheckoutSteps {

    private WebDriver driver;

    private final String URL = "https://www.saucedemo.com/";

    private String productName;

    private String productDescription;

    private SaucedemoProductsPage productsPage;

    private SaucedemoCartPage cartPage;

    private SaucedemoCheckoutPage checkoutPage;

    @Given("User is on main page")
    public void userIsOnMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
    }


    @When("User logs in using username: {string} and password: {string}")
    public void userLogsInUsingUsernameAndPassword(String userName, String password) {
        SaucedemoLogInPage logInPage = new SaucedemoLogInPage(driver);
        logInPage.fillInCredentialsAndSubmit(userName, password);
    }

    @When("User adds to cart any product")
    public void userSelectsAnyProduct() {
        productsPage = new SaucedemoProductsPage(driver);
        productName = productsPage.saveProductName();
        productDescription = productsPage.saveProductDescription();
        productsPage.addProductToCart();
    }

    @Then("User sees {string} product is added to the cart and goes to the cart view page")
    public void userSeesProductIsAddedToTheCart(String quantity) {
        Assertions.assertEquals(quantity, productsPage.checkIfAddedToCart());
        productsPage.goToCartViewPage();
    }


    @And("User clicks on the cart and sees his product in the cart view page")
    public void userClicksOnTheCartAndSeesHisProductsIn() {
        cartPage = new SaucedemoCartPage(driver);
        Assertions.assertEquals(productName, cartPage.getProductName());
        Assertions.assertEquals(productDescription, cartPage.getProductDescription());
    }

    @Then("User proceeds to checkout and verifies the info: {string} and presence of three fields: First Name, Last Name and Postal Code")
    public void userProceedsToCheckout(String pageHeader) {
        cartPage.proceedToCheckout();

        checkoutPage = new SaucedemoCheckoutPage(driver);
        Assertions.assertEquals(pageHeader, checkoutPage.checkPageHeader());
        Assertions.assertTrue(checkoutPage.checkIfDisplayedFirstNameField());
        Assertions.assertTrue(checkoutPage.checkIfDisplayedLastNameField());
        Assertions.assertTrue(checkoutPage.checkIfDisplayedPostalCodeField());
    }

    @And("User goes back to the cart view page and removes the product from the cart")
    public void userGoesBackToTheArtViewPage() {
        checkoutPage = new SaucedemoCheckoutPage(driver);
        checkoutPage.goBack();

        cartPage = new SaucedemoCartPage(driver);
        cartPage.removeProductFromCart();
        Assertions.assertTrue(cartPage.isProductRemovedFromCart());
    }

    @And("Closes the browser")
    public void userClosesTheBrowser() {
        driver.quit();
    }

}
