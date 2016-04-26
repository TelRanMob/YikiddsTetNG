package YikidsTetNG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Irina Primak
 */
public class IrinaSignUPPage extends Page {
    private static Random rnd = new Random();
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //fields
    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "zipcode")
    WebElement zipCodeField;

    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;

    @FindBy(id = "company")
    WebElement companyField;

    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement captchaMessage;

    //The first name field is required.
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/div[2]/span")
    WebElement firstNameEmptyFieldMessage;
   //The first name must be at least 3 characters.
   @FindBy(xpath = "//*[@id='section-account']/div[1]/div/div[2]/span")
   WebElement firstNameErrorFieldMessage;
    //The first name may only contain letters and numbers.
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/div[2]/span")
    WebElement firstNameWrongFieldMessage;

    //The last name field is required.
    @FindBy(xpath = "//*[@id='section-account']/div[2]/div/div[2]/span")
    WebElement lastNameEmptyFieldMessage;
    //The last name may only contain letters and numbers.
    @FindBy(xpath = "//*[@id='section-account']/div[2]/div/div[2]/span")
    WebElement lastNameWrongFieldMessage;

    //The email field is required.
    @FindBy(xpath = "//*[@id='email-error']/span[1]")
    WebElement emailEmptyFieldMessage;
    //The email format is invalid.
    @FindBy(xpath = "//*[@id='email-error']/span[1]")
    WebElement invalidEmaildMessage;

    //The zipcode field is required.
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/div[2]/span[1]")
    WebElement zipCodeFieldMessage;
    //Zipcode is invalid.
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/div[2]/span[1]")
    WebElement invalidZipdMessage;
    //The zipcode must be a number.
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/div[2]/span[1]")
    WebElement ZipCodWrongFieldLattersMessage;




    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='topMenuNavigation']/ul/li/a")
    WebElement LogOutButton;




    public IrinaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    private static String getRandomString(Integer length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    //Fill the fields

    public IrinaSignUPPage openSignUpPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    public IrinaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public IrinaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public IrinaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public IrinaSignUPPage fillzipCodeField(String zipCode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipCode);
        return this;
    }

    public IrinaSignUPPage fillzipCod2Field(String zipCode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipCode2);
        return this;
    }

    public IrinaSignUPPage fillcompanyField(String company) {
        //Log.info("Filling username field");
        setElementText(companyField, company);
        return this;
    }
    //fill all fields in one method

    public IrinaSignUPPage clickElemToContinue() {
        clickElement(continueButton);
        return this;
    }

    public IrinaSignUPPage fillSignUp() {
        fillFirstnameField("FirstName");
        fillLastNameField("LastName");
        fillcompanyField("Company");
        fillzipCodeField("4565");
        fillzipCod2Field("");
        fillemailField(generateEmail());
        return this;
    }

    //emailGeneration
    public String generateEmail() {
        String rand = getRandomString(5);
        String randEmail = rand + "@yopmail.com";
        return randEmail;
    }

    //public boolean checkPageOpen() {
       // return super.verifyTextBoolean(pageTitle, "Step one of finding your physicians");
    //
    //verification methods
    public boolean isOnSignUpPage() {
        // Log.info(");
        return exists(continueButton);
    }
    public boolean checkFirstNameEmptyFieldMessage() {
        return verifyTextBoolean(firstNameEmptyFieldMessage, "The first name field is required.");
    }

    public boolean checkLastNameEmptyFieldMessage() {
        return verifyTextBoolean(lastNameEmptyFieldMessage, "The last name field is required.");
    }

    public boolean checkEmailEmptyFieldMessage() {
        return verifyTextBoolean(emailEmptyFieldMessage, "The email field is required.");
    }
    public boolean checkEmailInvalidFieldMessage() {
        return verifyTextBoolean(invalidEmaildMessage, "The email format is invalid.");
    }

    public boolean checkZipEmptyFieldMessage() {
        return verifyTextBoolean(zipCodeFieldMessage,"The zipcode field is required.");
    }
    public boolean checkZipInvalidFieldMessage() {
        return verifyTextBoolean(invalidZipdMessage, "The zipcode must be a number.");
    }

    public boolean checkPageForCaptchaMessage() {
        return verifyTextBoolean(captchaMessage, "Please check Captcha!");
    }

    public String waitAndGetTextofSelectedMessage(String number) throws IOException, InterruptedException {
        String locator = "//*[@id='section-account']/div[" + number + "]//div[2]/span";
        WebElement m = driver.findElement(By.xpath(locator));
        waitUntilElementIsLoaded(m);
        return m.getText();
    }
    //Implicity waits -method on SignUpPage

    public void waitForWarningFirstNameEmpty() {
        waitUntilIsLoaded(firstNameEmptyFieldMessage);
    }

    public void waitForWarningLastNameEmpty() {
        waitUntilIsLoaded(lastNameEmptyFieldMessage);
    }
    public void waitForWarningEmailEmptyField() {
        waitUntilIsLoaded(emailEmptyFieldMessage);
    }
    public void waitForWarningInvalidEmail() {
        waitUntilIsLoaded(invalidEmaildMessage);
    }
    public void waitForWarningZipEmptyField() {
        waitUntilIsLoaded(zipCodeFieldMessage);
    }
    public void waitForWarningInvalidZip() {
        waitUntilIsLoaded(invalidZipdMessage);
    }
    public void waitForCaptcha() {
        waitUntilIsLoaded(captchaMessage);
    }



    //public boolean checkFirstNameLabel() {
     // return verifyTextBoolean(FirstNameLabel, "First")}
}