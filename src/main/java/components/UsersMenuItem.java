package components;

import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class UsersMenuItem extends AbsComponents<UsersMenuItem> {


  public UsersMenuItem(SelenideElement root) {
    super(root);
  }

  private final SelenideElement username = root.$(AppiumBy.id("ru.otus.wishlist:id/username"));

  public void assertUserNameEqualsTo(String value) {
    username.shouldHave(text(value));
  }

}
