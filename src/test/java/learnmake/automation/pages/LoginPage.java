package learnmake.automation.pages;

import learnmake.automation.Utils.Helperclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class LoginPage extends AbstractPage {

    @FindBy(id ="email")
    private WebElement emailButton;

    @FindBy(id = "pass")
    private  WebElement passwordButton;

    @FindBy(name = "q")
    private WebElement selectFieldTom;

    @FindBy(id="loginbutton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void inputMailandPassword(String email, String password){

        Set Handles = getDriver().getWindowHandles();
        getDriver().switchTo().window((String) Handles.toArray()[1]);
        emailButton.sendKeys(email);
        passwordButton.sendKeys(password);
        loginButton.click();
        getDriver().switchTo().window((String) Handles.toArray()[0]);




    }


}
