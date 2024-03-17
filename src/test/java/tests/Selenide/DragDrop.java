package tests.Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragDrop {
    @BeforeAll
    static void openHerokuapp() {
        //  Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void changingPlaces() {


        open("/drag_and_drop");
     SelenideElement element = $("#column-b");
        // actions().dragAndDropBy(element, 150, 150).perform();
         //actions().moveToElement($("#column-b")).clickAndHold()
                 //.moveToElement($("#column-a")).release().perform();

        actions().dragAndDrop($("#column-b"), $("#column-a")).build().perform();



        $("#column-a").shouldHave(text("B"));

        Configuration.holdBrowserOpen=true;


    }
}
