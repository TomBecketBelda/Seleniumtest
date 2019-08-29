package learnmake.automation.pages;

import learnmake.automation.Utils.Helperclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewPage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement selectFieldTom;

    public NewPage(WebDriver driver) {
        super(driver);
    }

    public void writetext(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(selectFieldTom));
        selectFieldTom.clear();
        selectFieldTom.sendKeys("test tom selenium one");
        selectFieldTom.submit();

        Helperclass.proba("new");
    }


}
