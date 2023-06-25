package github.TrivialTarzan.GreenKart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPageGreenKart {

    private final WebDriver driver;

    @FindBy(className = "product-name")
    private List<WebElement> productsNames;

    @FindBy(className = "product-name")
    private WebElement product;

    @FindBy(className = "product-price")
    private WebElement productPrice;

    @FindBy(className = "quantity")
    private WebElement productQuantity;

    @FindBy(css = "input[type='number'].quantity")
    private WebElement productQuantityWindow;

    @FindBy(xpath = "//button[@type='button' and @class='' and text()='ADD TO CART']")
    private WebElement addToCartBtn;

    @FindBy(className = "search-keyword")
    private WebElement searchBar;

    @FindBy(linkText = "+")
    private WebElement incrementBtn;

    public ProductPageGreenKart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkProductName(String expectedName) {
        for (WebElement product : productsNames) {
            if (product.getText().contains(expectedName)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyProductNameDisplayed(String productName) {
        return product.getText().contains(productName.toLowerCase());
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getQuantity(String quantity) {
        if (productQuantity.getAttribute("value") != null) {
            if (productQuantity.getAttribute("value").contains(quantity)) {
                return productQuantity.getAttribute("value");
            }
        } return quantity;
    }

    public String changeAndReturnQuantity(String quantity) {
        try {
            for (int i = 0; i <= Integer.parseInt(quantity); i++) {
                incrementBtn.click();
            }
        } catch(org.openqa.selenium.StaleElementReferenceException ex) {
            for (int i = 2; i <= Integer.parseInt(quantity); i++) {
                incrementBtn.click();
            }
        }
        return productQuantity.getAttribute("value");
    }

    public void changeProductQuantityInTheWindow(String quantity) {
        productQuantityWindow.click();
        productQuantityWindow.clear();
        productQuantityWindow.sendKeys(quantity);
    }

    public void addProductToCart() {
        addToCartBtn.click();
    }

    public void clearSearchBar() {
        searchBar.clear();
    }
}
