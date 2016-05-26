package YikidsTetNG.pages;

import YikidsTetNG.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by rut on 04.05.2016.
 */
public class AddHospitalPage extends Page{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //fields
    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "county")
    WebElement countryField;

    @FindBy(id = "zip")
    WebElement zipCodeField;

    @FindBy(id = "phnnum")
    WebElement phoneNumberField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "type")
    WebElement typeOfFacilityField;

    @FindBy(id = "otherinfo")
    WebElement otherInfoField;

    //dropdowns

    @FindBy(id = "state")
    WebElement stateFieldDropdown;

    @FindBy(id = "er")
    WebElement haveAnERDropdown;

    //checkboxes

    @FindBy(id = "recstatus")
    WebElement recrutingStatusCheckbox;

    @FindBy(id = "tier1or2")
    WebElement tierCheckbox;

    @FindBy(id = "academic")
    WebElement academicCheckbox;

    @FindBy(id = "cmpsn200plus")
    WebElement cmpsn200PlusCheckbox;

    @FindBy(id = "cme")
    WebElement cmeCompensationCheckbox;

    @FindBy(id = "mjdblcvg")
    WebElement majorDoubleCoverageCheckbox;

    @FindBy(id = "mdlvlcvg")
    WebElement mdlvlcvgCheckbox;

    @FindBy(id = "emr")
    WebElement emrCheckbox;

    @FindBy(id = "noihcdcvg")
    WebElement noihcdcvgCheckbox;

    @FindBy(id = "noadmordrs")
    WebElement noadmordrsCheckbox;

    @FindBy(id = "prisnglcvg")
    WebElement prisnglcvgCheckbox;

    @FindBy(id = "anystlic")
    WebElement anystlicCheckbox;

    @FindBy(id = "reprentation")
    WebElement reprentationCheckbox;

    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalButton;

    //messages

    @FindBy(id = "//span[@class='help-block form-error']")
    WebElement errorZipMessage;
//    Please enter a valid zipcode

    @FindBy(xpath = "//*[@id='errorsList']/li")
    WebElement errorNameMessage;
