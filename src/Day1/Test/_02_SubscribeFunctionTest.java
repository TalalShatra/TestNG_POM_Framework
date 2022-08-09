package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.POM.LoginPageElements;
import Day1.POM.MyAccountPageElements;
import Day1.Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_SubscribeFunctionTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    String expectedMessage ="Success: Your newsletter subscription has been successfully updated!";

    @Test
    public void subscribeTest(){

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

        myAccountPageElements.NewsletterButton.click();
        myAccountPageElements.subscribeYesRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessage);

    }
    @Test
    public void unsubscribeTest(){
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

        myAccountPageElements.NewsletterButton.click();
        myAccountPageElements.subscribeNoRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessage);

    }


}
