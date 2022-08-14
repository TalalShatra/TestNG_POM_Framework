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

    @FindBy(xpath = "//a[text()='Your Store']")
    public WebElement yourStoreButton;

    @FindBy(css = "input[name='search']")
    public WebElement searchBar;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindAll({@FindBy(xpath = "//h4")})
    public List<WebElement> itemsList;

    // 06

    @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(id = "input-enquiry")
    public WebElement enquiryInput;

    @FindBy(css = "input[value='Submit']")
    public WebElement submitButton;



}
