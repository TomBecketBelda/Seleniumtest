package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeTinderPage extends AbstractPage {

    @FindBy(xpath = "//button[3]/span/*[local-name()='svg'] [@class ='Scale(.8)']")
    private WebElement heartButton;

    public HomeTinderPage(WebDriver driver) {
        super(driver);
    }

    public void pressTinderButton(){


        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(heartButton));
        heartButton.click();
    }

}
