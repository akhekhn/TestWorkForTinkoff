package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for page Payment of ZHKU Moscow.
 * @author Alexandra Khekhneva
 */
public class PayZHKUPage {
    /** WebDriver */
    private WebDriver driver;
    /** Xpath for text field Payer Code*/
    private By xpathPayerCodeTextField = By.xpath(".//*[@id='payerCode']");
    /** Xpath of error message for text field Payer Code*/
    private By xpathErrorMessagePayerCode = By.xpath("//form/div[1]/div/div[2]");
    /** Xpath for text field Provider Period*/
    private By xpathProviderPeriod = By.xpath("//input[@name=\"provider-period\"]");
    /** Xpath of error message for text field Provider Period*/
    private By xpathErrorMessageProviderPeriod = By.xpath("//form/div[2]/div/div[2]");
    /** Xpath for text field Amount Payment*/
    private By xpathAmountPayment = By.xpath("//form/div[4]/div/div/div/div/div/div/div/div[1]/label/div[1]/input");
    /** Xpath of error message for text field Amount Payment*/
    private By xpathErrorMessageAmountPayment = By.xpath("//div[@class=\"ui-form__row ui-form__row_amount\"]/div/div/div/div[2]");

    /**
     * Constructor
     * @param driver - WebDriver
     */
    public PayZHKUPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The function describes the checking text messages about an error when entering incorrect data to text field Payer Code
     * @return true if text messages is right
     */
    public boolean checkErrorMessagesTextFieldPayerCode(){
        WebElement field = driver.findElement(xpathPayerCodeTextField);

        //empty enter
        if (!checkErrorMessages(field, xpathErrorMessagePayerCode, "", "Поле обязательное"))
            return false;


        //enter "12345" to field
        if (!checkErrorMessages(field, xpathErrorMessagePayerCode, "12345", "Поле неправильно заполнено"))
            return false;

        return true;
    }

    /**
     * The function describes the checking text messages about an error when entering incorrect data to text field Provider Period
     * @return true if text messages is right
     */
    public boolean checkErrorMessagesTextFieldProviderPeriod(){
        WebElement field = driver.findElement(xpathProviderPeriod);

        //empty enter
        if  (!checkErrorMessages(field, xpathErrorMessageProviderPeriod, "", "Поле обязательное"))
            return false;


        //enter "12" to field
        if (!checkErrorMessages(field, xpathErrorMessageProviderPeriod, "12", "Поле заполнено некорректно"))
            return false;

        return true;
    }

    /**
     * The function describes the checking text messages about an error when entering incorrect data to text field Amount Payment
     * @return true if text messages is right
     */
    public boolean checkErrorMessagesTextFieldAmountPayment() {
        WebElement field = driver.findElement(xpathAmountPayment);
        //empty enter
        if (!checkErrorMessages(field, xpathErrorMessageAmountPayment, "", "Поле обязательное")) {
            return false;
        }

        //enter "9" to field
        if (!checkErrorMessages(field, xpathErrorMessageAmountPayment, "9", "Минимальная сумма перевода - 10 \u20BD"))
            return false;


        //enter "15 001" to field
        if (!checkErrorMessages(field, xpathErrorMessageAmountPayment, "15 001", "Максимальная сумма перевода - 15 000 \u20BD"))
            return false;

        return true;
    }

    /**
     * The function describes the entering data to text field
     * @return text messages about an error
     */
    private boolean checkErrorMessages(WebElement field, By message, String textEnter, String expectMessage){
        field.sendKeys(textEnter);
        field.sendKeys(Keys.RETURN);
        WebElement errorMessageElement = driver.findElement(message);
        return errorMessageElement.getText().equals(expectMessage);
    }


}
