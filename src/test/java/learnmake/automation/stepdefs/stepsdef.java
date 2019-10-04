package learnmake.automation.stepdefs;

import learnmake.automation.SharedContext;
import learnmake.automation.pages.HomePage;
import learnmake.automation.pages.SubcategoryPage;
import learnmake.automation.pages.VardagsrumPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import learnmake.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class stepsdef implements En {
    private WebDriver driver;
    private VardagsrumPage vardagsrumPage;
    private LoginPage loginPage;
    private SharedContext sharedContext;
    private HomePage homePage;
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
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
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
            homePage.acceptCookie();
        });
        Then("^I check I can click in the first Button$", () -> {
            subcategoryPage.clickFirstElement();
        });


    }
}
