package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class UsersMenuItem extends AbsComponents<UsersMenuItem> {


  public UsersMenuItem(SelenideElement root) {
    super(root);
  }

  private final SelenideElement item = $(AppiumBy.id("ru.otus.wishlist:id/user_item"));
  private final SelenideElement username = $(AppiumBy.id("ru.otus.wishlist:id/username"));

  public void assertUserNameEqualsTo(String value) {
    username.shouldHave(text(value));
  }

  public void clickByUser() {
    item
        .shouldBe(visible)
        .click();
  }
}
