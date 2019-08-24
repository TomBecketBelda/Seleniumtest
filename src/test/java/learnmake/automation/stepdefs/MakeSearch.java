package learnmake.automation.stepdefs;

import learnmake.automation.SharedContext;
import learnmake.automation.pages.GooglePage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import learnmake.automation.pages.NewPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeSearch implements En {
    private WebDriver driver;
    private GooglePage searchPage;
    private NewPage newpage;
    private SharedContext sharedContext;

    // Warning: Make sure the timeouts for hooks using a web driver are zero

    // NOTE: picocontainer injects SharedContext
    public MakeSearch(SharedContext sharedContext) {
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
        Before(new String[]{"@google"}, 0, 10, (Scenario scenario) -> {
            searchPage = new GooglePage(driver);
            newpage = new NewPage(driver);
        });

        After(new String[]{"@web"}, (Scenario scenario) -> {
            this.sharedContext.tearDown();
        });

        Given("^a web browser is on the search engine page$", () -> {
            searchPage.navigateToHomePage();
        });
        When("^the search phrase \"([^\"]*)\" is entered$", (String phrase) -> {
            searchPage.enterSearchPhrase(phrase);
        });
        Then("^results for \"([^\"]*)\" are shown$", (String phrase) -> {
            assertThat(searchPage.pageTitleContains(phrase)).isTrue();
        });
        And("^I write a text$", () -> {
            newpage.writetext();
        });
    }
}
