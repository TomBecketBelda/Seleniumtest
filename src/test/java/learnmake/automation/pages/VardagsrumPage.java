package learnmake.automation.pages;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(css = ".CategoryView__heading.Heading__aligned-inherit.Heading__heading.Heading__heading-1")
    private WebElement headingCategory;

    @FindBy(css = "[class='Heading__heading Heading__heading-2 Heading__aligned-inherit']")
    private WebElement subheadingCategory;

    @FindBy(css = "[data-page] .ProductTile__firstWord")
    private WebElement firstArticle;

    @FindBy(css = "li:nth-of-type(1) > div[role='option']")
    private WebElement showMoreButton;

    @FindBy(css = ".Expandable__showDropdown [data-purpose='facetList\\.facetItem']:nth-of-type(1) .FacetItem__title")
    private  WebElement  bestPriceCheckbox;

    @FindBy (css="li:nth-of-type(1) > .Chip__container.Chip__removable > .Chip__remove")
    private WebElement firstTagButton;

    // Variables to compare the values of the first page

    private String titleVardagsrum;
    private String subtitleVardagsrum;
    private String firstArticleVardagsrum;

    /*
    TODO CHANGE WHEN PREVIOUS COMPARE IS SOLVED BY THE DEVELOPER
     private String pageHomeValuesTitle;
    */

    public VardagsrumPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }

    public void selectCategory(String position) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        switch (position) {
            case "Soffor":
                js.executeScript("arguments[0].scrollIntoView();", svgSofforButton);
                svgSofforButton.click();
                break;
            case "Mediaforvaring":
                js.executeScript("arguments[0].scrollIntoView();", svgMediaforvaringButton);
                svgMediaforvaringButton.click();
                break;
            case "Mediamobler":
                js.executeScript("arguments[0].scrollIntoView();", svgMediamoblerButton);
                svgMediamoblerButton.click();
                break;
            case "Vardagsrumsbord":
                js.executeScript("arguments[0].scrollIntoView();", svgVardagsrumsbordButton);
                svgVardagsrumsbordButton.click();
                break;
            case "Vardagsrumsforvaring":
                js.executeScript("arguments[0].scrollIntoView();", svgVardagsrumsforvaringButton);
                svgVardagsrumsforvaringButton.click();
                break;
            case "Hyllor":
                js.executeScript("arguments[0].scrollIntoView();", svgHyllorButton);
                svgHyllorButton.click();
                break;
            case "Rumsavdelare":
                js.executeScript("arguments[0].scrollIntoView();", svgRumsavdelareButton);
                svgRumsavdelareButton.click();
                break;

            case "Smamobler":
                js.executeScript("arguments[0].scrollIntoView();", svgSmamoblerButton);
                svgSmamoblerButton.click();
                break;
            default:
                LOGGER.log(Level.INFO, "You didn't selected any category");

        }

    }

    public void iCheckThePageValuesFirstTime() {
        titleVardagsrum = headingCategory.getText();
        subtitleVardagsrum = subheadingCategory.getText();

    /*
    TODO CHANGE WHEN PREVIOUS COMPARE IS SOLVED BY THE DEVELOPER
     pageHomeValuesTitle = getDriver().getPageSource();
     This part of code is used to compare all the category page. I would rather to
     avoid this step because the previous assert ( the assert of the subtitle fails)
    */

    }

    public void checkTheoldAndNewHomepageValues() {
        Assert.assertEquals(titleVardagsrum, headingCategory.getText());
        Assert.assertEquals(subtitleVardagsrum, subheadingCategory.getText());
    /*
    TODO CHANGE WHEN PREVIOUS COMPARE IS SOLVED BY THE DEVELOPER
     Assert.assertEquals(pageHomeValuesTitle,getDriver().getPageSource());
     This part of code is used to compare all the category page. I would rather to
     avoid this step because the previous assert ( the assert of the subtitle) fails
    */
    }

    public void checkFirstElementArticle() {
        firstArticleVardagsrum = firstArticle.getText();
    }

    public void showMore() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", showMoreButton);
        showMoreButton.click();

    }

    public void bestPriceCheckBoxClick(){
        bestPriceCheckbox.click();
    }

    public void checkFirstElementArticleChanged(){
        Assert.assertNotEquals(firstArticleVardagsrum,firstArticle.getText());
    }

    public void iCheckoutThefirsttag (){
        firstTagButton.click();
    }

    public void checkFirstElementArticleNotChanged(){
        Assert.assertEquals(firstArticleVardagsrum,firstArticle.getText());
    }

}
