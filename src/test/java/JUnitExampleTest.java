import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUnitExampleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void exampleTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").$(byText("Soft assertions")).shouldBe(visible);
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").scrollTo();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n"
                + "class Tests {\n" + "@Test\n" + "void test() {\n"
                + "Configuration.assertionMode = SOFT;\n"
                + "open(\"page.html\");\n" + "$(\"#first\").should(visible).click();\n"
                + "$(\"#second\").should(visible).click();\n"));
sleep(5000);
    }
}
