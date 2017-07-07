import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Class with tests.
 * @author Alexandra Khekhneva
 */
public class TinkoffTestPage {
    /** Firefox driver */
    private FirefoxDriver driver;
    /** name of provider */
    private String nameProvider;

    /**
     * The function describes what do we do before each test
     */
    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.tinkoff.ru");
    }

    /**
     * The function describes what do we do after each test
     */
    @After
    public void tearDown(){
        driver.close();
    }

    /**
     * The test that verifies that the current region is Moscow
     */
    @Test
    public void testCheckRegion() {
        MainPage page = new MainPage(driver);
        PaymentsPage pay_page = page.clickMenuPayments();
        MunicipalPaymentsPage mun_pay_page = pay_page.clickMunicipalPayments();
        boolean resultCheck = mun_pay_page.IsCurrentRegionMoscow();
        if (resultCheck)
            Assert.assertTrue(resultCheck);
        else
            Assert.assertFalse(resultCheck);
    }

    /**
     * The test that verifies for invalid values for the mandatory fields of the Payment tab for the provider ZHKU Moscow
     */
    @Test
    public void testCheckErrorMessage() {
        MainPage page = new MainPage(driver);
        PaymentsPage pay_page = page.clickMenuPayments();
        MunicipalPaymentsPage mun_pay_page = pay_page.clickMunicipalPayments();
        nameProvider = mun_pay_page.getNameProviderZhKUMoscow();
        ProviderZhKUMoscowPage provider_moscow_page = mun_pay_page.clickProviderZhKUMoscow();
        PayZHKUPage payment_page = provider_moscow_page.clickPayZHKUTab();

        //check error mesage for textfield Payer Code
        Assert.assertTrue(payment_page.checkErrorMessagesTextFieldPayerCode());

        //check error messages for textfield Provider Period
        Assert.assertTrue(payment_page.checkErrorMessagesTextFieldProviderPeriod());

        //check error messages for textfield Provider Period
        Assert.assertTrue(payment_page.checkErrorMessagesTextFieldAmountPayment());
    }

    /**
     * Test that verifies that:
     * 1) the desired provider is the first in the list of providers by searching
     * 2) when choosing this provider from the list, we will go to the page for this provider
     * @throws InterruptedException exception
     */
    @Test
    public void testCheckProviderIsFirst() throws InterruptedException {
        MainPage page = new MainPage(driver);
        PaymentsPage pay_page = page.clickMenuPayments();
        MunicipalPaymentsPage mun_pay_page = pay_page.clickMunicipalPayments();
        Thread.sleep(5000);
        WebElement firstElementList = mun_pay_page.getFirstProvider(nameProvider);
        assert (firstElementList.getText().contains(nameProvider));

        ProviderZhKUMoscowPage provider_moscow_page = mun_pay_page.clickProviderFromList(firstElementList);
        provider_moscow_page.clickPayZHKUTab();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.tinkoff.ru/zhku-moskva/" );

    }

    /**
     * The test verifies that there is no provider ZHKU Moscow in the list of providers for the St. Petersburg region
     */
    @Test
    public void testRegionPetersburgNotFound() {
        MainPage page = new MainPage(driver);
        PaymentsPage pay_page = page.clickMenuPayments();
        MunicipalPaymentsPage mun_pay_page = pay_page.clickMunicipalPayments();
        boolean resultCheck = mun_pay_page.findRegion(nameProvider);
        Assert.assertTrue(resultCheck);
    }

}
