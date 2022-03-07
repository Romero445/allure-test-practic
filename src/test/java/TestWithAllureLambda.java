import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWithAllureLambda {

    private final static String REPOSITORY = "Romero445/allure-test-practic";
    private final static String ISSUES_NAME = "Hello world";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем страницу github", () -> {
            open("https://github.com");
        });
        step("Ищем нужный репозиторий "+REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Открываем репозиторий "+REPOSITORY, () -> {
            $(By.linkText("Romero445/allure-test-practic")).click();
        });
        step("Переходим в issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем наличие issues с названием "+ISSUES_NAME, () -> {
            $(withText(ISSUES_NAME)).should(Condition.exist);
        });
    }

}
