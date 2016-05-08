package YikidsTetNG;

import YikidsTetNG.pages.SignupPagePhisican;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Elena on 05.05.2016.
 */
public class SignupPhisicanTest  extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //protected WebDriver driver;
    public SignupPagePhisican signupPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
     // driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        signupPage = PageFactory.initElements(driver, SignupPagePhisican.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        //signupPage.openSignUPPage();
        // public void beforeMethodSetUp(){driver.get(baseUrl);
        driver.get("http://physician.yikids.com/signup");
    }




    @Test (groups = {"automatic", "positive"})
    public void VerefyElementsIsPresent(){

        Log.info("Tes erefyElementsIsPresent was started....");

        Assert.assertTrue(signupPage.verify_firstNameFieldIsPresent(), "The first name field is present ");

        Assert.assertTrue(signupPage.verify_lastNameFieldIsPresent(), "The last name field is present ");
        Assert.assertTrue(signupPage.verify_emailFieldIsPresent(), "The email field is present ");
        Assert.assertTrue(signupPage.verify_zipCode1FieldIsPresent(), "The zipCode field is present ");
        Assert.assertTrue(signupPage.verify_zipCode2FieldIsPresent(), "The zipCode2 field is present ");
        Assert.assertTrue(signupPage.verify_continueButtonIsPresent(), "The Continue button is present ");
        Assert.assertTrue(signupPage.verify_loginButtonIsPresent(), "The login button is present ");
        Assert.assertTrue(signupPage.verify_aboutUsdIsPresent(), "The aboutUs link is present ");
        Assert.assertTrue(signupPage.verify_contactUsIsPresent(), "The contactUs link is present ");
        Assert.assertTrue(signupPage.verify_benefitsIsPresent(), "The benefits link is present ");
        Assert.assertTrue(signupPage.verify_pricingIsPresent(), "The pricing link is present ");
        Assert.assertTrue(signupPage.verify_pressIsPresent(), "The press link is present ");
        Assert.assertTrue(signupPage.verify_partnersIsPresent(), "The partners link  is present ");
        Assert.assertTrue(signupPage.verify_privacyPolicyIsPresent(), "The privacyPolicy link is present ");
        Assert.assertTrue(signupPage.verify_yiMedicalInc2016IsPresent(), "The privacyPolicy link is present ");
        assertTrue("First Name text is confirmed", signupPage.CheckFirstNameLabel());
        assertTrue("Last Name text is confirmed", signupPage.CheckLastNameLabel());
        assertTrue("Email text is confirmed", signupPage.CheckEmailLabel());
        assertTrue("Zip Code text is confirmed", signupPage.CheckZipCodeLabel());

    }

    @Test(groups = {"automatic", "negative"}, dataProviderClass = DataProviders.class, dataProvider = "loadInvalidSingUpFromFile")
    public void SingUppNegativeTest(String Firstname, String lastname, String email, String Zip1, String
            Zip2, String nubmer, String message) throws IOException, InterruptedException {
        Log.info("Tes SingUppNegativeTest was started....");
        signupPage
                .fillFirstnameField(Firstname)
                .fillLastNameField(lastname)
                .fillemailField(email)
                .fillzipcodeField(Zip1)
                 .fillzipCode2Field(Zip2);
        signupPage.ClickContinueButton();




        // System.out.println(taniaSignUPPage.gettext());
        //assertTrue("Check warning message the first name feld is ampty ",taniaSignUPPage.CheckWarningMessageFirstName());
        Assert.assertEquals(signupPage.waitAndGetTextofSelectedMessage(nubmer), message, "Message is nor correct");

    }

    @Test
    public void NegativeFillTest() {
        signupPage
                .fillemailField("")
                .fillFirstnameField("")
                .fillLastNameField("")
                .fillzipcodeField("")
                .fillzipCode2Field("")
                .ClickContinueButton()
                .waitForCaptcha();
        assertTrue("No captha message", signupPage.verifyCaptchaMessage());
        assertTrue("No firstName empty warning", signupPage.checkFirstNameEmptyFieldMessage());
        assertTrue("No lastName empty warning", signupPage.checkLastNameEmptyFieldMessage());
        assertTrue("No emailEmptyField warning", signupPage.checkEmailEmptyFieldMessage());
        assertTrue("No ZipEmptyField warning",signupPage.checkZipEmptyFieldMessage());

    }


    @Test//Positive
    public void PositiveFillTest() throws InterruptedException {

        signupPage
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("01089")
                .fillzipCode2Field("55");
        Thread.sleep(10000);
        signupPage.ClickContinueButton();


    }
        @AfterSuite(alwaysRun = true)
        public void tearDown () {
            this.driver.quit();
        }
    }

