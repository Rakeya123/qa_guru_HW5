package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class FindEnterprizeTest {
    @BeforeAll
    static void openGitHab() {
        //  Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void openPage() {


        open("/");
// Open Enterprise
        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$$("li").findBy(text("Enterprise")).click();
//Open right page
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered")).shouldHave(visible);

        Configuration.holdBrowserOpen=true;
    }
}

