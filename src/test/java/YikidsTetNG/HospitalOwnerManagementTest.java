
package YikidsTetNG;
/**
 * Created by Pereminski Tatiana on 7-05-16.
 */


import YikidsTetNG.pages.HospitalOwnerManagementPage;
import YikidsTetNG.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class HospitalOwnerManagementTest extends TestNgTestBase {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //public String email = "admin@erdocfinder.com";
    //public String passwordField = "Test123";


    public HospitalOwnerManagementPage hospOwnerManagPage;
    public LoginPage loginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        hospOwnerManagPage = PageFactory.initElements(driver, HospitalOwnerManagementPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage();
        loginPage.fillLodInFieldsPozitive();

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        driver.get("http://admin.yikids.com/admin/hospital_owner_management");
    }

    @Test
    public void HospitalOwnTest100() {
        hospOwnerManagPage.verify_LogOutLinkButtonIsPresent();

    }
   @Test
    public void checkingBoxesWithStatus100() {

       Log.info("Text element =" + hospOwnerManagPage.getText());
        hospOwnerManagPage. checkCheckbםxesStatus(30,"Owned");


    }


    @Test
    public void verifyAllSelectedCheckBoxesIsCheking100(){
        int check=10;
        hospOwnerManagPage.checkCheckboxes(check);
        assertTrue("Not All  Checkboxes are Checked", hospOwnerManagPage.isCheckedCheckboxes(check));

    }

    @Test
    public void checkSelectedCheckBoxesAccordingToStatus100(){
        int check=15;
        String status= "Owned";
        hospOwnerManagPage.checkNotAllCheckboxes(check,status);

        assertTrue("Not All Checkboxes with Status are Checked", hospOwnerManagPage.isCheckedNotAllCheckboxes(check,status));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();  }



}
