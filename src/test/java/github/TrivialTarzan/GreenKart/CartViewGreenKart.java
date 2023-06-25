package github.TrivialTarzan.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartViewGreenKart {

    private final WebDriver driver;

    @FindBy(className = "disabled")
    private WebElement disabledCheckoutBtn;

    @FindBy(xpath = "//button[@type='button' and @class=' ' and text()='PROCEED TO CHECKOUT']")
    private WebElement enabledCheckoutBtn;

    @FindBy(className = "empty-cart")
    private WebElement emptyCart;

    public CartViewGreenKart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProceedToCheckoutButtonDisabled() {
        return disabledCheckoutBtn.isEnabled();
    }

    public String getEmptyCartMessage() {
        if (emptyCart.isEnabled()) return emptyCart.findElement(By.tagName("h2")).getText();
        return null;
    }

    public void proceedToCheckout() {
        enabledCheckoutBtn.click();
    }
}
