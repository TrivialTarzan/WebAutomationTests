package github.TrivialTarzan.GreenKart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SuccessfulPurchaseSteps {

    private WebDriver driver;

    private WebDriverWait wait;

    private MainPageGreenKart mainPage;

    private ProductPageGreenKart productPage;

    private CartViewGreenKart cartView;

    private CheckoutPageGreenKart checkoutPage;

    private final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

    @Given("I'm on the main page")
    public void navigateToMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL);

    }

    @And("my cart is empty")
    public void verifyCartIsEmpty() {
        mainPage = new MainPageGreenKart(driver);
        assertTrue(mainPage.verifyCartQuantity());
    }

    @When("I click on my cart icon")
    public void clickOnMyCartIcon() {
        mainPage.clickOnCartIcon();
    }

    @Then("I see the message: {string}")
    public void verifyMessageIsDisplayed(String information) {
        cartView = new CartViewGreenKart(driver);
        assertEquals(cartView.getEmptyCartMessage(), information);
    }

    @And("the proceed to checkout button is disabled")
    public void verifyProceedToCheckoutButtonIsDisabled() {
        assertTrue(cartView.isProceedToCheckoutButtonDisabled());
    }

    @When("I search for {string}")
    public void searchForProduct(String product) {
        mainPage = new MainPageGreenKart(driver);
        mainPage.searchForProduct(product);
    }

    @Then("I'm on the product page")
    public void checkIfProductPageDisplayed() {
    }

    @And("I see product's name: {string} and price: {string}")
    public void verifyProductNameAndPrice(String expectedName, String expectedPrice) {
        productPage = new ProductPageGreenKart(driver);
        assertFalse(productPage.verifyProductNameDisplayed(expectedName), "WRONG PRODUCTS NAME");
        assertNotEquals(productPage.getProductPrice(), expectedPrice, "WRONG PRICE");
    }

    @And("I select the desired quantity: {string}")
    public void selectDesiredQuantity(String quantity) {
        assertEquals(quantity, productPage.changeAndReturnQuantity(quantity));
    }

    @Then("I add the product to my cart")
    public void addProductToCart() {
        productPage.addProductToCart();
        mainPage = new MainPageGreenKart(driver);
        assertFalse(mainPage.verifyCartQuantity());
    }

    @When("I return to the main page")
    public void returnToMainPage() {
        productPage = new ProductPageGreenKart(driver);
        productPage.clearSearchBar();
    }

    @And("I look for {string}")
    public void searchForAnotherProduct(String product) {
        mainPage = new MainPageGreenKart(driver);
        mainPage.searchForProduct(product);
    }

    @And("I see the product name: {string}")
    public void verifyProductName(String productName) {
        productPage = new ProductPageGreenKart(driver);
    }

    @Then("I choose the desired quantity: {string}")
    public void chooseQuantity(String quantity) {
        productPage.changeAndReturnQuantity(quantity);
        assertEquals(quantity, productPage.getQuantity(quantity));
    }

    @And("I add the product to the cart")
    public void addAnotherProductToCart() {
        productPage.addProductToCart();
    }

    @When("I click on my cart and proceed to checkout")
    public void clickOnCartAndProceedToCheckout() {
        mainPage = new MainPageGreenKart(driver);
        mainPage.clickOnCartIcon();
        cartView = new CartViewGreenKart(driver);
        cartView.proceedToCheckout();
    }

    @Then("I see the chosen products: {string} and {string} displayed on the screen")
    public void verifyChosenProductsDisplayed(String product1, String product2) {
        checkoutPage = new CheckoutPageGreenKart(driver);
        assertTrue(checkoutPage.verifyProductsDisplayed(product1, product2));
    }

    @And("the expected price of products: {string} matches the total price")
    public void verifyTotalPrice(String expectedPrice) {
        assertEquals(expectedPrice, checkoutPage.getTotalPrice(expectedPrice));
    }

    @When("I place order")
    public void placeOrder() {
        checkoutPage.placeOrder();
    }

    @And("I choose country for the delivery: {string}")
    public void chooseCountryForDelivery(String deliveryCountry) {
        checkoutPage.chooseCountry(deliveryCountry);
    }

    @When("I don't accept the T&M checkbox and click on Proceed button, I see the message: {string}")
    public void checkTermsAndConditionsCheckbox(String errorAlert) {
        checkoutPage.clickOnProceedButton();
        assertTrue(checkoutPage.verifyErrorAlertDisplayed());
        assertEquals(errorAlert, checkoutPage.getErrorAlert());
    }

    @Then("I accept T&M checkbox and click on Proceed button")
    public void clickOnProceedButton() {
        checkoutPage.acceptTermsAndConditions();
        checkoutPage.clickOnProceedButton();
    }

    @Then("I successfully placed my order and I am redirected to the main page")
    public void verifySuccessfullyPlacedOrder() {
    }

    @Then("I close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

}
