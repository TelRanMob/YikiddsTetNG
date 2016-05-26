package YikidsTetNG;



import YikidsTetNG.pages.AddHospitalPage;
import YikidsTetNG.pages.LoginPage;
import YikidsTetNG.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by rut on 05.05.2016.
 */
public class AddHospitalTest extends TestNgTestBase {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public AddHospitalPage addHospitalPage;
    public LoginPage loginPage;
    public MainPage mainPage;
//    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
//        driver = new FirefoxDriver();
        addHospitalPage = PageFactory.initElements(driver, AddHospitalPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        driver.get("http://admin.yikids.com/");
        loginPage.isOnLoginPage();
        loginPage.fillLodInFieldsPozitive();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        mainPage.isOnMainPage();
//        mainPage.goToAddHospitalPage();
        driver.get("http://admin.yikids.com/hospital/add");
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalPositiveFromFile")
    public void addHospitalPositive(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                    String email,String type,String state,String text,String haveAnER) {
        Log.info("Test AddHospitalPositive with ExtData was started...");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddressField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .fillOtherInfoField(text)
                .fillTypeOfFacilityField(type)
                .clickToSave();
//        assertTrue("Hospital Saved Message", addHospitalPage.hospitalSavedMessage());
    }
//    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalNegativeFromFile")
    public void addHospitalNegative(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                    String email,String type,String state,String haveAnER,String text) {
        Log.info("Test AddHospitalNegative with ExtData was started...");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddressField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .fillTypeOfFacilityField(type)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .fillOtherInfoField(text)
                .clickToSave();
        Assert.assertFalse(addHospitalPage.hospitalSavedMessage(),"Hospital Saved Message");
    }
//    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalErrorZipNegativeFromFile")
    public void addHospitalNegativeZipMessage(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                    String email,String type,String state,String haveAnER,String text) throws IOException, InterruptedException {
        Log.info("Test AddHospitalNegativeZipMessage with ExtData was started...");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddressField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .fillTypeOfFacilityField(type)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .fillOtherInfoField(text)
                .clickToSave()
                .waitForErrorZipWarning();

        assertTrue("Please enter a valid zipcode",addHospitalPage.checkErrorZipMessage());
        Assert.assertFalse(addHospitalPage.hospitalSavedMessage(),"Hospital Saved Message");
    }
//    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalErrorNameNegativeFromFile")
    public void addHospitalNegativeNameMessage(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                           String email,String type,String state,String haveAnER,String text) throws IOException, InterruptedException {
        Log.info("Test AddHospitalNegativeNameMessage with ExtData was started...");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddressField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .fillTypeOfFacilityField(type)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .fillOtherInfoField(text)
                .clickToSave();
        assertTrue("The name must be at least 5 characters.",addHospitalPage.checkErrorNameMessage());
        Assert.assertFalse(addHospitalPage.hospitalSavedMessage(),"Hospital Saved Message");
    }
//    @Test
    public void addHospitalCheckNameMessage(){
        addHospitalPage
                .fillNameField(" ")
                .fillAddressField("adress");
        assertTrue("Please enter a valid hospital name",addHospitalPage.checkEmptyNameMessage());
    }
//    @Test
    public void addHospitalFillAndCheck(){
        addHospitalPage.fillAddHospitalProfile();
//        assertTrue("Hospital Saved Message", addHospitalPage.hospitalSavedMessage());
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }
}
