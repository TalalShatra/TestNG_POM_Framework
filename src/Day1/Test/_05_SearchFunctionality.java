package Day1.Test;

import Day1.POM.HomePageElements;
import Day1.Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*    Scenario - Search Functionality:
    - Navigate http://opencart.abstracta.us/ (you already have this part in your beforeMethod)
    - Search for an item (like mac or sony)
    - Validate all the items in result page contains your search keyword
 */

public class _05_SearchFunctionality  extends BaseDriver {
    HomePageElements homePageElements;
    String searchKeyword = "mac";

    @Test
    public void searchFunctionalityTest(){

        homePageElements = new HomePageElements(driver);

       homePageElements.searchBar.click();
       homePageElements.searchBar.sendKeys("mac");
       homePageElements.searchButton.click();


        for (WebElement element : homePageElements.itemsList) {
            String itemName = element.getText();
            System.out.println("Item : "+itemName);
            Assert.assertTrue(itemName.toLowerCase().contains(searchKeyword));}



    }
}
