package Day1.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountHeader;

    // 02 SubscribeFunctionTest

    @FindBy(xpath = "//a[text()='Newsletter']")
    public WebElement NewsletterButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    public WebElement subscribeYesRadioButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    public WebElement subscribeNoRadioButton;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage;

    //03 EditAccountTest

    @FindBy(xpath = "//a[text()='Edit Account']")
    public WebElement editAccountButton;

    @FindBy(id = "input-firstname")
    public WebElement firstNameButton;

    @FindBy(id = "input-lastname")
    public WebElement lastNameButton;

    // 04 AddressBookFunctionTest

    @FindBy(xpath = "//a[text()='Address Book']")
    public WebElement addressBookButton;

    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAddressButton;

    @FindBy(id = "input-address-1")
    public WebElement address1Input;

    @FindBy(id = "input-city")
    public WebElement cityInput;

    @FindBy(id = "input-postcode")
    public WebElement postalCodeInput;

    @FindBy(id = "input-country")
    public WebElement countryDropdown;

    @FindBy(id = "input-zone")
    public WebElement stateDropdown;

    @FindBy(xpath = "(//input[@name='default'])[1]")
    public WebElement defaultAddressYesRadioButton;

    @FindBy(xpath = "(//input[@name='default'])[2]")
    public WebElement defaultAddressNoRadioButton;

    @FindBy(xpath = "(//a[@class='btn btn-info'])[2]")
    public WebElement editAddressButton;

    @FindBy(xpath = "(//a[@class='btn btn-danger'])[2]")
    public WebElement deleteAddressButton;









}
