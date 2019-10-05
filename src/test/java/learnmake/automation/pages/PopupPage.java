package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends AbstractPage {

   @FindBy(className ="CookieBar__accept" )
   private WebElement cookieBarButton;

    public PopupPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookie(){
        cookieBarButton.click();
    }

}
