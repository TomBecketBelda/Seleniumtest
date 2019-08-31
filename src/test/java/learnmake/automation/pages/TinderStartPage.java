package learnmake.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

public class TinderStartPage extends AbstractPage {

    private static final String PAGE_HOME_URL = "https://www.tinder.com/";
    private static final By BY_SEARCH_FIELD = By.name("q");

    @FindBy(xpath = "//div[2]/button[1]")
    private WebElement facebooklogin;

    public TinderStartPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

    public void enterToFacebook (){
        facebooklogin.click();
    }

}