//    The name must be at least 5 characters.

    //buttons

    @FindBy(xpath = "//input[@type='submit']")
    WebElement saveButton;

    public AddHospitalPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/hospital/add";
        PageFactory.initElements(driver, this);
    }

    public AddHospitalPage openHospitalMenu() {
        Log.info("Moving mouse over Hospital menu point");
        moveMouseOverElement(hospitalButton);
        return this;
    }
    public AddHospitalPage openAddHospitalPage() {
        Log.info("Opening AddHospitalPage page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields

    public AddHospitalPage fillNameField(String name) {
        Log.info("Filling name field");
        setElementText(nameField, name);
        return this;
    }
    public AddHospitalPage fillAddresssField(String address) {
        Log.info("Filling address field");
        setElementText(addressField, address);
        return this;
    }
    public AddHospitalPage fillCityField(String city) {
        Log.info("Filling city field");
        setElementText(cityField, city);
        return this;
    }
    public AddHospitalPage fillCountryField(String country) {
        Log.info("Filling country field");
        setElementText(countryField, country);
        return this;
    }
    public AddHospitalPage fillZipCodeField(String zipCode) {
        Log.info("Filling zipCode field");
        setElementText(zipCodeField, zipCode);
        return this;
    }
    public AddHospitalPage fillPhoneNumberField(String phoneNumber) {
        Log.info("Filling phoneNumber field");
        setElementText(phoneNumberField, phoneNumber);
        return this;
    }
    public AddHospitalPage fillEmailField(String email) {
        Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }
    public AddHospitalPage fillTypeOfFacilityField(String typeOfFacility) {
        Log.info("Filling typeOfFacility field");
        setElementText(typeOfFacilityField, typeOfFacility);
        return this;
    }
    public AddHospitalPage fillOtherInfoField(String otherInfo) {
        Log.info("Filling otherInfo field");
        setElementText(otherInfoField, otherInfo);
        return this;
    }

    //Select in Dropdown

    public AddHospitalPage selectStateInDropdown(String state){
        Log.info("Selecting state in dropdown");
        selectValueInDropdownbyText(stateFieldDropdown,state);
        return this;
    }
    public AddHospitalPage selectHaveAnERInDropdown(String haveAnER){
        Log.info("Selecting haveAnER in dropdown");
        selectValueInDropdownbyText(haveAnERDropdown,haveAnER);
        return this;
    }

    //Check the checkboxes

    public AddHospitalPage checkRecrutingStatusCheckbox(){
        Log.info("Clicking on recrutingStatusCheckbox");
        clickElement(recrutingStatusCheckbox);
        return this;
    }
    public AddHospitalPage checkTierCheckbox(){
        Log.info("Clicking on tierCheckbox");
        clickElement(tierCheckbox);
        return this;
    }
    public AddHospitalPage checkAcademicCheckbox(){
        Log.info("Clicking on academicCheckbox");
        clickElement(academicCheckbox);
        return this;
    }
    public AddHospitalPage checkCmpsn200PlusCheckbox(){
        Log.info("Clicking on cmpsn200PlusCheckbox");
        clickElement(cmpsn200PlusCheckbox);
        return this;
    }
    public AddHospitalPage checkCmeCompensationCheckbox(){
        Log.info("Clicking on cmeCompensationCheckbox");
        clickElement(cmeCompensationCheckbox);
        return this;
    }
    public AddHospitalPage checkMajorDoubleCoverageCheckbox(){
        Log.info("Clicking on majorDoubleCoverageCheckbox");
        clickElement(majorDoubleCoverageCheckbox);
        return this;
    }
    public AddHospitalPage checkMdlvlcvgCheckbox(){
        Log.info("Clicking on mdlvlcvgCheckbox");
        clickElement(mdlvlcvgCheckbox);
        return this;
    }
    public AddHospitalPage checkEmrCheckbox(){
        Log.info("Clicking on emrCheckbox");
        clickElement(emrCheckbox);
        return this;
    }
    public AddHospitalPage checkNoihcdcvgCheckbox(){
        Log.info("Clicking on noihcdcvgCheckbox");
        clickElement(noihcdcvgCheckbox);
        return this;
    }
    public AddHospitalPage checkNoadmordrsCheckbox(){
        Log.info("Clicking on noadmordrsCheckbox");
        clickElement(noadmordrsCheckbox);
        return this;
    }
    public AddHospitalPage checkPrisnglcvgCheckbox(){
        Log.info("Clicking on prisnglcvgCheckbox");
        clickElement(prisnglcvgCheckbox);
        return this;
    }
    public AddHospitalPage checkAnystlicCheckbox(){
        Log.info("Clicking on anystlicCheckbox");
        clickElement(anystlicCheckbox);
        return this;
    }
    public AddHospitalPage checkReprentationCheckbox(){
        Log.info("Clicking on reprentationCheckbox");
        clickElement(reprentationCheckbox);
        return this;
    }

    public AddHospitalPage clickToSave(){
        Log.info("Clicking on saveButton");
        clickElement(saveButton);
        return this;
    }

    //Check error message

    public boolean checkErrorZipMessage() {
        Log.info("Checking Zip code error message");
        return verifyTextBoolean(errorZipMessage, "Please enter a valid zipcode");
    }

    //Wait for warning

    public void waitForErrorZipWarning() {
        Log.info("Waiting for Zip code error message");
        waitUntilIsLoaded(errorZipMessage);
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }
    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        Log.info("User's Email generated is <" + username + ">");
        return username;
    }

    public AddHospitalPage fillAddHospitalProfile(){
        Log.info("Filling all fields");

        openAddHospitalPage();
        checkRecrutingStatusCheckbox();
        fillNameField("name");
        fillAddresssField("address");
        fillCityField("city");
        fillCountryField("country");
        fillZipCodeField("00501");
        fillPhoneNumberField("0521111111");
        fillEmailField("username");
        fillTypeOfFacilityField("type");
        selectStateInDropdown("Alabama");
        selectHaveAnERInDropdown("True");
        checkTierCheckbox();
        checkAcademicCheckbox();
        checkCmpsn200PlusCheckbox();
        checkCmeCompensationCheckbox();
        checkMajorDoubleCoverageCheckbox();
        checkMdlvlcvgCheckbox();
        checkEmrCheckbox();
        checkNoihcdcvgCheckbox();
        checkNoadmordrsCheckbox();
        checkPrisnglcvgCheckbox();
        checkAnystlicCheckbox();
        checkReprentationCheckbox();
        fillOtherInfoField("text");
        clickToSave();

        return this;
    }
}