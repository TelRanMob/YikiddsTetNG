package YikidsTetNG.pages;
import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


/**
 * Created by Pereminski Tatiana on 6-05-2016.
 */
public class HospitalOwnerManagementPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    /*****
     private String login = "admin@erdocfinder.com";
     private String pass = "Test123";
     ****/
    //title links buttons
    @FindBy(xpath = "//*[@class='nav']/li[1]/a")
    WebElement overViewButton;

    @FindBy(xpath = "//*[@class='nav']/li[2]/a")
    WebElement physicianButton;

    @FindBy(xpath = "//*[@class='nav']/li[3]/a")
    WebElement recruiterButton;

    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalButton;

    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalAddHospitalButton;

    @FindBy(xpath = "//*[contains(text(),'Add Hospital')]")
    WebElement addHospitalButton;

    @FindBy(xpath = "//*[contains(text(),'Hospital Overview')]")
    WebElement hospitalOverviewButton;

    @FindBy(xpath = "//*[contains(text(),'Hospital Owner Management')]")
    WebElement hospitalOwnerManagementButton;

    //Find FieldText
    @FindBy(xpath ="//*[@id='recruiter_name']")
    WebElement recruiterName;

    @FindBy(xpath ="//*[@id='hospital_name']")
    WebElement hospitalName;

    @FindBy(xpath ="//*[@id='company_name']")
    WebElement companyName;

    //buttons
    @FindBy(xpath="//*[@id = 'show-all']")
    WebElement showAllButton;

    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement approveButton;

    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement deattachButton;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;


    //Find title  "Hospital Owner Management Page"
    @FindBy(xpath = "//div[@class='text-center']/h1")
    WebElement hospitalOwnerManagementTitle;

    //Find sub title  "Enter Recruiter Name, Hospital Name, Company Name to Search:"
    @FindBy(xpath = "//div[@class='text-center']/p[1]")
    WebElement enterRHCNamesToSearch;

    // Action
    @FindBy(xpath ="//*[@id='row0']/td[1]/input")
    WebElement firstCheckbox;

    //Status
    @FindBy(xpath ="//*[@id='row0']/td[9]")
    WebElement status;

    @FindBy(xpath ="//*[@id='row0']/td[9]")
    WebElement NotOwnedStatus;



    //constructor
    public HospitalOwnerManagementPage(WebDriver driver) {
        super(driver);
        Log.info("Opening Hospital Owner Management Page ");
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }


    public HospitalOwnerManagementPage openAdminPage() {
        Log.info("Opening SignUp page");
        driver.get("http://admin.yikids.com/");
        return this;
    }

    public HospitalOwnerManagementPage openHospitalOwnerManagementPage() {
        Log.info("Opening Hospital Owner Management Page ");
        driver.get("http://admin.yikids.com/admin/hospital_owner_management");
        return this;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    //Verify elements are present
    public boolean verify_PageHospOwnerManagementPageOpen() {
        Log.info("Check the 'Hospital Owner Management Page' title is present" );
        return verifyTextBoolean(hospitalOwnerManagementTitle,"Hospital Owner Management Page");
    }

    public boolean verify_LogOutLinkButtonIsPresent(){
        Log.info("Check the Log Out button is present");
        return verifyElementIsPresent(logOutButton);
    }
    public boolean verify_ShowAllButtonIsPresent(){
        Log.info("Check the Show All Button is present");
        return verifyElementIsPresent(showAllButton);}

    public void waitForHospitalOwnerManagementPageTitle()   {
        Log .info("Waiting for Hospital Owner Management Page Title is loaded");
        waitUntilIsLoaded(hospitalOwnerManagementTitle);
    }

    public void waitForLogOutLinkButton()   {
        Log .info("Waiting for Log Out Link Button is loaded");
        waitUntilIsLoaded(logOutButton);
    }

    public String getText() {
        return getTextElement(status);
    }

    public boolean CheckTextOfElementLogOut() {
        return verifyTextBoolean(logOutButton, "Log Out");
    }

    public boolean CheckElementButton() {
        return verifyElementIsPresent(deattachButton);
    }
    /***************************************************************************/
    //methods
    public HospitalOwnerManagementPage showAll(){
        Log.info("clicking on Show All Button");
        clickElement(showAllButton);
        return this;
    }
    public void waitForTableLoad() throws IOException, InterruptedException {
        Log.info("waiting for  Table is loaded");
        waitUntilElementIsLoaded(firstCheckbox);
    }

    public boolean verifyElemClicked(WebElement elem){
        elem.isSelected();
        return true;
    }

    /********************************************************************************************************************/
    public HospitalOwnerManagementPage goToHospitalOwnerManagment() {
        //Log.info(
        moveMouseOverElement(hospitalButton);
        moveMouseOverElement(hospitalOwnerManagementButton);
        clickElement(hospitalOwnerManagementButton);
        driver.get(PAGE_URL);
        return this;
    }

    public HospitalOwnerManagementPage goToHospitalAddHospital() {
        //Log.info(
        moveMouseOverElement(hospitalButton);
        moveMouseOverElement(addHospitalButton);
        clickElement(addHospitalButton);
        driver.get( "http://admin.yikids.com/hospital/add");
        return this;
    }

    /**********************************************************************************************************************/
//100
    public void checkCheckboxes(int Chec) {
        int rowNumber;

        for (rowNumber = 0; rowNumber < Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }
    //click checkboxes only with  required status 100
    public void checkCheckbםxesStatus(int Chec, String status ) {

        int rowNumber = 0;
        for (rowNumber = 0; rowNumber < Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";

            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            if (statusText.equals(status)) {

                String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
                WebElement box = driver.findElement(By.xpath(locator));
                box.click();
            }

        }
    }
    //Checking if all selected  checkboxes are checked in order 100
    public boolean isCheckedCheckboxes(int Chec) {
        int rowNumber, count = 0;
        boolean checked = false;
        for (rowNumber = 0; rowNumber <Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (box.isSelected()) {
                checked = true;
                count++;
            } else {
                checked = false;
                count--;
            }
        }
        if (count == Chec && checked == true) {
            checked= true;
        }
        return checked;
    }

    /**********************************************************************************************************************/
    //Checking only checkboxes rows with required status 100
    public void checkNotAllCheckboxes(int Chec,String status) {
        int rowNumber = 0;
        for (rowNumber = 0; rowNumber < Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (statusText.equalsIgnoreCase( status)) {
                box.click();
            }
        }
    }


    //Verify that Checking only checkboxes rows with required status 100
    public boolean isCheckedNotAllCheckboxes(int Chec,String status) {
        int rowNumber = 0;
        boolean flag=false;
        for (rowNumber = 0; rowNumber < Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (status.equalsIgnoreCase(statusText))
            {
                if (box.isSelected()) {
                    flag = true;
                }
                else
                    flag = false;
            }
        }
        return flag;
    }
    /**********************************************************************************************************************/


  /*  @FindBy(xpath = "//table")
    WebElement table;

    //Verify אtable loading rows sorting only by required Recruter Name
    public boolean isShowOnlyRequiredRecruterName(string RecName) {
        int rowNumber = 0;
        boolean flag=false;

        WebElement table;
        table = driver.findElement(By.xpath(String.valueOf(table)));
        Dimension rowsCount = table.s
        for (rowNumber = 0; !(rowNumber >= rowsCount); rowNumber++) {
            String recName = "//*[@id='row" + rowNumber + "']/td[2]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (status.equalsIgnoreCase(statusText))
            {
                if (box.isSelected()) {
                    flag = true;
                }
                else
                    flag = false;
            }
        }
        return flag;

*/
    public void waitForDeattachButtonIsLoaded() {
        try {
            waitUntilElementIsLoaded(deattachButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}