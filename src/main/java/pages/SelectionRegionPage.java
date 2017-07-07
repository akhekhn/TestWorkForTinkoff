package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for region selection page.
 * @author Alexandra Khekhneva
 */
public class SelectionRegionPage {
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for text field Region*/
    private By xpathCurrentRegion = By.xpath("//input[@class=\"ui-input__field\"]");
    /** Xpath for region Moscow*/
    private By xpathRegionMoscow = By.xpath("//span[text()=\"г. Москва\"]");
    /** Xpath for region St. Petersburg*/
    private By xpathRegionPetersburg = By.xpath("//span[text()=\"г. Санкт-Петербург\"]");

    /**
     * Constructor
     * @param driver - WebDriver
     */
    public SelectionRegionPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the selecting on region St. Petersburg
     */
    public void selectRegionPetersburg() {
        selectRegion("г. Санкт-Петербург");
        WebElement regionPetersburg = driver.findElement(xpathRegionPetersburg);
        regionPetersburg.click();
    }

    /**
     * The function describes the selecting on region Moscow
     */
    public void selectRegionMoscow() {
        selectRegion("г. Москва");
        WebElement regionMoscow = driver.findElement(xpathRegionMoscow);
        regionMoscow.click();
    }

    /**
     * The function describes the entering name of region on text field
     */
    private void selectRegion(String nameRegion) {
        WebElement inputRegion = driver.findElement(xpathCurrentRegion);
        inputRegion.sendKeys(nameRegion);
    }
}
