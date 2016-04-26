package YikidsTetNG.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */



 // public static String baseUrl = TestNgTestBase.baseUrl;
  public String PAGE_URL;
  public String PAGE_TITLE;
  public WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }


  public void goBackBrowserButton() {
    driver.navigate().back();
  }

  public void goForwardBrowserButton() {
    driver.navigate().forward();
  }

  public void reloadPage() {
    driver.navigate().refresh();
  }


  public String getTitle() {
    return driver.getTitle();
  }

  public String getPageUrl() {

    return PAGE_URL;
  }

  public String getPageTitle() {
    return PAGE_TITLE;
  }

  public void loadPage() {
    driver.get(getPageUrl());
//  Assert.assertEquals(getTitle(), getPageTitle());
  }


  public void setElementText(WebElement element, String text) {
    element.click();
    element.clear();
    //Log.info("entering text '" + text + "' into element " + element);
    element.sendKeys(text);
    // Assert.assertEquals(element.getAttribute("value"), text);
        }


    public void clickElement(WebElement element) {
    // Log.info("clicking on element " + element + "");
    element.click();
  }

  public void waitUntilIsLoadedCustomTime(WebElement element, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void waitUntilIsLoaded(WebElement element) {
    try {
      new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      // Log.info("---------------------------------");
      // Log.info("element " + element + " can not be found by ExpectedConditions.visibilityOf(element)");
      //  Log.info("---------------------------------");
      e.printStackTrace();
    }
  }

  // public void selectValueInDropdown(WebElement dropdown, String value) {
  //   Select select = new Select(dropdown);
  //  select.selectByValue(value);
  // }

  // Returns label that we chose
  public String selectValueInDropdown(WebElement dropdown, String value) {
    Select select = new Select(dropdown);
    select.selectByValue(value);
    WebElement option = select.getFirstSelectedOption(); // Chooses label that fits the value
    return option.getText();
  }

  public void selectValueInDropdownbyText(WebElement dropdown, String value) {
    Select select = new Select(dropdown);
    select.selectByVisibleText(value);

  }

  public boolean verifyElementIsPresent(WebElement element) {
    try {
      element.getTagName();
      return true;
    } catch (NoSuchElementException e) {
      //  Log.info("---------------------------------");
      //  Log.info("element " + element + " can not be found by  element.getTagName()");
      //   Log.info("---------------------------------");
      return false;
    }
  }

  public void verifyText(WebElement element, String text) {
    try {
      Assert.assertEquals(text, element.getText());
    } catch (Error e) {

    }
  }


    public boolean verifyTextBoolean(WebElement element, String text) {
   //   Log.info("verifying that text from element " + element + " - ('" + element.getText() + "') - is equal to text '" + text + "'");
    return text.equals(element.getText());
  }


  public boolean verifyTextBooleanInDropDown(String label, String chosenOption) {
    return chosenOption.equals(label);
  }

  public boolean exists(WebElement element) {
    try {
      return element.isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException ignored) {
      return false;
    }
  }



  public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
  }

  public void waitUntilElementIsDisappeared (String id) throws IOException, InterruptedException {
    new WebDriverWait(driver, 25).until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
  }

  public void moveMouseOverElement(WebElement element) {
    String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";


    ((JavascriptExecutor) driver).executeScript(javaScript, element);
  }
  public void waitForElement(WebDriverWait wait, String element) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
  }

  protected boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
      //  Log.info("----------ALERT-----------------");
      //  Log.info("element " + by + " can not be found by ExpectedConditions.visibilityOf(element)");
      //  Log.info("---------ALERT------------------");
      return false;
    }
  }

  // Pay attention: Works Only for first cell
  public boolean IsCellGreenAfterClick(WebElement locator) {
    clickElement(locator);
    // Is it Green?
    return "#008000".equals(Color.fromString(locator.getCssValue("background-color")).asHex());
  }

  public boolean IsCellColorChangedAfterClick(WebElement cell) {
    String cellColorBeforeClick = Color.fromString(cell.getCssValue("background-color")).asHex();
    clickElement(cell);
    String cellColorAfterClick = Color.fromString(cell.getCssValue("background-color")).asHex();
    return !cellColorBeforeClick.equals(cellColorAfterClick);
  }
    public String getTextElement(WebElement element) {

        String text_elemen;
        text_elemen = element.getText();

        return text_elemen;
    }

    public void pressEnter() {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.RETURN).keyUp(Keys.RETURN).build().perform();
    }


}
