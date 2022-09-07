package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.$x;

public class BaseStep {
    private final SelenideElement searchField = $x("//input[@id='twotabsearchtextbox']");

    @Given("Open page {string}")
    public void openPage(String url) {
        Configuration.timeout = 10000;
        Selenide.open(url);
    }

    @AfterAll
    public static void tearDown(){
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().quit();
    }

    @And("Wait to active search field")
    public void waitToActiveSearchField() {
        searchField.shouldBe(Condition.enabled);
    }
}
