import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class TestSteps {

    PageSteps PageSteps = new PageSteps();

    private final static String REPOSITORY = "Romero445/allure-test-practic";
    private final static String ISSUES_NAME = "Hello world";

    @Test
    public void testAllureAnnotatedSteps(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        PageSteps.openPage()
                .searchRepository(REPOSITORY)
                .openRepository(REPOSITORY)
                .openIssue()
                .shouldSeeIssueWithName(ISSUES_NAME);
    }
}


