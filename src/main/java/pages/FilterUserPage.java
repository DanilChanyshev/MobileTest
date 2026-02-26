package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import jakarta.inject.Inject;

public class FilterUserPage extends AbsBasePage {

  @Inject
  private UsersMenuPage usersMenuPage;

  private final SelenideElement title = $(AppiumBy.id("ru.otus.wishlist:id/filter_title"));
  private final SelenideElement inputFieldName = $(AppiumBy.id("ru.otus.wishlist:id/username_input"));
  private final SelenideElement okButton = $(AppiumBy.id("ru.otus.wishlist:id/apply_button"));

  public FilterUserPage assertTitle() {
    title
        .shouldBe(visible)
        .shouldHave(Condition.text("Фильтры"));
    return this;
  }

  public UsersMenuPage sendUserByName(String name) {
    inputFieldName
        .shouldBe(visible)
        .sendKeys(name);
    okButton
        .shouldBe(visible)
        .click();
    return usersMenuPage;
  }
}
