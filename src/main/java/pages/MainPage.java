package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class for start page Tinkoff Bank.
 * @author Alexandra Khekhneva
 */
public class MainPage
{
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for menu item Payment */
    private By xpathMenuPay = By.xpath("//span[@data-reactid=\"100\"]");

    /**
     * Constructor
     * @param driver - WebDriver
     */
    public MainPage(FirefoxDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the clicking on the menu item "Payments"
     * @return driver for page Payments
     */
    public PaymentsPage clickMenuPayments() {
        WebElement payMenuElement=driver.findElement(xpathMenuPay);
        payMenuElement.click();
        return new PaymentsPage(driver);
    }

}