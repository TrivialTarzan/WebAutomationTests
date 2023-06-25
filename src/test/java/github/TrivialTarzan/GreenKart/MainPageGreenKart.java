package github.TrivialTarzan.GreenKart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageGreenKart {

    private final WebDriver driver;

    @FindBy(className = "cart-count")
    private WebElement cartQuantity;

    @FindBy(className = "cart-count")
    private List<WebElement> checkQuantityTagEnabled;

    @FindBy(className = "empty-cart")
    private List<WebElement> isCartEmpty;

    @FindBy(className = "cart-icon")
    private WebElement cartIcon;

    @FindBy(css = "input[type='search'].search-keyword")
    private WebElement searchBar;

    public MainPageGreenKart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCartQuantity() {
        return isCartEmpty.size() > 0;
    }

    public String getCartQuantity() {
        if (cartQuantity.isEnabled()) return cartQuantity.getText();
        return null;
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void searchForProduct(String product) {
        searchBar.clear();
        searchBar.sendKeys(product);
    }
}
