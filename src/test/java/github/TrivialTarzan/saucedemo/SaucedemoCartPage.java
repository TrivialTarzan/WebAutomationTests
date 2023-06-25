package github.TrivialTarzan.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SaucedemoCartPage {

    private final WebDriver driver;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "inventory_item_desc")
    private WebElement productDescription;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    @FindBy(className = "cart_button")
    private WebElement removeProductButton;

    @FindBy(className = "cart_button")
    private List<WebElement> removedProductElements;

    public SaucedemoCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public void removeProductFromCart() {
        removeProductButton.click();
    }

    public boolean isProductRemovedFromCart() {
        return removedProductElements.isEmpty();
    }
}
