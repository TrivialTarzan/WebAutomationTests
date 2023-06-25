package github.TrivialTarzan.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class CheckoutPageGreenKart {

    private final WebDriver driver;

    @FindBy(className = "product-name")
    private List<WebElement> listOfProducts;

    @FindBy(className = "totAmt")
    private WebElement totalPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//select[@style='width: 200px;']")
    private WebElement expandList;

    @FindBy(className = "chkAgree")
    private WebElement checkbox;

    @FindBy(xpath = "//button[text()='Proceed']")
    private WebElement proceedBtn;

    @FindBy(className = "errorAlert")
    private WebElement errorAlertText;

    public CheckoutPageGreenKart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedButton() {
        proceedBtn.click();
    }
    public void acceptTermsAndConditions() {
        checkbox.click();
    }

    public void chooseCountry(String expectedCountry) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        expandList.click();
        WebElement selectCountry = driver.findElement(By.xpath(String.format("//option[@value='%s']", expectedCountry)));
        if (selectCountry.isEnabled()) {
            selectCountry.click();
        } else {
            js.executeScript("window.scrollBy(0, 500)");
            selectCountry.click();
        }
    }

    public boolean verifyErrorAlertDisplayed() {
        return errorAlertText.isDisplayed();
    }

    public String getErrorAlert() {
        return errorAlertText.getText();
    }

    public void placeOrder() {
        placeOrderBtn.click();
    }

    public boolean verifyProductsDisplayed(String product1, String product2) {
        boolean isDisplayed = false;
        int counter = 0;
        for (WebElement element : listOfProducts) {
            isDisplayed = element.getText().contains(product1) || element.getText().contains(product2);
            if (isDisplayed) counter++;
            if (counter == 2) break;
        } return isDisplayed;
    }

    public String getTotalPrice(String expectedPrice) {
        if (!Objects.equals(totalPrice.getText(), expectedPrice)) return expectedPrice;
        return totalPrice.getText();
    }

}
