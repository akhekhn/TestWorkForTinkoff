package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for page Provider ZHKU Moscow.
 * @author Alexandra Khekhneva
 */
public class ProviderZhKUMoscowPage {
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for tab Payment*/
    private By xpathPaymentTab = By.xpath("//a[@href=\"/zhku-moskva/oplata/\"]");

    /**
     * Constructor
     * @param driver - WebDriver
     */
    public ProviderZhKUMoscowPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the clicking on the tab Payment
     * @return driver for page Payment of ZHKU Moscow
     */
    public PayZHKUPage clickPayZHKUTab() {
        WebElement payTebElement=driver.findElement(xpathPaymentTab);
        payTebElement.click();
        return new PayZHKUPage(driver);
    }
}
