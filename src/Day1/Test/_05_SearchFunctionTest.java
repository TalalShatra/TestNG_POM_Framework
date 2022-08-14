package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.POM.LoginPageElements;
import Day1.POM.MyAccountPageElements;
import Day1.Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*    Scenario - Search Functionality:
    - Navigate http://opencart.abstracta.us/ (you already have this part in your beforeMethod)
    - Search for an item (like mac or sony)
    - Validate all the items in result page contains your search keyword
 */

public class _05_SearchFunctionTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters({"searchItem"})
    public void searchFunctionTest(String searchItem) {

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

        homePageElements.yourStoreButton.click();

       homePageElements.searchBar.sendKeys(searchItem);
       homePageElements.searchButton.click();

        //for (int i = 0; i < homePageElements.itemsList.size(); i++) {
          //  String elementText = homePageElements.itemsList.get(i).getText().toLowerCase();
          //  Assert.assertTrue(elementText.contains(searchItem.toLowerCase()));
       // }
       for (WebElement element : homePageElements.itemsList) {
            String itemName = element.getText();
            System.out.println("Item : "+itemName);
            Assert.assertTrue(itemName.toLowerCase().contains(searchItem));}



    }
}
