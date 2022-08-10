package Day1.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;

    //05 SearchFunctionality

    @FindBy(css = "input[name='search']")
    public WebElement searchBar;

    @FindBy(css = "i[class='fa fa-search']")
    public WebElement searchButton;

    @FindAll({@FindBy(css = "h4")})
    public List<WebElement> itemsList;





}
