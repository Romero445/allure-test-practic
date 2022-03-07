import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageSteps {

    @Step("Открываем страницу github")
    public PageSteps openPage(){
        open("https://github.com");

        return this;
    }
    @Step("Ищем нужный репозиторий {repo}")
    public PageSteps searchRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

        return this;
    }
    @Step("Открываем репозиторий {repo}")
    public PageSteps openRepository(String repo){
        $(By.linkText(repo)).click();

        return this;
    }
    @Step("Переходим в issues")
    public PageSteps openIssue(){
        $(By.partialLinkText("Issues")).click();

        return this;
    }
    @Step("Проверяем наличие issues с названием {name}")
    public PageSteps shouldSeeIssueWithName(String name){
        $(withText(name)).should(Condition.exist);

        return this;
    }
}
