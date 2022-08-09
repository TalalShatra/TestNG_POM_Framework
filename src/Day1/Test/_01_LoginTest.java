package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.POM.LoginPageElements;
import Day1.POM.MyAccountPageElements;
import Day1.Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_LoginTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;


    @Test
    public void LoginPositiveTest(){

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
    }
    @Test
    public void LoginNegativeTest(){

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("wellsa@gmail.com");
        loginPageElements.passwordInput.sendKeys("12345");
        loginPageElements.loginButton.click();


        String loginFailedMessageText = loginPageElements.loginFailedMessage.getText();
        boolean isErrorDisplayed = loginPageElements.loginFailedMessage.isDisplayed();

        Assert.assertTrue(isErrorDisplayed);

        Assert.assertEquals(loginFailedMessageText, "Warning: No match for E-Mail Address and/or Password.");
    }


}
