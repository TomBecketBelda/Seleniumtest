package learnmake.automation.pages;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VardagsrumPage extends AbstractPage {

    private final static Logger LOGGER = Logger.getLogger("get info level");

    private static final String PAGE_HOME_URL = "https://www.xxxlutz.se/vardagsrum-C1/";

    @FindBy(css = "[class] .Container__columns1:nth-of-type(1) [role]")
    private WebElement svgSofforButton;


    @FindBy(css = "[class] .Container__columns1:nth-of-type(2) [role]")
    private WebElement svgMediaforvaringButton;

    @FindBy(css = "[class] .Container__columns1:nth-of-type(3) [role]")
    private WebElement svgMediamoblerButton;


    @FindBy(css = "[class] .Container__columns1:nth-of-type(4) [role]")
    private WebElement svgVardagsrumsbordButton;


    @FindBy(css = "[class] .Container__columns1:nth-of-type(5) [role]")
    private WebElement svgVardagsrumsforvaringButton;

    @FindBy(css = "[class] .Container__columns1:nth-of-type(6) [role]")
    private WebElement svgSmamoblerButton;

    @FindBy(css = "[class] .Container__columns1:nth-of-type(7) [role]")
    private WebElement svgHyllorButton;

    @FindBy(css = "[class] .Container__columns1:nth-of-type(8) [role]")
    private WebElement svgRumsavdelareButton;


    public VardagsrumPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

    public void enterToFacebook (){
/*
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(facebooklogin));
        facebooklogin.click();
   */
    }

    public void  selectCategory (String position){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        switch(position) {
            case "Soffor" :
                js.executeScript("arguments[0].scrollIntoView();",svgSofforButton);
                svgSofforButton.click();
                break;
            case "Mediaforvaring" :
                js.executeScript("arguments[0].scrollIntoView();",svgMediaforvaringButton);
                svgMediaforvaringButton.click();
                break;
            case "Mediamobler" :
                js.executeScript("arguments[0].scrollIntoView();",svgMediamoblerButton);
                svgMediamoblerButton.click();
                break;
            case "Vardagsrumsbord" :
                js.executeScript("arguments[0].scrollIntoView();",svgVardagsrumsbordButton);
                svgVardagsrumsbordButton.click();
                break;
            case  "Vardagsrumsforvaring":
                js.executeScript("arguments[0].scrollIntoView();",svgVardagsrumsforvaringButton);
                svgVardagsrumsforvaringButton.click();
                break;
            case "Hyllor":
                js.executeScript("arguments[0].scrollIntoView();",svgHyllorButton);
                svgHyllorButton.click();
                break;
            case "Rumsavdelare":
                js.executeScript("arguments[0].scrollIntoView();",svgRumsavdelareButton);
                svgRumsavdelareButton.click();
                break;

            case "Smamobler":
                js.executeScript("arguments[0].scrollIntoView();",svgSmamoblerButton);
                svgSmamoblerButton.click();
                break;
            default:
                LOGGER.log(Level.INFO,"not catgory selected");

        }

    }




}
