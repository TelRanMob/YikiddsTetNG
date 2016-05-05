package YikidsTetNG.pages;

/**
 * Created by Irina Primak on 03/05/2016.
 */


import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class LoginPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();
    public String PAGE_URL;
    private String login = "admin@erdocfinder.com";
    private String pass = "Test123";

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwordField")
    WebElement passwordField;

    @FindBy(id = "firstname")
    WebElement firstNameFieldSingUpPage;

    //buttons
    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutOverviewPageButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordButton;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement notCorrectPasswordForgotPasswordButton;

    @FindBy(id = "create-account")
    WebElement continueButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement resetPasswordButtom;

    //Messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement captchaMessage;

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement errorPasswordMessage;
    /*@FindBy(xpath = "/*//*[@id='login-form']/div[1]")
    WebElement errorPasswordMessage;*/

    //message-Please sign up because your email does not exist in our system
    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement emailNotExistMessage;
    /*@FindBy(xpath = "//div[@class='err'][contains(text(),'Please sign up because your email does not exist in our system.')]")
    WebElement notExistEmaildMessage;
    @FindBy(xpath="//*[@class='err']")
    WebElement errorEmail;
    */


    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;

    //Titles
    @FindBy(xpath = "//*[@id='contentContainer']/p[1]")
    WebElement pageSignUpTitle;
    /*
    @FindBy(xpath = "//p[@class='title']")
    WebElement titleSignUpPageLabel;
     */
    @FindBy(xpath = "//*[html/body/div[2]/h1]")
    WebElement forgotPasswordTitle;

    @FindBy(xpath = "//*[@id='contentContainer']/p")
    WebElement resetPasswordTitle;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement warningLoginMessage;




    public LoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com";
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
    public LoginPage openLoginPage() {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }
    //Fill the fields

    public LoginPage fillEmailField(String email) {
        Log.info("Filling email field " + email);
        setElementText(emailField, email);
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        Log.info("Filling passwordField field");
        setElementText(passwordField, password);
        return this;
    }

    public LoginPage clickToLoginButton() {
        Log.info("LogIn");
        clickElement(loginButton);
        return this;
    }

    public LoginPage clickToSignUpButton() {
        //Log.info("SignUp");
        clickElement(signUpButton);
        return this;
    }

    public LoginPage clickToForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(forgotPasswordButton);
        return this;
    }
    public LoginPage clickNotCorrectPasswordForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(notCorrectPasswordForgotPasswordButton);
        return this;
    }


    //filling all fields
    public LoginPage fillLodInFieldsPozitive() {
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
        return exists(logOutOverviewPageButton);
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
        waitUntilIsLoaded(logOutOverviewPageButton);
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
