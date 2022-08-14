package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.POM.LoginPageElements;
import Day1.POM.MyAccountPageElements;
import Day1.Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _06_ContactUsFunctionTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters("enquiry")
    public void contactUsTest(String enquiry) {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("wellsa@gmail.com");
        loginPageElements.passwordInput.sendKeys("soso1971");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        homePageElements.contactUsButton.click();
        homePageElements.enquiryInput.sendKeys(enquiry);
        homePageElements.submitButton.click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("success"));

        System.out.println(currentUrl);

    }
}
