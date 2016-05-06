package YikidsTetNG.pages;

import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Elena on 05.05.2016.
 */
public class SignupRecruiterPage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    //Fields
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "zipcode")
    WebElement zipCode1Field;
    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;
    @FindBy(id = "company")
    WebElement companField;

    //System messages
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name field is required.']")
    WebElement firstNameEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name may only contain letters and numbers.']")
    WebElement firstNameWrongFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name must be at least 3 characters.']")
    WebElement firstNameOneNumbFieldMessage;

    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The last name field is required.']")
    WebElement LastNameEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The last name may only contain letters and numbers.']")
    WebElement LastNameWrongFieldMessage;

    @FindBy(xpath = "//*[@id='email-error']/*[text()='The email field is required.']")
    WebElement EmailEmptyFieldMessage;
    @FindBy(xpath = "//*[@id='email-error']/*[text()='The email format is invalid.']")
    WebElement EmailWrongFieldMessage;

    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The zipcode field is required.']")
    WebElement ZipCodEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='Zipcode is invalid']")
    WebElement ZipCodWrongFielNumbdMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The zipcode must be a number.']")
    WebElement ZipCodWrongFieldLattersMessage;

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;

    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[2]/div/label")
    WebElement LastNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[3]/div/label")
    WebElement EmailLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/label")
    WebElement ZipCodLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[5]/div/label")
    WebElement CompanyLabel;
    //Butons
    @FindBy(id = "create-account")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id='topMenuNavigation']/ul/li/a")
    WebElement loginButton;

    //links
    @FindBy(xpath="//*[@id='footerNavigation1']/ul/li[1]/a")
    WebElement aboutUs;

    @FindBy(xpath = "//*[@id='footerNavigation1']/ul/li[2]/a")
    WebElement benefits;

    @FindBy(xpath = "//*[@id='footerNavigation1']/ul/li[3]/a")
    WebElement pricing;

    @FindBy(xpath = "//*[@id='footerNavigation1']/ul/li[4]/a")
    WebElement faq;

    @FindBy(xpath = "//*[@id='footerNavigation1']/ul/li[5]/a")
    WebElement contactUs;


    @FindBy(xpath = "//*[@id='footerNavigation2']/ul/li[1]/a")
    WebElement yiMedicalInc2016;

    @FindBy(xpath = "//*[@id='footerNavigation2']/ul/li[2]/a")
    WebElement privacyPolicy;

    @FindBy(xpath = "//*[@id='footerNavigation2']/ul/li[3]/a")
    WebElement press;

    @FindBy(xpath = "//*[@id='footerNavigation2']/ul/li[4]/a")
    WebElement partners;


    public SignupRecruiterPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public SignupRecruiterPage openElenaSignUPPage() {
        Log.info("Opening ElenaSignUPPage page");
        driver.get(PAGE_URL);
        return this;
    }
    //Verefy elements are present
    public boolean verify_firstNameFieldIsPresent(){
        Log.info("Check the first name field is present");
        return verifyElementIsPresent(firstNameField);
    }
    public boolean verify_lastNameFieldIsPresent(){
        Log.info("Check the last name field is present");
        return verifyElementIsPresent(lastNameField);}
    public boolean verify_emailFieldIsPresent(){
        Log.info("Check the email field is present");
        return verifyElementIsPresent(emailField);}
    public boolean verify_zipCode1FieldIsPresent(){
        Log.info("Check the zip code field is present");
        return verifyElementIsPresent(zipCode1Field);}
    public boolean verify_zipCode2FieldIsPresent(){
        Log.info("Check thezip code2 field is present");
        return verifyElementIsPresent(zipCode2Field);}
    public boolean verify_companFieldIsPresent(){
        Log.info("Check the company field is present");
        return verifyElementIsPresent(companField);}
    public boolean verify_continueButtonIsPresent(){
        Log.info("Check the continue button is present");
        return verifyElementIsPresent(continueButton);}
    public boolean verify_loginButtonIsPresent(){
        Log.info("Check the login button is present");
        return verifyElementIsPresent(loginButton);}
    public boolean verify_aboutUsdIsPresent(){
        Log.info("Check about Us footer element is present");
        return verifyElementIsPresent(aboutUs);}
    public boolean verify_benefitsIsPresent(){
        Log.info("Check benefits footer element is present");
        return verifyElementIsPresent(benefits);}
    public boolean verify_pricingIsPresent(){
        Log.info("Check pricing footer element is present");
        return verifyElementIsPresent(pricing);}
    public boolean verify_faqIsPresent(){
        Log.info("Check faq footer element is present");
        return verifyElementIsPresent(faq);}
    public boolean verify_contactUsIsPresent(){
        Log.info("Check contact Us footer element is present");
        return verifyElementIsPresent(contactUs);}
    public boolean verify_yiMedicalInc2016IsPresent(){
        Log.info("Check yiMedicalInc 2016 footer element is present");
        return verifyElementIsPresent(yiMedicalInc2016);}
    public boolean verify_privacyPolicyIsPresent(){
        Log.info("Check privacy Policy footer element is present");
        return verifyElementIsPresent(privacyPolicy);}
    public boolean verify_pressIsPresent(){
        Log.info("Check press footer element is present");
        return verifyElementIsPresent(press);}
    public boolean verify_partnersIsPresent(){
        Log.info("Check partners footer element is present");
        return verifyElementIsPresent(partners);}

    public boolean CheckFirstNameLabel() {
        Log.info("Check first name lable");
        return verifyTextBoolean(FirstNameLabel, "First name*");
    }

    public boolean CheckLastNameLabel() {
        Log.info("Check last name lable");
        return verifyTextBoolean(LastNameLabel, "Last name*");
    }

    public boolean CheckEmailLabel() {
        Log.info("Check emaail lable");
        return verifyTextBoolean(EmailLabel, "Email*");
    }

    public boolean CheckZipCodeLabel() {
        Log.info("Check zip code lable");
        return verifyTextBoolean(ZipCodLabel, "Zip code*");
    }

    public boolean CheckCompanyNameLabel() {
        Log.info("Check company lable");
        return verifyTextBoolean(CompanyLabel, "Company");
    }


    public String gettext() {
        return getTextElement(ErrorCaptcha);
    }


    //Fill the fields
    public SignupRecruiterPage fillFirstnameField(String username) {
        Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public SignupRecruiterPage fillLastNameField(String lastname) {
        Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public SignupRecruiterPage fillemailField(String email) {
        Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public SignupRecruiterPage fillzipcodeField(String zipcode) {
        Log.info("Filling username field");
        setElementText(zipCode1Field, zipcode);
        return this;
    }

    public SignupRecruiterPage fillzipCode2Field(String zipcode2) {
        Log.info("Filling username field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }

    public SignupRecruiterPage fillcompanyField(String companyName) {
        Log.info("Filling username field");
        setElementText(companField, companyName);
        return this;}

    //clicking buttons
    public SignupRecruiterPage ClickContinueButton() {
        Log.info("Click on continue button");
        clickElement(continueButton);
        return this;
    }
    public void ClicCaptchacheck_box(){
        Log.info("Click on the captcha check box");
        clickElement(ErrorCaptcha);
    }

    public String waitAndGetTextofSelectedMessage(String number) throws IOException, InterruptedException {
        Log.info("Get text to srlrct message");
        String locator = "//*[@id='section-account']/div[" + number + "]//div[2]/span[1]";
        WebElement m = driver.findElement(By.xpath(locator));
        waitUntilElementIsLoaded(m);
        return m.getText();
    }
    public boolean verifyCaptchaMessage(){
        Log.info("verify Captcha Message");
        return verifyTextBoolean(ErrorCaptcha,"Please check Captcha!");

    }

}
