package YikidsTetNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Irina Primak on 06-Apr-16.
 */
public class IrinaMainPage extends Page {


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

    //constructor
    public IrinaMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital-overview";
        PageFactory.initElements(driver, this);
    }

    public IrinaMainPage openAdminMainPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

   /* public IrinaMainPage goToAddHospital() {
        //Log.info("Clicking Add Hospital");
        moveMouseOverElement(hospitalLink);
        moveMouseOverElement(addHospitalLink);
        clickElement(addHospitalLink);

        return this;
        }
    */
   /*public IrinaMainPage goToAddHospital() {
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
}
