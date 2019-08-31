package learnmake.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TinderStartPage extends AbstractPage {

    private static final String PAGE_HOME_URL = "https://www.tinder.com/";

    @FindBy(xpath = "//*[local-name()='svg']")
    private WebElement allowButton;

    @FindBy(xpath = "//div[2]/button[1]/span[contains(text(),'Facebook')]")
    private WebElement facebooklogin;

    public TinderStartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

    public void enterToFacebook (){

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(facebooklogin));
        facebooklogin.click();
    }

    public void allowGeolocalization(){
        
    }

}
