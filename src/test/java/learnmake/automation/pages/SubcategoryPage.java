package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubcategoryPage extends AbstractPage {
    @FindBy(css = "[class] .Container__columns1:nth-of-type(1) [class='Heading__heading Heading__heading-3 Heading__aligned-inherit CategoryHeading__heading']")
    private WebElement firstElementButton;

    public SubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstElement() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(firstElementButton));
        firstElementButton.click();
    }

}
