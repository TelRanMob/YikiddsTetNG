package YikidsTetNG.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


/**
 * Created by IrinaPrimak on 10-Apr-16.
 */
public class IrinaHospOwnerManagPage extends Page {
    public String PAGE_URL;

    //buttons
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement approveButton;

    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement deattachButton;

    @FindBy(id = "show-all")
    WebElement showAllButton;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@class='with-sub active']/a")
    WebElement hospitalLink;

    //title
    @FindBy(xpath = "//*[contains (text(),'Hospital Owner Management Page')]")
    WebElement hospitalOwnerManagementPageTitle;


    // Action
    @FindBy(xpath ="//*[@id='row0']/td[1]/input")
    WebElement firstCheckbox;



    public IrinaHospOwnerManagPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public IrinaHospOwnerManagPage goToHospitalOwnerManagment() {
        //Log.info(
       // moveMouseOverElement(hospitalLink);
        //moveMouseOverElement(hospitalOwnerManagementLink);
        //clickElement(hospitalOwnerManagementLink);
        driver.get(PAGE_URL);
        return this;
    }
    //checking checkboxes
    public void checkCheckbxes(int chec) {
        int rowNumber;
        for (rowNumber = 0; rowNumber <= chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }
    //method get number of all rows in the list
    public int numberOfChekbobxesInTheList() {
        int rowNumber=0;
         int rowsCounter = 0;
        do {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            rowNumber++;
            //WebElement box = driver.findElement(By.xpath(locator));
            if (verifyElementIsPresent(driver.findElement(By.xpath(locator))))
             rowsCounter++;
             }while (rowNumber!=rowsCounter);
           return rowsCounter;
    }
    //Checking only checkboxes of rows with selected status from all
    //Todo  verifications of method
    public void checkNumCheckbxesWithStususFromAll(int check, String status) {
        int rowNumber = 0;
        int selectedBoxes =0;
        int rowCounter = numberOfChekbobxesInTheList();
        do {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            if (statusText.equalsIgnoreCase(status)){
                String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
                WebElement box = driver.findElement(By.xpath(locator));
                box.click();
                if (box.isSelected()) selectedBoxes++;
            }
           rowNumber++;
        } while ((selectedBoxes<=check)&&(rowNumber<=rowCounter));
    }
    //Checking only checkboxes of rows with selected status
      public void checkNotAllCheckbxes(int chec, String status) {
        int rowNumber = 0;
        int selectedBoxes = 0;
          do {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            if (statusText.equalsIgnoreCase(status))
                for (rowNumber = 0; rowNumber <= chec; rowNumber++) {
                    String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
                    WebElement box = driver.findElement(By.xpath(locator));
                    box.click();
                    if (box.isSelected())
                        selectedBoxes ++;
                   }
           } while (selectedBoxes<=chec);
    }

    //method get the hole list of  Owner Management
    public IrinaHospOwnerManagPage showAll(){
        //log/
        clickElement(showAllButton);
        return this;
    }
    public void waitForTableLoad() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(firstCheckbox);
    }
    public boolean verifyElemClicked(WebElement elem){
        elem.isSelected();
        return true;
    }
    public void waitForhospitalOwnerManagementPageTitle()   {
        waitUntilIsLoaded(hospitalOwnerManagementPageTitle);
    }


    public boolean checkPageHospOwnerManagOpen() {
        return verifyTextBoolean(hospitalOwnerManagementPageTitle,
                "Hospital Owner Management Page");
    }
}
