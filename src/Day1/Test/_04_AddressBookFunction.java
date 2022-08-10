package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.POM.LoginPageElements;
import Day1.POM.MyAccountPageElements;
import Day1.Utils.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
Scenario 1 - Add New Address
Scenario 2 - Edit Address
Scenario 3 - Delete Address
 */
public class _04_AddressBookFunction extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    String expectedMessageNewAddress = "Your address has been successfully added";
    String expectedMessageEditAddress = "Your address has been successfully updated";
    String expectedMessageDeleteAddress = "Your address has been successfully deleted";
    @Test           //(priority = 1)
    public void addNewAddressTest() {

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

        myAccountPageElements.addressBookButton.click();

        myAccountPageElements.newAddressButton.click();

        myAccountPageElements.firstNameButton.sendKeys("well");
        myAccountPageElements.lastNameButton.sendKeys("sander");
        myAccountPageElements.address1Input.sendKeys("15 main street");
        myAccountPageElements.cityInput.sendKeys("paterson");
        myAccountPageElements.postalCodeInput.sendKeys("07504");
        Select selectCountry = new Select(myAccountPageElements.countryDropdown);
        selectCountry.selectByVisibleText("United States");
        Select selectState = new Select(myAccountPageElements.stateDropdown);
        selectState.selectByVisibleText("Arizona");

        myAccountPageElements.defaultAddressNoRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageNewAddress);
    }
    @Test (dependsOnMethods = "addNewAddressTest")        //(priority = 2)
    public void editAddressTest() {

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

        myAccountPageElements.addressBookButton.click();

        myAccountPageElements.editAddressButton.click();

        myAccountPageElements.address1Input.clear();
        myAccountPageElements.address1Input.sendKeys("21 main street");

        myAccountPageElements.defaultAddressNoRadioButton.click();
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageEditAddress);
    }

    @Test(dependsOnMethods = "editAddressTest")   //(priority = 3)
    public void deleteAddressTest() {

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

        myAccountPageElements.addressBookButton.click();

        myAccountPageElements.deleteAddressButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageDeleteAddress);

    }
}
