package tests;

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
    void changingPlacesTest1() {


        open("/drag_and_drop");

        //Change place
        actions().moveToElement($("#column-b")).clickAndHold()
                .moveToElement($("#column-a")).release().perform();

        //Сheck results
        $("#column-a").shouldHave(text("B"));


    }

    @Test
    void changingPlacesTest2() {


        open("/drag_and_drop");

        //Change place

        actions().dragAndDrop($("#column-b"), $("#column-a")).build().perform();

        //Сheck results

        $("#column-b").shouldHave(text("A"));

        Configuration.holdBrowserOpen = true;


    }
}
