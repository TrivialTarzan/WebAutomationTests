package github.TrivialTarzan.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucedemoProductsPage {

    private final WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartQuantity;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "inventory_item_desc")
    private WebElement productDescription;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartViewPageLink;

    public SaucedemoProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public String saveProductName() {
        return productName.getText();
    }

    public String saveProductDescription() {
        return productDescription.getText();
    }

    public String checkIfAddedToCart() {
        return shoppingCartQuantity.getText();
    }

    public void goToCartViewPage() {
        cartViewPageLink.click();
    }
}
