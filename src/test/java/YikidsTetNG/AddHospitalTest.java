package YikidsTetNG;



import YikidsTetNG.pages.AddHospitalPage;
import YikidsTetNG.pages.LoginPage;
import YikidsTetNG.pages.MainPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        driver.get("http://admin.yikids.com/");
        loginPage.isOnLoginPage();
        loginPage.fillLodInFieldsPozitive();
        mainPage.isOnMainPage();
        mainPage.goToAddHospitalPage();
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalPositiveFromFile")
    public void addHospitalPositive(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                    String email,String type,String text,String state,String haveAnER) {
        Log.info("Filling all fields");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddresssField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .fillTypeOfFacilityField(type)
                .fillOtherInfoField(text)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .clickToSave();
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadAddHospitalNegativeFromFile")
    public void addHospitalNegative(String name,String address,String city,String country,String zipCode,String phoneNumber,
                                    String email,String type,String text,String state,String haveAnER) {
        Log.info("Filling all fields");
        addHospitalPage
                .checkRecrutingStatusCheckbox()
                .fillNameField(name)
                .fillAddresssField(address)
                .fillCityField(city)
                .fillCountryField(country)
                .fillZipCodeField(zipCode)
                .fillPhoneNumberField(phoneNumber)
                .fillEmailField(email)
                .fillTypeOfFacilityField(type)
                .fillOtherInfoField(text)
                .selectStateInDropdown(state)
                .selectHaveAnERInDropdown(haveAnER)
                .clickToSave();
    }
    @Test
    public void addHospitalFillAndCheck(){
        addHospitalPage.fillAddHospitalProfile();
    }
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }
}
