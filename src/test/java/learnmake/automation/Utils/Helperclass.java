package learnmake.automation.Utils;

import learnmake.automation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Helperclass extends AbstractPage {



    public Helperclass(WebDriver driver) {
        super(driver);
    }


    public static void proba (String nome){

        System.out.println("clase helper"+ nome);
    }

}
