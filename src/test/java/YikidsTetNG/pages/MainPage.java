package YikidsTetNG.pages;

import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Irina Primak on 06-Apr-16.
 */
public class MainPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    // /fields // TODO: find real locator
    @FindBy(xpath = "//*[@class='with-sub active']/a")
    WebElement hospitalLink;

    @FindBy(xpath = "//*[@class='with-sub active']//*[contains(text(),'Add Hospital')]")
    WebElement addHospitalLink;
    //http://admin.yikids.com/hospital/add

    // links
    @FindBy(xpath ="//div[@id='logout-container']/a")
            //"http://admin.yikids.com/logout")
            WebElement logOutLink;

    //buttons
    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalButton;

    @FindBy(xpath = "//*[contains(text(),'Add Hospital')]")
    WebElement addHospitalButton;

    //constructor
    public MainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital-overview";
        PageFactory.initElements(driver, this);
    }

    public MainPage openAdminMainPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

   /* public MainPage goToAddHospital() {
        //Log.info("Clicking Add Hospital");
        moveMouseOverElement(hospitalLink);
        moveMouseOverElement(addHospitalLink);
        clickElement(addHospitalLink);

        return this;
        }
    */
   /*public MainPage goToAddHospital() {
            //Log.info("Add Hospitallpage");
           driver.get(PAGE_URL);
           return this;
    */

    public void waitForMainPageLoad() throws IOException, InterruptedException {
       waitUntilElementIsLoaded(hospitalLink);
    }

    public void waitForLogoutSign()
    {
        waitUntilIsLoaded(logOutLink);
    }

    public boolean isOnMainPage() {
        waitForLogoutSign();
        return exists(logOutLink);
    }
    public MainPage clickHospitalButton() {
        Log.info("Click signUp button");
        clickElement(hospitalButton);
        return this;
    }
    public MainPage clickAddHospitalButton() {
        Log.info("Click signUp button");
        clickElement(addHospitalButton);
        return this;
    }
    public MainPage goToAddHospitalPage(){
        Log.info("Go to AddHospital page");
        moveMouseOverElement(hospitalButton);
        clickHospitalButton();
        moveMouseOverElement(addHospitalButton);
        clickAddHospitalButton();
        return this;
    }
}
