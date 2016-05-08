package YikidsTetNG;


import YikidsTetNG.pages.SignUPPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irina Primak on 29-Mar-16.
 */
public class IrinaSignUpTest extends TestNgTestBase {
    //  static String driverPath = "Z:\\Tel-RAN\\aQA\\BrowserDrivers";
    public SignUPPage signUPPageI;
  //  public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.crome.driver", driverPath+"chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
       // driver = new FirefoxDriver();
        signUPPageI = PageFactory.initElements(driver, SignUPPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException {
        //signUPPageI.openSignUpPage();
        driver.get(baseUrl+"/recruiter/signup");
        //signUPPageI.isOnSignUpPage();
        //Thread.sleep(3000);
    }


    @Test
    public void fillFilldesPositiv() throws InterruptedException {
        signUPPageI.fillSignUp()
                .clickElemToContinue();
                Thread.sleep(3000);
        assertTrue("No captha message", signUPPageI.checkPageForCaptchaMessage());

    }

    @Test(dataProviderClass = IrinaDataProviders.class, dataProvider = "singUpNegativFromFile")
    public void negativSingUp(String firstName,String lastname,String email,String cod,
                              String cod2,String number, String message) throws IOException, InterruptedException {
        signUPPageI
                .fillFirstnameField(firstName)
                .fillLastNameField(lastname)
                .fillemailField(email)
                .fillzipCodeField(cod)
                .fillcompanyField("Company")
                .fillzipCod2Field(cod2)
                .clickElemToContinue();
                //Explicite wait
                //Thread.sleep(3000);
                //Implicity wait -method on SignUpPage
        Assert.assertEquals(signUPPageI.waitAndGetTextofSelectedMessage(number), message, "Message is nor correct");
        assertTrue("Not on SingUp Page", signUPPageI.isOnSignUpPage());
    }

    @Test
    public void fillFildesNegativFirstNameEmpty() {
        signUPPageI
                .fillFirstnameField(" ")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillzipCodeField("4562")
                .fillcompanyField("Compani")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                //Explicite wait
                //Thread.sleep(3000);
                //Implicity wait -method on SignUpPage
                .waitForWarningFirstNameEmpty();
        assertTrue("No firstName empty warning", signUPPageI.checkFirstNameEmptyFieldMessage());
    }
    @Test
    public void fillFildesNegativLastNameEmpty() {
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField(" ")
                .fillemailField("email@yopmail.com")
                .fillcompanyField("Company")
                .fillzipCodeField("4562")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .waitForWarningLastNameEmpty();
        assertTrue("No lastName empty warning", signUPPageI.checkLastNameEmptyFieldMessage());
    }

    @Test
    public void fillFildesNegativEmailEmpty() {
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField(" ")
                .fillcompanyField("Company")
                .fillzipCodeField("4562")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .waitForWarningEmailEmptyField();
        assertTrue("No emailEmptyField warning", signUPPageI.checkEmailEmptyFieldMessage());
    }

    @Test
    public void fillFildesNegativEmailUncorrect() {
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField(" yopmail.com")
                .fillcompanyField("Company")
                .fillzipCodeField("4562")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .waitForWarningInvalidEmail();
        assertTrue("No Invalid Email warning", signUPPageI.checkEmailInvalidFieldMessage());
    }

    @Test
    public void fillFildesNegativZipCodeEmpty() {
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillcompanyField("Company")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .waitForWarningZipEmptyField();
        assertTrue("No ZipEmptyField warning", signUPPageI.checkZipEmptyFieldMessage());
    }

    @Test
    public void fillFildeInvalidZipCode() {
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillcompanyField("Company")
                .fillzipCodeField("gffdh")
                .clickElemToContinue()
                .waitForWarningInvalidZip();
        assertTrue(" No Invalid Zip warning", signUPPageI.checkZipInvalidFieldMessage());


    }

    @Test
    public void fullNegativ() {
        signUPPageI
                .fillFirstnameField("")
                .fillLastNameField("")
                .fillemailField("")
                .fillcompanyField("")
                .fillzipCodeField("")
                .clickElemToContinue()
                .waitForCaptcha();
        assertTrue("No captha message", signUPPageI.checkPageForCaptchaMessage());
        assertTrue("No firstName empty warning", signUPPageI.checkFirstNameEmptyFieldMessage());
        assertTrue("No lastName empty warning", signUPPageI.checkLastNameEmptyFieldMessage());
        assertTrue("No emailEmptyField warning", signUPPageI.checkEmailEmptyFieldMessage());
        assertTrue("No ZipEmptyField warning", signUPPageI.checkZipEmptyFieldMessage());

    }


    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

}


