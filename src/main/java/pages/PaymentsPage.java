package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for page Payments.
 * @author Alexandra Khekhneva
 */
public class PaymentsPage {
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for item Municipal Payments*/
    private By xpathMunicipalPayments = By.xpath("//a[@href=\"/payments/categories/kommunalnie-platezhi/\"]/span/span");

    /**
     * Constructor
     * @param driver - WebDriver
     */
    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the clicking on the item Municipal Payments
     * @return driver for page Municipal Payments
     */
    public MunicipalPaymentsPage clickMunicipalPayments() {
        WebElement municipalPayElement=driver.findElement(xpathMunicipalPayments);
        municipalPayElement.click();
        return new MunicipalPaymentsPage(driver);
    }

}
