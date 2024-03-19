package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest {
    @BeforeAll
    static void openHerokuapp() {
        Configuration.browserSize = "1920x1080";
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

        //Change place 2

        $("#column-b").dragAndDrop(to("#column-a"));

        //Сheck results 2

        $("#column-b").shouldHave(text("A"));



    }
}
