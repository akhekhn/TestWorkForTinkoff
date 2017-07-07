package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Class for page Communal payments.
 * @author Alexandra Khekhneva
 */
public class MunicipalPaymentsPage {
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for element Current Region*/
    private By xpathCurrentRegion = By.xpath("//div[text()=\"Коммунальные платежи\"]/span[2]");
    /** Xpath for provider zhku-moskva */
    private By xpathProvider = By.xpath("//span[2]/a[@href=\"/zhku-moskva/\"]/span");
    /** Xpath for search field of provider */
    private By xpathSearchField = By.xpath("//div/label/input[@class=\"_2XFoD _1phV_\"]");
    /** Xpath for list of providers */
    private By xpathListProviders = By.xpath("//section/ul/li");
    /** Xpath for list of providers by searching */
    private By xpathListProvidersSearch = By.xpath("//div[@class=\"_2zhCT _2b7Gu\"]/div");


    /**
     * Constructor
     * @param driver - WebDriver
     */
    public MunicipalPaymentsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the clicking on the element Current Region
     * @return driver for page Selection Region
     */
    private SelectionRegionPage clickSelectRegion() {
        WebElement selectRegionElement=driver.findElement(xpathCurrentRegion);
        selectRegionElement.click();
        return new SelectionRegionPage(driver);
    }

    /**
     * The function describes the checking the current region
     * @return true, if curent region is Moscow
     * @return false, if curent region is not Moscow and select region Moscow
     */
    public boolean IsCurrentRegionMoscow()
    {
        WebElement curReg = driver.findElement(xpathCurrentRegion);
        if (curReg.getText().equals("Москве"))
            return true;
        else {
            SelectionRegionPage sel_reg_page = this.clickSelectRegion();
            sel_reg_page.selectRegionMoscow();
            return false;
        }
    }

    /**
     * The function describes the clicking on the first provider from list providers
     * @return driver for page this provider
     */
    public ProviderZhKUMoscowPage clickProviderZhKUMoscow() {
        List<WebElement> listProviders = driver.findElements(xpathListProviders);
        listProviders.get(0).click();
        return new ProviderZhKUMoscowPage(driver);
    }

    /**
     * The function describes the getting text for provider
     * @return name of provider zhku-moskva
     */
    public String getNameProviderZhKUMoscow() {
        return driver.findElement(xpathProvider).getText();
    }

    /**
     * The function describes the select on the first provider from the list of providers by searching
     * @param name name of provider
     * @return first provider
     */
    public WebElement getFirstProvider(String name) {
        WebElement searchField = driver.findElement(xpathSearchField);
        searchField.sendKeys(name);
        List<WebElement> listProviders = driver.findElements(xpathListProvidersSearch);
        String text = listProviders.get(0).getText();
        return listProviders.get(0);
    }

    /**
     * The function describes the clicking on the provider
     * @param provider - provider by search
     * @return driver for page this provider
     */
    public ProviderZhKUMoscowPage clickProviderFromList(WebElement provider) {
        provider.click();
        return  new ProviderZhKUMoscowPage(driver);
    }

    /**
     * The function describes the checking lack of a provider zhku-moskva for the St. Petersburg region
     * @param nameProvider name of provider
     * @return true, if provider is not found
     * @return false, if provider is found
     */
    public boolean findRegion(String nameProvider) {
        SelectionRegionPage sel_reg_page = this.clickSelectRegion();
        sel_reg_page.selectRegionPetersburg();
        List<WebElement> listProviders = driver.findElements(xpathListProviders);
        for (WebElement element: listProviders) {
            if (element.getText().equals(nameProvider)) {
                return false;
            }
        }
        return true;
    }
}
