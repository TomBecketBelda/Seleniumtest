package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

   @FindBy(className ="CookieBar__accept" )
   private WebElement cookieBarButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookie(){
        cookieBarButton.click();
    }

}
