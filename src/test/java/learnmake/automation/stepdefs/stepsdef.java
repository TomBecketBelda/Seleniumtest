package learnmake.automation.stepdefs;

import learnmake.automation.SharedContext;
import learnmake.automation.pages.PopupPage;
import learnmake.automation.pages.SubcategoryPage;
import learnmake.automation.pages.VardagsrumPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class stepsdef implements En {
    private WebDriver driver;
    private VardagsrumPage vardagsrumPage;
    private SharedContext sharedContext;
    private PopupPage popupPage;
    private SubcategoryPage subcategoryPage;

    // Warning: Make sure the timeouts for hooks using a web driver are zero

    // NOTE: picocontainer injects SharedContext
    public stepsdef(SharedContext sharedContext) {
        this.sharedContext = sharedContext;

        Before(new String[]{"@web"}, 0, 1, (Scenario scenario) -> {
            this.sharedContext.setUp();
        });

        Before(new String[]{"@web", "@chrome"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("chrome");
        });
        Before(new String[]{"@web", "@firefox"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("firefox");
        });
        Before(new String[]{"@xxxLutz"}, 0, 10, (Scenario scenario) -> {
            vardagsrumPage = new VardagsrumPage(driver);
            popupPage = new PopupPage(driver);
            subcategoryPage = new SubcategoryPage(driver);
        });

        After(new String[]{"@web"}, (Scenario scenario) -> {
            this.sharedContext.tearDown();
        });

        Given("^I enter in the app with sweden language", () -> {
            vardagsrumPage.navigateToHomePage();
        });

        When("^I select the (.*) category$", (String position) -> {
            vardagsrumPage.selectCategory(position);
        });
        And("^I accept cookie$", () -> {
            popupPage.acceptCookie();
        });
        Then("^I check I can click in the first Button of the subcategory$", () -> {
            subcategoryPage.clickFirstElement();
        });
        And("^I check the category page values$", () -> {
            vardagsrumPage.iCheckThePageValuesFirstTime();
        });
        And("^I return to category from the submenu$", () -> {
            subcategoryPage.iclickReturnToPreviousPage();
        });
        And("^I check if the values of the categorypage have changed$", () -> {
            vardagsrumPage.checkTheoldAndNewHomepageValues();
        });
        And("^I check the the first element of article's list$", () -> {
            vardagsrumPage.checkFirstElementArticle();
        });
        And("^I click the  show more criteria submenu$", () -> {
            vardagsrumPage.showMore();
        });
        And("^I click best price check box$", () -> {
            vardagsrumPage.bestPriceCheckBoxClick();
        });
        And("^I check if the first article has changed$", () -> {
            vardagsrumPage.checkFirstElementArticleChanged();
        });
        And("^I checkout first tag label.remove all$", () -> {
            vardagsrumPage.iCheckoutThefirsttag();
        });
        Then("^I check if the first article is equal as no filters status$", () -> {
            vardagsrumPage.checkFirstElementArticleNotChanged();
        });


    }
}
