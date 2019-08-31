package learnmake.automation.stepdefs;

import learnmake.automation.SharedContext;
import learnmake.automation.pages.HomeTinderPage;
import learnmake.automation.pages.TinderStartPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import learnmake.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class stepsdef implements En {
    private WebDriver driver;
    private TinderStartPage tinderStartPage;
    private LoginPage loginPage;
    private SharedContext sharedContext;
    private HomeTinderPage homeTinderPage;

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
        Before(new String[]{"@Tinder"}, 0, 10, (Scenario scenario) -> {
            tinderStartPage = new TinderStartPage(driver);
            loginPage = new LoginPage(driver);
            homeTinderPage = new HomeTinderPage(driver);

        });

        After(new String[]{"@web"}, (Scenario scenario) -> {
            this.sharedContext.tearDown();
        });


        Given("^I enter in the app and  register with facebook$", () -> {
            tinderStartPage.navigateToHomePage();
            tinderStartPage.enterToFacebook();
        });
        When("^I write (.*) and (.*)$", (String email, String password) -> {

            loginPage.inputMailandPassword(email,password);

        });
        Then("^I press I like Button$", () -> {


            homeTinderPage.pressTinderButton();
        });
        And("^I accept geolocalization$", () -> {
            tinderStartPage.allowGeolocalization();
        });


    }
}
