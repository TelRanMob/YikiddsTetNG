package YikidsTetNG.pages;

/**
 * Created by Irina Primak on 4/01/2016.
 */


import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class IrinaLoginPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();
    public String PAGE_URL;

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwordField")
    WebElement passwordField;

    //buttons
    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement NotCorrectPasswordForgotPasswordButton;

    @FindBy(id = "create-account")
    WebElement continueButton;

    @FindBy(xpath = "html/body/div[2]/form/button")
    WebElement resetPasswordButtom;

    //Labels
    /*@FindBy(xpath = "/*//*[@id='login-form']/div[1]")
    WebElement errorPasswordMessage;*/

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement errorPasswordMessage;


    @FindBy(xpath = "//*[@id='contentContainer']/p[1]")
    WebElement pageSignUpTitle;

    @FindBy(xpath = "//*[@id='contentContainer']/p")
    WebElement resetPasswordTitle;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement warningLoginMessage;




    public IrinaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    //random Email generatioin
    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    //Open Page
    public IrinaLoginPage openLoginPage() {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }
    //Fill the fields

    public IrinaLoginPage fillEmailField(String email) {
        Log.info("Filling email field " + email);
        setElementText(emailField, email);
        return this;
    }

    public IrinaLoginPage fillPasswordField(String password) {
        Log.info("Filling passwordField field");
        setElementText(passwordField, password);
        return this;
    }

    public IrinaLoginPage clickToLoginButton() {
        Log.info("LogIn");
        clickElement(loginButton);
        return this;
    }

    public IrinaLoginPage clickToSignUpButton() {
        //Log.info("SignUp");
        clickElement(signUpButton);
        return this;
    }

    public IrinaLoginPage clickToForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(forgotPasswordButton);
        return this;
    }
    public IrinaLoginPage clickNotCorrectPasswordForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(NotCorrectPasswordForgotPasswordButton);
        return this;
    }


    //filling all fields
    public IrinaLoginPage fillLodInFieldsPozitive() {
        fillEmailField("admin@erdocfinder.com");
        fillPasswordField("Test123");
        clickToLoginButton();
        return this;
    }

       //verification methods
    public boolean isOnLoginPage() {
        // Log.info(");
        return exists(loginButton);
    }
    public boolean isOnMainPage() {
        // Log.info(");
        return exists(logOutButton);
    }
    public boolean isOnSingUpPage() {
        // Log.info(");
        return exists(continueButton);
    }
    public boolean isOnResetPasswordPage() {
        // Log.info(");
        return exists(resetPasswordButtom);
    }

    public boolean passwordNotCorrect() {
        return exists(errorPasswordMessage);
    }

    public boolean checkPageSignUpOpen() {
        return verifyTextBoolean(pageSignUpTitle,
                "Step one of finding your physicians");
    }
    public boolean checkPageResetPassword() {
        return verifyTextBoolean(resetPasswordTitle, "Reset Password");

    }
    public boolean checkWarningLoginMessage() {
        return verifyTextBoolean(warningLoginMessage,
                "You have been suspended from trying to login into account \"admin@erdocfinder.com\" for 15 minutes.");

    }
     //Implicity waits -methods on LogInPage

    public void waitForloginButton()    {
        waitUntilIsLoaded(loginButton);
    }
    public void waitForlogOutButton()    {
        waitUntilIsLoaded(logOutButton);
    }
    public void waitForcontinueButtonOnSignUp()    {
        waitUntilIsLoaded(continueButton);
    }
    public void waitForResetPasswordButtom()    {
        waitUntilIsLoaded(resetPasswordButtom);
    }
    public void waitForErrorPasswordMessage()    {
        waitUntilIsLoaded(errorPasswordMessage);
    }
    public void waitForPageSignUpTitle(){
        waitUntilIsLoaded(pageSignUpTitle);
    }
    public void waitForResetPasswordTitle()    {
        waitUntilIsLoaded(resetPasswordTitle);
    }
    public void waitForWarningLoginMessage(){
        waitUntilIsLoaded(warningLoginMessage);
    }


        // public boolean CheckFirstNameLabel() {return verifyTextBoolean(FirstNameLabel, "First name");
        //}
    }
