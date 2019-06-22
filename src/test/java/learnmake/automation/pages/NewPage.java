package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;

public class NewPage extends AbstractPage {
    public NewPage(WebDriver driver) {
        super(driver);
    }

    public void writetext (){
        System.out.println("write a new step");
    }
}
