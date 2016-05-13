package YikidsTetNG;

import YikidsTetNG.pages.AddHospitalPage;
import YikidsTetNG.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by rut on 05.05.2016.
 */
public class AddHospitalTest extends TestNgTestBase{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public AddHospitalPage addHospitalPage;
    public LoginPage loginPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        addHospitalPage = PageFactory.initElements(driver, AddHospitalPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        driver.get("http://admin.yikids.com");
        loginPage.waitForloginButton();

    }
    @Test
//    Log.info(""
    public void addHospitalPositiveTest() throws InterruptedException {
        Thread.sleep(3000);
        addHospitalPage.openHospitalMenu();
        Thread.sleep(7000);
}
}